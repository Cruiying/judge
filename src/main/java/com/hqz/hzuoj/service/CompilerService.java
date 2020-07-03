package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.DTO.CompileResultDTO;
import com.hqz.hzuoj.entity.model.Language;

public interface CompilerService {
    public CompileResultDTO getCompileResult(Language language, String workDirectory, String baseFileName);
}
