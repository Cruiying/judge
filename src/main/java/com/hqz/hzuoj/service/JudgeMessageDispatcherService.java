package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.DTO.CompileResultDTO;
import com.hqz.hzuoj.entity.model.Submit;
import com.hqz.hzuoj.entity.model.SubmitCase;

import java.util.List;

public interface JudgeMessageDispatcherService {
    /**
     * 提交发生错误
     * @param submitId
     * @param submit
     * @param b
     */
    void onSubmitErrorOccurred(Integer submitId, Submit submit, boolean b);

    /**
     * 代码开始编译
     * @param submitId
     * @param submit
     */
    void onSubmitCompile(Integer submitId, Submit submit);

    /**
     * 发送编译结果给用户
     * @param submitId
     * @param submit
     * @param compileResult
     * @param compileSuccess
     */
    void onSubmitCompileFinished(Integer submitId, Submit submit, CompileResultDTO compileResult, Boolean compileSuccess);

    /**
     * 测试点运行完成
     * @param submitId
     * @param submit
     * @param submitCase
     * @param usedTime
     * @param usedMemory
     * @param i
     * @param b
     */
    void submitOneTestPointFinished(Integer submitId, Submit submit, SubmitCase submitCase, int usedTime, int usedMemory, int i, boolean b);

    /**
     * 所有测试点运行完成
     * @param submitId
     * @param submit
     * @param submitCases
     * @param usedTime
     * @param usedMemory
     * @param i
     * @param b
     */
    void submitAllTestPointsFinished(Integer submitId, Submit submit, List<SubmitCase> submitCases, int usedTime, int usedMemory, int i, boolean b);
}
