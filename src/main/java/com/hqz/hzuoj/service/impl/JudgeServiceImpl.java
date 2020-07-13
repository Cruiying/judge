package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.common.constants.ConfigConstants;
import com.hqz.hzuoj.entity.DTO.JudgeDataDTO;
import com.hqz.hzuoj.entity.DTO.JudgeResultDTO;
import com.hqz.hzuoj.service.JudgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 命令执行器
 */
@Service
@Slf4j
public class JudgeServiceImpl implements JudgeService {

    @Autowired
    private ConfigConstants config;

    private JudgeResultDTO runner(JudgeDataDTO judgeDataDTO) {
        ProcessBuilder processBuilder = new ProcessBuilder(config.judge);
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

    @Override
    public JudgeResultDTO getCompileResult(JudgeDataDTO judgeDataDTO) {
        judgeDataDTO.setMemoryLimit(1024 * 128);
        judgeDataDTO.setTimeLimit(15000);
        return runner(judgeDataDTO);
    }

    /**
     * 执行运行命令
     */
    @Override
    public JudgeResultDTO getRuntimeResult(JudgeDataDTO judgeDataDTO) {
        return runner(judgeDataDTO);
    }
}
