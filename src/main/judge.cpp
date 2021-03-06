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
		return this->inputPath;
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
		return this->timeLimit;
	}
	void setTimeLimit(int timeLimit) {
		this->timeLimit = timeLimit;
	}
	int getMemoryLimit() {
		return this->memoryLimit;
	}
	void setMemoryLimit(int memoryLimit) {
		this->memoryLimit = memoryLimit;
	}
};
class SystemResource {
private:
	HANDLE hInput = { 0 };
	HANDLE hOutput = { 0 };
	HANDLE hToken = { 0 };
	LPVOID lpEnvironment = NULL;
	PROCESS_INFORMATION process = { 0 };
	STARTUPINFO        startup = { 0 };
public:
	HANDLE& getHInput() {
		return this->hInput;
	}
	void setHInput(HANDLE& hInput) {
		this->hInput = hInput;
	}
	HANDLE& getHOutput() {
		return this->hOutput;
	}
	void setHOutput(HANDLE& hOutput) {
		this->hOutput = hOutput;
	}
	HANDLE& getHToken() {
		return this->hToken;
	}
	void setHToken(HANDLE& hToken) {
		this->hToken = hToken;
	}
	LPVOID& getLpEnvironment() {
		return this->lpEnvironment;
	}
	void setLpEnvironment(LPVOID& lpEnvironment) {
		this->lpEnvironment = lpEnvironment;
	}
	PROCESS_INFORMATION& getProcess() {
		return this->process;
	}
	void setProcess(PROCESS_INFORMATION& process) {
		this->process = process;
	}
	STARTUPINFO& getStartup() {
		return this->startup;
	}
	void setStartup(STARTUPINFO& startup) {
		this->startup = startup;
	}
	~SystemResource() {
		CloseHandle(hInput);
		CloseHandle(hOutput);
	}
};

/** 获取运行资源 **/
Response readResponse();

/** 保存运行状态 **/
void saveResult(Result& result);

/** 释放资源 **/
void freeSystemResource(SystemResource& systemResource);

/** 重定向子进程的I/O. **/
bool setupIoRedirection(SystemResource& systemResource, Result& result, Response& respone);

/** 创建进程. **/
bool createProcess(SystemResource& systemResource, Result& result, Response& respone);

/** 运行进程. **/
Result runProcess(SystemResource& systemResource, Result& result, Response& response);

/** 获取运行时内存占用最大值 **/
Result getMaxMemoryUsage(SystemResource& systemResource, Result& result, Response& response);

/** 监听程序运行时间 **/
Result timeoutProcess(SystemResource& systemResource, Result& result, Response& response);

/** 获取进程内存占用情况. **/
int getCurrentMemoryUsage(HANDLE& hProcess);

/** 获取当前系统时间. **/
long long getMillisecondsNow();

/** 强制销毁进程. **/
bool killProcess(SystemResource& systemResource, Result& result, Response& response);

/** 执行杀死进程命令 **/
int systemKillProcess(const char* cmd);

/** 将string转为const char **/
const char* getstringToCharArray(string str);

/** DWORD转strning **/
string dwordTostring(DWORD val);

/** 获取应用程序退出状态. */
DWORD getExitCode(HANDLE& hProcess);

/** 获取std::wstring类型的字符串. **/
std::wstring getWidestring(const std::string& str);

/** 获取std::wstring对应LPWSTR类型的指针. **/
LPWSTR getWidestringPointer(const std::wstring& str);

/** 获取std::wstring对应LPCWSTR类型的指针. **/
LPCWSTR getConstWidestringPointer(const std::wstring& str);

int main() {
	Result result = Result();
	SystemResource systemResource = SystemResource();
	try {
		Response response = readResponse();
		/** 判断重点向IO 与 创建进程是否成功 **/
		if (setupIoRedirection(systemResource, result, response) && createProcess(systemResource, result, response)) {
			result = runProcess(systemResource, result, response);
		}
		saveResult(result);
	}
	catch (const std::exception & e) {
		saveResult(result);
	}
	freeSystemResource(systemResource);
	return 0;
}
/** 输入运行命令和输入输出文件路径以及内存与时间限制 **/
Response readResponse() {
	Response response = Response();
	string cmd, inputPath, outputPath;
	int timeLimit, memoryLimit;
	cin >> cmd >> inputPath >> outputPath >> timeLimit >> memoryLimit;
	response.setCmd(cmd);
	response.setInputPath(inputPath);
	response.setOutputPath(outputPath);
	response.setTimeLimit(timeLimit);
	response.setMemoryLimit(memoryLimit);
	return response;
}
/** 输出运行状态 **/
void saveResult(Result& result) {
	cout << "{" << endl;
	cout << " \"exitCode\":" << result.getExitCode() << "," << endl;
	cout << " \"timeUsage\":" << result.getTimeUsage() << "," << endl;
	cout << " \"memoryUsage\":" << result.getMemoryUsage() << endl;
	cout << "}" << endl;
}
/** 释放资源 **/
void freeSystemResource(SystemResource& systemResource) {
	HANDLE hInput = systemResource.getHInput();
	HANDLE hOutput = systemResource.getHOutput();
	CloseHandle(hInput);
	CloseHandle(hOutput);
}

