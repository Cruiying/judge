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

bool setupIoRedirection(STARTUPINFO&, std::string, std::string, HANDLE&, HANDLE&);

const char* getstringToCharArray(string str);

int systemKillProcess(const char* cmd);

string dwordTostring(DWORD val);

bool createProcess(const std::string, HANDLE&, LPVOID, STARTUPINFO&, PROCESS_INFORMATION&);

DWORD runProcess(PROCESS_INFORMATION&, STARTUPINFO&, HANDLE& hInput, HANDLE& hOutput, int, int, int&, int&, int&);

int getMaxMemoryUsage(PROCESS_INFORMATION&, STARTUPINFO&, HANDLE& hInput, HANDLE& hOutput, int, int&);

int timeoutProcess(PROCESS_INFORMATION&, STARTUPINFO&, HANDLE& hInput, HANDLE& hOutput, int, int&);

int getCurrentMemoryUsage(HANDLE&);

long long getMillisecondsNow();

bool killProcess(PROCESS_INFORMATION&, STARTUPINFO&, HANDLE& hInput, HANDLE& hOutput);

DWORD getExitCode(HANDLE&);

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
class SystemResource {
private:
	HANDLE hInput = { 0 };
	HANDLE hOutput = { 0 };
	HANDLE hToken = { 0 };
	LPVOID lpEnvironment = NULL;
	PROCESS_INFORMATION process = { 0 };
	STARTUPINFO        startup = { 0 };
public:
	HANDLE getHInput() {
		return this->hInput;
	}
	void setHInput(HANDLE hInput) {
		this->hInput = hInput;
	}
	HANDLE getHOutput() {
		return this->hOutput;
	}
	HANDLE setHOutput(HANDLE hOutput) {
		return this->hOutput;
	}
	HANDLE getHToken() {
		return this->hToken;
	}
	void setHToken(HANDLE hToken) {
		this->hToken = hToken;
	}
	LPVOID getLpEnvironment() {
		return this->lpEnvironment;
	}
	void setLpEnvironment(LPVOID lpEnvironment) {
		this->lpEnvironment = lpEnvironment;
	}
	PROCESS_INFORMATION getProcess() {
		return this->process;
	}
	void setProcess(PROCESS_INFORMATION process) {
		this->process = process;
	}
	STARTUPINFO getStartup() {
		return this->startup;
	}
	void setStartup(STARTUPINFO startup) {
		this->startup = startup;
	}
};

class Runtime {
private:
	Result result;
	Response response;
	SystemResource systemResource;
	/**
	   设置IO重定向
	*/
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
			this->systemResource.setHInput(CreateFileW(inputFilePath.c_str(), GENERIC_READ, 0, &sa, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL));
			/** 判断是否获得句柄 **/
			if (systemResource.getHInput() == INVALID_HANDLE_VALUE) {
				return false;
			}
		}
		/*判断文件不能为空*/
		if (!outputFilePath.empty()) {
			/*输出文件局部*/
			this->systemResource.setHOutput(CreateFileW(outputFilePath.c_str(), GENERIC_READ | GENERIC_WRITE, FILE_SHARE_READ | FILE_SHARE_WRITE, &sa, CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, NULL));
			/** 判断是否获得句柄 **/
			if (systemResource.getHOutput() == INVALID_HANDLE_VALUE) {
				return false;
			}
		}
		STARTUPINFO  startup = this->systemResource.getStartup();
		startup.cb = sizeof(STARTUPINFO);
		startup.dwFlags = STARTF_USESHOWWINDOW | STARTF_USESTDHANDLES;
		startup.wShowWindow = SW_HIDE;
		/*重定向进程输入*/
		startup.hStdInput = this->systemResource.getHInput();
		/*重定向进程输出*/
		startup.hStdError = this->systemResource.getHOutput();
		/*重定向进程错误输出*/
		startup.hStdOutput = this->systemResource.getHOutput();
		this->systemResource.setStartup(startup);
		return true;
	}
	/** 创建进程 **/
	bool createProcess() {
	    string commandLine = this.response.getCmd;
    	char cmd[1000];
    	int i = 0;
    	for (i = 0; i < commandLine.length(); i++)
    		cmd[i] = commandLine[i];
    	cmd[i] = '\0';
    	//创建进程
    	return CreateProcessA(NULL, cmd, NULL, NULL, TRUE, CREATE_SUSPENDED, NULL, NULL, &this.systemResource.getStartup(), &this.systemResource.getProcess());
    }
    /** 运行进程 **/
    int runProcess() {
    	/*唤醒进程*/
    	ResumeThread(this->systemResource.getProcess().hThread);
    	/*异步监听内存情况*/
    	auto f1 = std::async(std::launch::async, getMaxMemoryUsage, ref(processInfo), ref(startupInfo), ref(hInput), ref(hOutput), ref(memoryLimit), ref(exitCode));
    	/*异步监听运行时间*/
    	auto f2 = std::async(std::launch::async, timeoutProcess, ref(processInfo), ref(startupInfo), ref(hInput), ref(hOutput), ref(timeLimit), ref(exitCode));
    	/*开始时间*/
    	long long startTime = getMillisecondsNow();
    	/*等待进程运行结束*/
    	WaitForSingleObject(processInfo.hProcess, timeLimit);
    	/*结束时间*/
    	long long endTime = getMillisecondsNow();
    	/*计算运行时间*/
    	timeUsage = f2.get();
    	/*获取内存*/
    	memoryUsage = f1.get();
    	/*进程是否运行结束*/
    	if (getExitCode(processInfo.hProcess) == STILL_ACTIVE) {
    		exitCode = 1;
    		/*关闭进程*/
    		killProcess(processInfo, startupInfo, hInput, hOutput);
    	}
    	exitCode = 0;
    	return getExitCode(processInfo.hProcess);
    }

