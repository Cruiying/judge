package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.common.constants.ConfigConstants;
import com.hqz.hzuoj.common.util.DigestUtils;
import com.hqz.hzuoj.entity.DTO.CompileResultDTO;
import com.hqz.hzuoj.entity.DTO.JudgeDataDTO;
import com.hqz.hzuoj.entity.DTO.RunnerResultDTO;
import com.hqz.hzuoj.entity.model.*;
import com.hqz.hzuoj.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测评调度器
 */
@Service
@Slf4j
public class JudgeDispatcherServiceImpl implements JudgeDispatcherService {

    @Resource
    private LanguageService languageService;

    @Resource
    private JudgeResultService judgeResultService;

    @Resource
    private SubmitCaseService submitCaseService;

    @Resource
    private ConfigConstants config;

    @Resource
    private JudgeMessageDispatcherService judgeMessageDispatcherService;

    @Resource
    private SubmitService submitService;

    @Resource
    private ProblemService problemService;

    @Resource
    private PreprocessorService preprocessorService;

    @Resource
    private CompilerService compilerService;

    @Resource
    private RunnerService runnerService;

    @Resource
    private ProblemDataService problemDataService;

    @Resource
    private ComparatorService comparatorService;


    /**
     * 运行用户提交
     *
     * @param submitId
     */
    @Override
    public void RunningSubmit(Integer submitId) {
        Submit submit = submitService.queryById(submitId);
        if (submit == null) {
            judgeMessageDispatcherService.onSubmitErrorOccurred(submitId, new Submit(), true);
            return;
        }
        /**
         * 创建运行目录和文件
         */
        String randomName = DigestUtils.getRandomString(12, DigestUtils.Mode.ALPHA);
        String baseDirectory = String.format("%s/%s", config.judgeOutputPath, randomName);
        String baseFileName = DigestUtils.getRandomString(12, DigestUtils.Mode.ALPHA);
        try {
            submitCaseService.deleteBySubmitId(submit.getSubmitId());
            //预处理用户提交所需要的资源
            if (!submitPreprocess(submit, baseDirectory, baseFileName)) {
                judgeMessageDispatcherService.onSubmitErrorOccurred(submitId, submit, true);
                return;
            }
            //发送开始编译代码消息
            judgeMessageDispatcherService.onSubmitCompile(submitId, submit);
            //编译代码
            if (!submitCompile(submit, baseDirectory, baseFileName)) {
                //编译失败
                return;
            }
            //运行
            SubmitRun(submit, baseDirectory, baseFileName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //运行完成，清理程序运行输出
            cleanUp(baseDirectory);
        }
    }
    /**
     * 完成用户提交评测前的预处理工作.
     * 说明: 随机文件名用于防止应用程序自身递归调用.
     *
     * @param submit        - 用户评测记录对象
     * @param workDirectory - 用于产生编译输出的目录
     * @param baseFileName  - 随机文件名(不包含后缀)
     */
    private boolean submitPreprocess(Submit submit, String workDirectory, String baseFileName) {
        try {
            //获取题目信息
            Problem problem = problemService.queryById(submit.getProblemId());
            //加载题目数据
            String s = preprocessorService.loadProblemData(problem);
            //判断题目题目数据是否加载成功
            if ("error".equals(s)) {
                return false;
            }
            Language language = languageService.queryById(submit.getLanguageId());
            //创建源代码到本地文件
            preprocessorService.createRuntimeCode(submit.getCode(), language, workDirectory, baseFileName);
            return true;
        } catch (Exception ex) {
            log.error("提交预处理错误: {}", ex.getMessage());
        }
        return false;
    }

    /**
     * 创建用户提交的编译任务.
     * 说明: 随机文件名用于防止应用程序自身递归调用.
     *
     * @param submit        - 评测记录对象
     * @param workDirectory - 用于产生编译输出的目录
     * @param baseFileName  - 随机文件名(不包含后缀)
     */
    private boolean submitCompile(Submit submit, String workDirectory, String baseFileName) {
        //获取语言
        Language language = languageService.queryById(submit.getLanguageId());
        //获取编译结果
        CompileResultDTO compileResult = compilerService.getCompileResult(language, workDirectory, baseFileName);
        //发送编译结果给用户
        judgeMessageDispatcherService.onSubmitCompileFinished(submit.getSubmitId(), submit, compileResult, compileResult.getCompileSuccess());
        //返回编译状态
        return compileResult.getCompileSuccess();
    }
    /**
     * 执行用户提交的测评程序.
     *
     * @param submit        - 评测记录对象
     * @param workDirectory - 编译生成结果的目录以及程序输出的目录
     * @param baseFileName  - 待执行的应用程序文件名(不包含文件后缀)
     */
    private void SubmitRun(Submit submit, String workDirectory, String baseFileName) throws NotFoundException {
        ArrayList<SubmitCase> submitCases = new ArrayList<>();
        try {
            Integer submitId = submit.getSubmitId();
            Integer problemId = submit.getProblemId();
            List<ProblemData> problemDataList = problemDataService.findProblemDatas(problemId);
            if (problemDataList == null || problemDataList.size() == 0) {
                judgeMessageDispatcherService.onSubmitErrorOccurred(submitId, submit, true);
                return;
            }
            int size = problemDataList.size();
            int acceptedTotal = 0, usedTime = 0, usedMemory = 0;
            Language language = languageService.queryById(submit.getLanguageId());
            for (ProblemData problemData : problemDataList) {
                SubmitCase submitCase = new SubmitCase();
                try {
                    int problemDataId = problemData.getProblemDataId();
                    int score = 0;
                    String inputFilePath = config.problemDataPath + "/" + problemId + "/" + problemData.getInputPath();
                    String stdOutputFilePath = config.problemDataPath + "/" + problemId + "/" + problemData.getOutputPath();
                    String outputFilePath = String.format("%s/output#%s.txt", workDirectory, problemDataId);
                    //封装运行所需数据
                    JudgeDataDTO judgeData = new JudgeDataDTO();
                    judgeData.setInputPath(inputFilePath);
                    judgeData.setOutputPath(outputFilePath);
                    judgeData.setTimeLimit(problemData.getMaxRuntimeTime());
                    judgeData.setMemoryLimit(problemData.getMaxRuntimeMemory());
                    //运行测试点
                    RunnerResultDTO runnerResult = runnerService.getRuntimeResult(language, workDirectory, baseFileName, judgeData);
                    //所有测试点中运行时间的最大值
                    usedTime = Integer.max(usedTime, runnerResult.getUsedTime());
                    //所有测试点中运行内存的最大值
                    usedMemory = Integer.max(usedMemory, runnerResult.getUsedMemory());
                    //判断运行是否成功
                    String runtimeResultAbbr = getRuntimeResult(runnerResult, stdOutputFilePath, outputFilePath);
                    if ("AC".equals(runtimeResultAbbr)) {
                        acceptedTotal++;
                        score = 100;
                    }
                    //封装结果
                    submitCase.setScore(score);
                    submitCase.setRuntimeMemory(runnerResult.getUsedMemory());
                    submitCase.setRuntimeTime(runnerResult.getUsedTime());
                    submitCase.setJudgeResultId(judgeResultService.findJudgeResultByJudgeNameAbbr(runtimeResultAbbr).getJudgeResultId());
                    submitCases.add(submitCase);
                    submit.setRuntimeMemory(usedMemory);
                    submit.setRuntimeTime(usedTime);
                    submit.setScore(acceptedTotal * 100 / size);
                    /*一个测试运行完成*/
                    judgeMessageDispatcherService.submitOneTestPointFinished(submitId, submit, submitCase, false);
                } catch (Exception e) {
                    /*系统发生错误*/
                    judgeMessageDispatcherService.submitOneTestPointFinished(submitId, submit, submitCase, false);
                    log.error("一个测试点发生系统错误: {}", e.getMessage());
                }
            }
            /*程序运行完成*/
            judgeMessageDispatcherService.submitAllTestPointsFinished(submitId, submit, submitCases, true);
        } catch (Exception e) {
            /*系统发生错误*/
            judgeMessageDispatcherService.onSubmitErrorOccurred(submit.getSubmitId(), submit, true);
            log.error("发生错误: {}", e.getMessage());
        }
    }

    /**
     * 获取程序运行结果(及答案比对结果).
     *
     * @param result                 - 包含程序运行结果的Map对象
     * @param standardOutputFilePath - 标准输出文件路径
     * @param outputFilePath         - 用户输出文件路径
     * @return 包含程序运行结果的Map对象
     */
    private String getRuntimeResult(RunnerResultDTO result, String standardOutputFilePath, String outputFilePath) {
        if ("AC".equals(result.getResult())) {
            if (comparatorService.isOutputTheSame(standardOutputFilePath, outputFilePath)) {
                return "AC";
            } else {
                return "WA";
            }
        }
        return result.getResult();
    }
    /**
     * 运行用户自测
     *
     * @param testId
     */
    @Override
    public void RunningTest(Integer testId) {

    }


    /**
     * 评测完成后, 清理所生成的文件.
     *
     * @param baseDirectory - 用于产生输出结果目录
     */
    private void cleanUp(String baseDirectory) {
        File file = new File(baseDirectory);
        try {
            FileUtils.cleanDirectory(file);
        } catch (IOException e) {
            log.error("文件清除失败: {}", e.getMessage());
        }

    }
}