/** 重定向子进程的I/O. **/
bool setupIoRedirection(SystemResource& systemResource, Result& result, Response& respone) {
	SECURITY_ATTRIBUTES sa;
	sa.nLength = sizeof(sa);
	sa.lpSecurityDescriptor = NULL;
	sa.bInheritHandle = TRUE;
	wstring inputFilePath = getWidestring(respone.getInputPath());
	wstring outputFilePath = getWidestring(respone.getOutputPath());
	STARTUPINFO startup = systemResource.getStartup();
	HANDLE hInput = systemResource.getHInput();
	/*判断字符串不能为空*/
	if (!inputFilePath.empty()) {
		/*输入文件句柄*/
		hInput = CreateFileW(inputFilePath.c_str(), GENERIC_READ, 0, &sa, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);
		if (hInput == INVALID_HANDLE_VALUE) {
			return false;
		}
	}
	/*判断文件不能为空*/
	HANDLE hOutput = systemResource.getHOutput();
	if (!outputFilePath.empty()) {
		/*输出文件句柄*/
		hOutput = CreateFileW(outputFilePath.c_str(), GENERIC_READ | GENERIC_WRITE, FILE_SHARE_READ | FILE_SHARE_WRITE, &sa, CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, NULL);
		if (hOutput == INVALID_HANDLE_VALUE) {
			return false;
		}
	}
	startup.cb = sizeof(STARTUPINFO);
	startup.dwFlags = STARTF_USESHOWWINDOW | STARTF_USESTDHANDLES;
	startup.wShowWindow = SW_HIDE;
	/*重定向进程输入*/
	startup.hStdInput = hInput;
	/*重定向进程输出*/
	startup.hStdError = hOutput;
	/*重定向进程错误输出*/
	startup.hStdOutput = hOutput;
	systemResource.setStartup(startup);
	return true;
}

/** 创建进程. **/
bool createProcess(SystemResource& systemResource, Result& result, Response& respone) {
	string commandLine = respone.getCmd();
	char cmd[1000];
	int i = 0;
	for (i = 0; i < commandLine.length(); i++)
		cmd[i] = commandLine[i];
	cmd[i] = '\0';
	//创建进程
	bool success = CreateProcessA(NULL, cmd, NULL, NULL, TRUE, CREATE_SUSPENDED, NULL, NULL, &systemResource.getStartup(), &systemResource.getProcess());
	return success;
}

/** 运行进程. **/
Result runProcess(SystemResource& systemResource, Result& result, Response& response) {
	/*唤醒进程*/
	ResumeThread(systemResource.getProcess().hThread);
	/*异步监听内存情况*/
	auto f1 = std::async(std::launch::async, getMaxMemoryUsage, ref(systemResource), ref(result), ref(response));
	/*异步监听运行时间*/
	auto f2 = std::async(std::launch::async, timeoutProcess, ref(systemResource), ref(result), ref(response));
	/*开始时间*/
	long long startTime = getMillisecondsNow();
	/*等待进程运行结束*/
	WaitForSingleObject(systemResource.getProcess().hProcess, response.getTimeLimit());
	/*结束时间*/
	long long endTime = getMillisecondsNow();
	/*计算运行时间*/
	Result r2 = f2.get();
	/*获取内存*/
	Result r1 = f1.get();
	/*进程是否运行结束*/
	PROCESS_INFORMATION process = systemResource.getProcess();
	if (getExitCode(process.hProcess) == STILL_ACTIVE) {
		result.setExitCode(1);
		/*关闭进程*/
		killProcess(systemResource, result, response);
	}
	result.setExitCode(result.getExitCode() | r1.getExitCode() | r2.getExitCode());
	result.setMemoryUsage(r1.getMemoryUsage());
	result.setTimeUsage(r2.getTimeUsage());
	return result;
}

/** 获取运行时内存占用最大值 **/
Result getMaxMemoryUsage(SystemResource& systemResource, Result& result, Response& response) {
	int maxMemoryUsage = 0, currentMemoryUsage = 0;
	PROCESS_INFORMATION process = systemResource.getProcess();
	result.setExitCode(0);
	do {
		/*获取进程内存*/
		currentMemoryUsage = getCurrentMemoryUsage(process.hProcess);
		/*判断当前内存是否的大小*/
		if (currentMemoryUsage > maxMemoryUsage) {
			maxMemoryUsage = currentMemoryUsage;
		}
		/*休眠10ms*/
		Sleep(10);
		/*判断内存是否超限*/
		if (response.getMemoryLimit() != 0 && currentMemoryUsage > response.getMemoryLimit()) {
			result.setExitCode(1);
			/*内存超限，杀死进程*/
			killProcess(systemResource, result, response);
			break;
		}

	} while (getExitCode(process.hProcess) == STILL_ACTIVE);
	result.setMemoryUsage(maxMemoryUsage);
	return result;
}

