package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.DTO.JudgeDataDTO;
import com.hqz.hzuoj.entity.DTO.RunnerResultDTO;
import com.hqz.hzuoj.entity.model.Language;

public interface RunnerService {

    public RunnerResultDTO getRuntimeResult(Language language, String workDirectory, String baseFileName, JudgeDataDTO judgeDataDTO);
}
