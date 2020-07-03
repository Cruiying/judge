package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.DTO.JudgeDataDTO;
import com.hqz.hzuoj.entity.DTO.JudgeResultDTO;

public interface JudgeService {

    public JudgeResultDTO getCompileResult(JudgeDataDTO judgeDataDTO);

    public JudgeResultDTO getRuntimeResult(JudgeDataDTO judgeDataDTO);
}