public:
	Result getResult() {
		return this->result;
	}
	void setResult(Result result) {
		this->result = result;
	}
	Response getResponse() {
		return this->response;
	}
	void setResponse(Response response) {
		return this->response;
	}

	void run() {
	    try {

	        /** 判断重定向是否成功 **/
            if (!this->setupIoRedirection()) {
                return ;
            }
            /** 判断进程是否创建成功 **/
            if(!this->createProcess()) {
                return ;
            }
        } catch(const std::exception&) {

        }
	}


};

int main() {
	HANDLE hInput = { 0 };
	HANDLE hOutput = { 0 };
	HANDLE hToken = { 0 };
	LPVOID lpEnvironment = NULL;
	PROCESS_INFORMATION processInfo = { 0 };
	STARTUPINFO        startupInfo = { 0 };
	string cmd = "D:\\code\\b.exe";
	string input = "D:\\code\\a.txt";
	string output = "D:\\code\\b.txt";
	int timeLimit = 1000;
	int memoryLimit = 5555555;

	try {
		cout << "重定向:" << setupIoRedirection(startupInfo, input, output, hInput, hOutput) << endl;
		cout << "创建进程：" << createProcess(cmd, hToken, lpEnvironment, startupInfo, processInfo) << endl;
		runProcess(processInfo, startupInfo, hInput, hOutput, timeLimit, memoryLimit, timeUsage, memoryUsage, exitCode);

	}
	catch (const std::exception&) {

	}
	CloseHandle(hInput);
	CloseHandle(hOutput);
	cout << "-------------" << endl;
	cout << "运行时间：" << timeUsage << endl;
	cout << "运行内存：" << memoryUsage << endl;
	cout << "退出状态：" << exitCode << endl;
	return 0;
}

/**
 * 重定向子进程的I/O.
 * @param startupInfo - STARTUPINFOW结构体
 * @param inputFilePath  - 输入文件路径
 * @param outputFilePath - 输出文件路径
 * @param hInput         - 输入文件句柄
 * @param hOutput        - 输出文件句柄
 */
bool setupIoRedirection(STARTUPINFO& startupInfo, std::string input, std::string output, HANDLE& hInput, HANDLE& hOutput) {
	SECURITY_ATTRIBUTES sa;
	sa.nLength = sizeof(sa);
	sa.lpSecurityDescriptor = NULL;
	sa.bInheritHandle = TRUE;
	wstring inputFilePath = getWidestring(input);
	wstring outputFilePath = getWidestring(output);
	/*判断字符串不能为空*/
	if (!inputFilePath.empty()) {
		/*输入文件句柄*/
		hInput = CreateFileW(inputFilePath.c_str(), GENERIC_READ, 0, &sa, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);
		if (hInput == INVALID_HANDLE_VALUE) {
			return false;
		}
	}
	/*判断文件不能为空*/
	if (!outputFilePath.empty()) {
		/*输出文件局部*/
		hOutput = CreateFileW(outputFilePath.c_str(), GENERIC_READ | GENERIC_WRITE, FILE_SHARE_READ | FILE_SHARE_WRITE, &sa, CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, NULL);
		if (hOutput == INVALID_HANDLE_VALUE) {
			return false;
		}
	}
	startupInfo.cb = sizeof(STARTUPINFO);
	startupInfo.dwFlags = STARTF_USESHOWWINDOW | STARTF_USESTDHANDLES;
	startupInfo.wShowWindow = SW_HIDE;
	/*重定向进程输入*/
	startupInfo.hStdInput = hInput;
	/*重定向进程输出*/
	startupInfo.hStdError = hOutput;
	/*重定向进程错误输出*/
	startupInfo.hStdOutput = hOutput;
	return true;
}

/**
 * 创建进程.
 * @param  commandLine   待执行的命令行
 * @return 进程是否创建成功
 */
