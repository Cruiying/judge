package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.common.constants.Constants;
import com.hqz.hzuoj.entity.DTO.JudgeDataDTO;
import com.hqz.hzuoj.entity.DTO.JudgeResultDTO;
import com.hqz.hzuoj.entity.DTO.RunnerResultDTO;
import com.hqz.hzuoj.entity.model.Language;
import com.hqz.hzuoj.service.RunnerService;
import com.hqz.hzuoj.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 运行器
 */
@Service
public class RunnerServiceImpl implements RunnerService {

    @Autowired
    private JudgeService judgeService;

    /**
     * 获取运行结果
     * @param language
     * @param workDirectory
     * @param baseFileName
     * @param judgeDataDTO
     * @return
     */
    @Override
    public RunnerResultDTO getRuntimeResult(Language language, String workDirectory, String baseFileName, JudgeDataDTO judgeDataDTO) {
        /*获取程序运行命令*/
        String cmd = getRuntimeCmd(language, workDirectory, baseFileName);
        judgeDataDTO.setCmd(cmd);
        RunnerResultDTO result = new RunnerResultDTO();
        String runtimeResult = "SE";
        /*运行程序并，获取程序运行信息*/
        JudgeResultDTO judgeResult = judgeService.getCompileResult(judgeDataDTO);
        //根据程序运行信息封装运行结果
        runtimeResult = getRuntimeResult(judgeResult, judgeDataDTO);
        result.setResult(runtimeResult);
        result.setUsedTime(judgeResult.getUsedTime());
        result.setUsedMemory(judgeResult.getUsedMemory());
        return result;
    }


    /**
     * 封装运行结果
     * @param resultDTO
     * @param judgeDataDTO
     * @return
     */
    private String getRuntimeResult(JudgeResultDTO resultDTO, JudgeDataDTO judgeDataDTO) {
        if (resultDTO.getUsedTime() >= judgeDataDTO.getTimeLimit()) {
            return Constants.JudgeResult.Judge_Result_Abbr.TLE;
        }
        if (resultDTO.getUsedMemory() >= judgeDataDTO.getMemoryLimit()) {
            return Constants.JudgeResult.Judge_Result_Abbr.MLE;
        }
        if (resultDTO.getExitCode() == 0) {
            return Constants.JudgeResult.Judge_Result_Abbr.AC;
        }
        return Constants.JudgeResult.Judge_Result_Abbr.RE;
    }


    /**
     * 获取待执行的命令行.
     *
     * @param language      - 编译语言
     * @param workDirectory - 编译生成结果的目录以及程序输出的目录
     * @param baseFileName  - 待执行的应用程序文件名(不包含文件后缀)
     * @return 待执行的命令行
     */
    private String getRuntimeCmd(Language language, String workDirectory, String baseFileName) {
        String filePathWithoutExtension = String.format("%s/%s", new Object[]{workDirectory, baseFileName});
        StringBuilder cmd = new StringBuilder(language.getRuntimeCmd().replaceAll("\\{filename\\}", filePathWithoutExtension));
        if ("Java".equalsIgnoreCase(language.getName())) {
            int lastIndexOfSpace = cmd.lastIndexOf("/");
            cmd.setCharAt(lastIndexOfSpace, ' ');
        }
        return cmd.toString();
    }
}
