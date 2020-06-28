#include <iostream>
#include <cstdint>
#include <string.h>
#include <string>
#include <future>
#include <iostream>
#include <limits>
#include <sstream>
#include <string>
#include <thread>
#include <cstring>
#include <stdio.h>
#include <windows.h>
#include <userenv.h>
#include <psapi.h>
#include <tlhelp32.h>
#include <atlbase.h>
#include <ShellAPI.h>
using namespace std;

const char* getstringToCharArray(string str);

string dwordTostring(DWORD val);

long long getMillisecondsNow();

std::string getErrorMessage(const std::string&);

std::wstring getWidestring(const std::string&);

LPWSTR getWidestringPointer(const std::wstring&);

LPCWSTR getConstWidestringPointer(const std::wstring&);


class Result {
private:
	int timeUsage;
	int memoryUsage;
	int exitCode;
public:
	Result() {
		this->timeUsage = 0;
		this->memoryUsage = 0;
		this->exitCode = 1;
	}
	Result(int timeUsage, int memoryUsage, int exitCode) {
		this->timeUsage = timeUsage;
		this->memoryUsage = memoryUsage;
		this->exitCode = exitCode;
	}
	int getTimeUsage() {
		return this->timeUsage;
	}
	int getMemoryUsage() {
		return this->memoryUsage;
	}
	int getExitCode() {
		return this->exitCode;
	}
	void setTimeUsage(int timeUsage) {
		this->timeUsage = timeUsage;
	}
	void setMemoryUsage(int memoryUsage) {
		this->memoryUsage = memoryUsage;
	}
	void setExitCode(int exitCode) {
		this->exitCode = exitCode;
	}
};

class Response {
private:
	string cmd;
	string inputPath;
	string outputPath;
	int timeLimit;
	int memoryLimit;
public:
	string getCmd() {
		return cmd;
	}
	void setCmd(string cmd) {
		this->cmd = cmd;
	}
	string getInputPath() {
		return inputPath;
	}
	void setInputPath(string inputPath) {
		this->inputPath = inputPath;
	}
	string getOutputPath() {
		return outputPath;
	}
	void setOutputPath(string outputPath) {
		this->outputPath = outputPath;
	}
	int getTimeLimit() {
		return timeLimit;
	}
	void setTimeLimit(int timeLimit) {
		this->timeLimit = timeLimit;
	}
	int getMemoryLimit() {
		return memoryLimit;
	}
	void setMemoryLimit(int memoryLimit) {
		this->memoryLimit = memoryLimit;
	}
};

class Runtime {
private:
	HANDLE hInput = { 0 };
	HANDLE hOutput = { 0 };
	HANDLE hToken = { 0 };
	LPVOID lpEnvironment = NULL;
	PROCESS_INFORMATION process = { 0 };
	STARTUPINFO startup = { 0 };

public:



};