bool createProcess(const std::string commandLine, HANDLE& hToken, LPVOID lpEnvironment, STARTUPINFO& startupInfo, PROCESS_INFORMATION& processInfo) {
	char cmd[1000];
	int i = 0;
	for (i = 0; i < commandLine.length(); i++)
		cmd[i] = commandLine[i];
	cmd[i] = '\0';
	//创建进程
	bool success = CreateProcessA(NULL, cmd, NULL, NULL, TRUE, CREATE_SUSPENDED, NULL, NULL, &startupInfo, &processInfo);
	return success;
}
/**
 * 运行进程.
 * @param  processInfo - 包含进程信息的PROCESS_INFORMATION结构体
 * @param  timeLimit   - 运行时时间限制(ms)
 * @param  memoryLimit - 运行时空间限制(KB)
 * @param  timeUsage   - 运行时时间占用(ms)
 * @param  memoryUsage - 运行时空间占用(ms)
 * @return 进程退出状态
 */
DWORD runProcess(PROCESS_INFORMATION& processInfo, STARTUPINFO& startupInfo, HANDLE& hInput, HANDLE& hOutput, int timeLimit, int memoryLimit, int& timeUsage, int& memoryUsage, int& exitCode) {
	/*唤醒进程*/
	ResumeThread(processInfo.hThread);
	/*异步监听内存情况*/
	auto f1 = std::async(std::launch::async, getMaxMemoryUsage, ref(processInfo), ref(startupInfo), ref(hInput), ref(hOutput), ref(memoryLimit), ref(exitCode));
	/*异步监听运行时间*/
	auto f2 = std::async(std::launch::async, timeoutProcess, ref(processInfo), ref(startupInfo), ref(hInput), ref(hOutput), ref(timeLimit), ref(exitCode));
	/*开始时间*/
	long long startTime = getMillisecondsNow();
	/*等待进程运行结束*/
	WaitForSingleObject(processInfo.hProcess, timeLimit);
	/*结束时间*/
	long long endTime = getMillisecondsNow();
	/*计算运行时间*/
	timeUsage = f2.get();
	/*获取内存*/
	memoryUsage = f1.get();
	/*进程是否运行结束*/
	if (getExitCode(processInfo.hProcess) == STILL_ACTIVE) {
		exitCode = 1;
		/*关闭进程*/
		killProcess(processInfo, startupInfo, hInput, hOutput);
	}
	exitCode = 0;
	return getExitCode(processInfo.hProcess);
}
/**
 * 获取运行时内存占用最大值
 * @param  processInfo - 包含进程信息的PROCESS_INFORMATION结构体
 * @param  memoryLimit - 运行时空间限制(KB)
 * @return 运行时内存占用最大值
 */
int getMaxMemoryUsage(PROCESS_INFORMATION& processInfo, STARTUPINFO& startupInfo, HANDLE& hInput, HANDLE& hOutput, int memoryLimit, int& exitCode) {
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
		if (memoryLimit != 0 && currentMemoryUsage > memoryLimit) {
			/*内存超限，杀死进程*/
			killProcess(processInfo, startupInfo, hInput, hOutput);
			exitCode = 1;
			break;
		}
	} while (getExitCode(processInfo.hProcess) == STILL_ACTIVE);
	return maxMemoryUsage;
}
/*监听程序运行时间*/
int timeoutProcess(PROCESS_INFORMATION& processInfo, STARTUPINFO& startupInfo, HANDLE& hInput, HANDLE& hOutput, int timeLimit, int& exitCode) {
	/*开始时间*/
	long long startTime = getMillisecondsNow();
	long long timeUsage = 0;
	do {
		/*结束时间*/
		long long endTime = getMillisecondsNow();
		timeUsage = endTime - startTime;
		/*休眠10ms*/
		Sleep(10);
		if (timeUsage >= timeLimit) {
			/*时间超限，杀死进程*/
			killProcess(processInfo, startupInfo, hInput, hOutput);
			exitCode = 1;
			break;
		}
	} while (getExitCode(processInfo.hProcess) == STILL_ACTIVE);
	return timeUsage;
}
/**
 * 获取进程内存占用情况.
 * @param  hProcess - 进程句柄
 * @return 当前物理内存使用量(KB)
	*/
int getCurrentMemoryUsage(HANDLE& hProcess) {
	PROCESS_MEMORY_COUNTERS pmc;
	int  currentMemoryUsage = 0;
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

/**
 * 获取当前系统时间.
 * 用于统计程序运行时间.
 * @return 当前系统时间(以毫秒为单位)
 */
long long getMillisecondsNow() {
	return GetTickCount();
}
/**
 * 强制销毁进程.
 * @param  processInfo - 包含进程信息的PROCESS_INFORMATION结构体
 * @return 销毁进程操作是否成功完成
 */
bool killProcess(PROCESS_INFORMATION& processInfo, STARTUPINFO& startupInfo, HANDLE& hInput, HANDLE& hOutput) {
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
				systemKillProcess(cmd);
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

/**
 * 执行杀死进程命令
 * @param  执行命令
 * @return 销毁进程操作是否成功完成
 */
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
 * 获取应用程序退出状态.
 * 0表示正常退出, 259表示仍在运行.
 * @param  hProcess - 进程的句柄
 * @return 退出状态
 */
DWORD getExitCode(HANDLE& hProcess) {
	DWORD exitCode = 0;
	GetExitCodeProcess(hProcess, &exitCode);
	return exitCode;
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
