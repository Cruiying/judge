package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.DTO.JudgeDataDTO;
import com.hqz.hzuoj.entity.DTO.ResultDTO;
import com.hqz.hzuoj.service.JudgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class JudgeServiceImpl implements JudgeService {

    @Value("judge")
    private String judge;


    private ResultDTO runner(JudgeDataDTO judgeDataDTO) {
        ProcessBuilder processBuilder = new ProcessBuilder(judge);
        try {
            processBuilder.redirectInput();
            processBuilder.redirectOutput();
            Process process = processBuilder.start();
        }catch (Exception e) {
            log.error(e.getMessage());
        }finally {
            processBuilder.directory();
        }
        return null;
    }


    public ResultDTO getCompileResult(JudgeDataDTO judgeDataDTO) {
        judgeDataDTO.setMemoryLimit(1024 * 128);
        judgeDataDTO.setTimeLimit(15000);
        return runner(judgeDataDTO);
    }

    /**
     * 执行运行命令
     */
    public ResultDTO getRuntimeResult(JudgeDataDTO judgeDataDTO) {
        return runner(judgeDataDTO);
    }
}