/** 监听程序运行时间 **/
Result timeoutProcess(SystemResource& systemResource, Result& result, Response& response) {
	/*开始时间*/
	PROCESS_INFORMATION process = systemResource.getProcess();
	long long startTime = getMillisecondsNow(), timeUsage = 0;
	result.setExitCode(0);
	do {
		/*结束时间*/
		long long endTime = getMillisecondsNow();
		timeUsage = endTime - startTime;
		/*休眠10ms*/
		Sleep(10);
		if (timeUsage >= response.getTimeLimit()) {
			result.setExitCode(1);
			/*时间超限，杀死进程*/
			killProcess(systemResource, result, response);
			break;
		}
	} while (getExitCode(process.hProcess) == STILL_ACTIVE);
	result.setTimeUsage(timeUsage);
	return result;
}

/** 获取进程内存占用情况. **/
int getCurrentMemoryUsage(HANDLE& hProcess) {
	PROCESS_MEMORY_COUNTERS pmc;
	int  currentMemoryUsage = 0;
	/** 获取进程内存 **/
	if (!GetProcessMemoryInfo(hProcess, &pmc, sizeof(pmc))) {
		return 0;
	}
	currentMemoryUsage = pmc.PeakWorkingSetSize >> 10;
	/** 如果内存获取失败 **/
	if (currentMemoryUsage < 0) {
		currentMemoryUsage = INT_MAX;
	}
	return currentMemoryUsage;
}

/** 获取当前系统时间. **/
long long getMillisecondsNow() {
	return GetTickCount();
}

/** 强制销毁进程. **/
bool killProcess(SystemResource& systemResource, Result& result, Response& response) {
	PROCESS_INFORMATION process = systemResource.getProcess();
	if (getExitCode(process.hProcess) == STILL_ACTIVE) {
		/** 获取进程id **/
		const string processId = dwordTostring(process.dwProcessId);
		const std::string str = "taskkill /pid " + processId + " -t -f";
		const char* cmd = str.c_str();

		try {
			if (getExitCode(process.hProcess) == STILL_ACTIVE) {
				DWORD           processId = process.dwProcessId;
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
			if (getExitCode(process.hProcess) == STILL_ACTIVE) {
				/*关闭线程*/
				TerminateProcess(process.hThread, 1);
				/*关闭进程*/
				TerminateProcess(process.hProcess, 1);
			}
		}
		catch (const std::exception & e) {}
		try {
			/*判断进程是否杀死*/
			if (getExitCode(process.hProcess) == STILL_ACTIVE) {
				/*使用命令system命令强制销毁进程*/
				system(cmd);
			}

		}
		catch (const std::exception&) {}
		try {
			/*判断进程是否杀死*/
			if (getExitCode(process.hProcess) == STILL_ACTIVE) {
				/*使用命令销毁进程*/
				systemKillProcess(cmd);
			}
		}
		catch (const std::exception&) {}
		/*释放进程句柄*/
		CloseHandle(process.hThread);
		CloseHandle(process.hProcess);
		if (getExitCode(process.hProcess) == STILL_ACTIVE) {
			return false;
		}
		return true;
	}
	return true;
}

/** 执行杀死进程命令 **/
int systemKillProcess(const char* cmd) {
	STARTUPINFOA si;
	ZeroMemory(&si, sizeof(si));
	si.cb = sizeof STARTUPINFO;
	PROCESS_INFORMATION pi = { 0 };
	if (CreateProcessA(NULL, (LPSTR)cmd, NULL, NULL, TRUE, NORMAL_PRIORITY_CLASS | CREATE_NO_WINDOW, NULL, NULL, &si, &pi)) {
		WaitForSingleObject(pi.hProcess, INFINITE);
		CloseHandle(pi.hProcess);
		CloseHandle(pi.hThread);
	}
	else {
		return true;
	}
	return false;
}

/** 将string转为const char **/
const char* getstringToCharArray(string str) {
	return str.c_str();
}

/** DWORD转strning **/
string dwordTostring(DWORD val) {
	string cur_str = to_string(long long(val));
	return cur_str;
}

/** 获取应用程序退出状态. */
DWORD getExitCode(HANDLE& hProcess) {
	DWORD exitCode = 0;
	GetExitCodeProcess(hProcess, &exitCode);
	return exitCode;
}

/** 获取std::wstring类型的字符串. **/
std::wstring getWidestring(const std::string& str) {
	std::wstring wstr(str.begin(), str.end());
	return wstr;
}

/** 获取std::wstring对应LPWSTR类型的指针. **/
LPWSTR getWidestringPointer(const std::wstring& str) {
	return const_cast<LPWSTR>(str.c_str());
}

/** 获取std::wstring对应LPCWSTR类型的指针. **/
LPCWSTR getConstWidestringPointer(const std::wstring& str) {
	return str.c_str();
}