int main() {

}
Result run() {
	try {
		/** 判断重定向是否成功 **/
		if (!this->setupIoRedirection()) {
			return result;
		}
		/** 判断进程是否创建成功 **/
		if (!this->createProcess()) {
			return result;
		}
		/** 运行进程 **/
		this->runProcess();
		return result;
	}
	catch (const std::exception&) {
		return result;
	}
}
/** 获取应用程序退出状态 **/
int getExitCode(HANDLE& hProcess) {
	DWORD exitCode = 0;
	GetExitCodeProcess(hProcess, &exitCode);
	return exitCode;
}
/** 获取进程内存占用情况 **/
int getCurrentMemoryUsage(HANDLE& hProcess) {
	PROCESS_MEMORY_COUNTERS pmc;
	int currentMemoryUsage = 0;
	/*获取进程内存*/
	if (!GetProcessMemoryInfo(hProcess, &pmc, sizeof(pmc))) {
		return 0;
	}
	currentMemoryUsage = pmc.PeakWorkingSetSize >> 10;
	/*如果内存获取失败*/
	if (currentMemoryUsage < 0) {
		currentMemoryUsage = INT_MAX;
	}
	return currentMemoryUsage;
}
/** 重定向子进程的I/O **/
bool setupIoRedirection() {
	SECURITY_ATTRIBUTES sa;
	sa.nLength = sizeof(sa);
	sa.lpSecurityDescriptor = NULL;
	sa.bInheritHandle = TRUE;
	wstring inputFilePath = getWidestring(this->response.getInputPath());
	wstring outputFilePath = getWidestring(this->response.getOutputPath());
	/*判断字符串不能为空*/
	if (!inputFilePath.empty()) {
		/*输入文件句柄*/
		this->hInput = CreateFileW(inputFilePath.c_str(), GENERIC_READ, 0, &sa, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);
		/** 判断是否获得句柄 **/
		if (this->hInput == INVALID_HANDLE_VALUE) {
			return false;
		}
	}
	/*判断文件不能为空*/
	if (!outputFilePath.empty()) {
		/*输出文件局部*/
		this->hOutput = CreateFileW(outputFilePath.c_str(), GENERIC_READ | GENERIC_WRITE, FILE_SHARE_READ | FILE_SHARE_WRITE, &sa, CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, NULL);
		/** 判断是否获得句柄 **/
		if (this->hOutput == INVALID_HANDLE_VALUE) {
			return false;
		}
	}
	this->startup.cb = sizeof(STARTUPINFO);
	this->startup.dwFlags = STARTF_USESHOWWINDOW | STARTF_USESTDHANDLES;
	this->startup.wShowWindow = SW_HIDE;
	/** 重定向进程输入 **/
	this->startup.hStdInput = this->hInput;
	/** 重定向进程输出 **/
	this->startup.hStdError = this->hOutput;
	/** 重定向进程错误输出 **/
	this->startup.hStdOutput = this->hOutput;
	return true;
}
/** 杀死进程 **/
bool killProcess(PROCESS_INFORMATION& processInfo) {
	if (getExitCode(processInfo.hProcess) == STILL_ACTIVE) {
		const string processId = dwordTostring(processInfo.dwProcessId);
		const std::string str = "taskkill /pid " + processId + " -t -f";
		const char* cmd = str.c_str();
		try {
			if (getExitCode(processInfo.hProcess) == STILL_ACTIVE) {
				DWORD           processId = processInfo.dwProcessId;
				PROCESSENTRY32 processEntry = { 0 };
				processEntry.dwSize = sizeof(PROCESSENTRY32);
				HANDLE handleSnap = CreateToolhelp32Snapshot(TH32CS_SNAPPROCESS, 0);

				if (Process32First(handleSnap, &processEntry)) {
					BOOL isContinue = TRUE;

					do {
						if (processEntry.th32ParentProcessID == processId) {
							HANDLE hChildProcess = OpenProcess(PROCESS_ALL_ACCESS, FALSE, processEntry.th32ProcessID);
							if (hChildProcess) {
								TerminateProcess(hChildProcess, 1);
								CloseHandle(hChildProcess);
							}
						}
						isContinue = Process32Next(handleSnap, &processEntry);
					} while (isContinue);

					HANDLE hBaseProcess = OpenProcess(PROCESS_ALL_ACCESS, FALSE, processId);
					if (hBaseProcess) {
						TerminateProcess(hBaseProcess, 1);
						CloseHandle(hBaseProcess);
					}
				}
			}
		}
		catch (const std::exception&) {}
		try {
			/*判断进程是否已经被销毁*/
			if (getExitCode(processInfo.hProcess) == STILL_ACTIVE) {
				/*关闭线程*/
				TerminateProcess(processInfo.hThread, 1);
				/*关闭进程*/
				TerminateProcess(processInfo.hProcess, 1);
			}
		}
		catch (const std::exception & e) {}
		try {
			/*判断进程是否杀死*/
			if (getExitCode(processInfo.hProcess) == STILL_ACTIVE) {
				/*使用命令system命令强制销毁进程*/
				system(cmd);
			}

		}
		catch (const std::exception&) {}
		try {
			/*判断进程是否杀死*/
			if (getExitCode(processInfo.hProcess) == STILL_ACTIVE) {
				/*使用命令销毁进程*/
				//systemKillProcess(cmd);
			}
		}
		catch (const std::exception&) {}
		/*释放进程句柄*/
		CloseHandle(processInfo.hThread);
		CloseHandle(processInfo.hProcess);
		if (getExitCode(processInfo.hProcess) == STILL_ACTIVE) {
			return false;
		}
		return true;
	}
	return true;
}
/** 创建进程 **/
bool createProcess() {
	string commandLine = this->response.getCmd();
	char cmd[1000];
	int i = 0;
	for (i = 0; i < commandLine.length(); i++)
		cmd[i] = commandLine[i];
	cmd[i] = '\0';
	//创建进程
	return CreateProcessA(NULL, cmd, NULL, NULL, TRUE, CREATE_SUSPENDED, NULL, NULL, &this->startup, &this->process);
}
/** 运行进程 **/
int runProcess() {
	/*唤醒进程*/
	ResumeThread(this->process.hThread);
	/*异步监听内存情况*/
	auto f1 = std::async(std::launch::async, this->getMaxMemoryUsage, ref(this->process));
	/*异步监听运行时间*/
	auto f2 = std::async(std::launch::async, this->timeoutProcess, ref(this->process));
	/*开始时间*/
	long long startTime = getMillisecondsNow();
	/*等待进程运行结束*/
	WaitForSingleObject(this->process.hProcess, this->response.getTimeLimit());
	/*结束时间*/
	long long endTime = getMillisecondsNow();
	/*计算运行时间*/
	Result result2 = f2.get();
	/*获取内存*/
	Result result1 = f1.get();
	/*进程是否运行结束*/
	if (getExitCode(this->process.hProcess) == STILL_ACTIVE) {
		/*关闭进程*/
		killProcess(this->process);
	}
	return getExitCode(this->process.hProcess);
}
/** 获取进程占用时间 **/
Result timeoutProcess(PROCESS_INFORMATION& processInfo) {
	/*开始时间*/
	long long startTime = getMillisecondsNow();
	long long timeUsage = 0;
	do {
		/*结束时间*/
		long long endTime = getMillisecondsNow();
		timeUsage = endTime - startTime;
		/*休眠10ms*/
		Sleep(10);
		if (timeUsage >= this->response.getTimeLimit()) {
			/*时间超限，杀死进程*/
			killProcess(processInfo);
			break;
		}
	} while (getExitCode(processInfo.hProcess) == STILL_ACTIVE);
	return this->result;
}
/** 获取运行时内存占用最大值 **/
Result getMaxMemoryUsage(PROCESS_INFORMATION& processInfo) {
	int maxMemoryUsage = 0, currentMemoryUsage = 0;
	do {
		/*获取进程内存*/
		currentMemoryUsage = getCurrentMemoryUsage(processInfo.hProcess);
		/*判断当前内存是否的大小*/
		if (currentMemoryUsage > maxMemoryUsage) {
			maxMemoryUsage = currentMemoryUsage;
		}
		/*休眠10ms*/
		Sleep(10);
		/*判断内存是否超限*/
		if (this->response.getMemoryLimit() != 0 && currentMemoryUsage > this->response.getMemoryLimit()) {
			/*内存超限，杀死进程*/
			killProcess(processInfo);
			break;
		}
	} while (this->getExitCode(processInfo.hProcess) == STILL_ACTIVE);
	return this->result;
}


/**
 * 获取当前系统时间.
 * 用于统计程序运行时间.
 * @return 当前系统时间(以毫秒为单位)
 */
long long getMillisecondsNow() {
	return GetTickCount();
}

const char* getstringToCharArray(string str) {
	return str.c_str();
}
/*
DWORD转strning
*/
string dwordTostring(DWORD val) {
	string cur_str = to_string(long long(val));
	return cur_str;
}

/**
 * 获取std::wstring类型的字符串.
 * @param  str - std::string类型的字符串
 * @return wstring类型的字符串
 */
std::wstring getWidestring(const std::string& str) {
	std::wstring wstr(str.begin(), str.end());
	return wstr;
}

/**
 * 获取std::wstring对应LPWSTR类型的指针.
 * @param  str - std::wstring类型的字符串
 * @return 对应LPWSTR类型的指针
 */
LPWSTR getWidestringPointer(const std::wstring& str) {
	return const_cast<LPWSTR>(str.c_str());
}

/**
 * 获取std::wstring对应LPCWSTR类型的指针.
 * @param  str - std::wstring类型的字符串
 * @return 对应LPCWSTR类型的指针
 */
LPCWSTR getConstWidestringPointer(const std::wstring& str) {
	return str.c_str();
}
