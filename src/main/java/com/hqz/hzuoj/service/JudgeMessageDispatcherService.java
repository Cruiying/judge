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
     * @param completed
     */
    void onSubmitErrorOccurred(Integer submitId, Submit submit, boolean completed);

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
     * @param completed
     */
    void onSubmitCompileFinished(Integer submitId, Submit submit, boolean completed);

    /**
     * 测试点运行完成
     * @param submitId
     * @param submit
     * @param submitCase
     * @param completed
     */
    void submitOneTestPointFinished(Integer submitId, Submit submit, SubmitCase submitCase, boolean completed);

    /**
     * 所有测试点运行完成
     * @param submitId
     * @param submit
     * @param completed
     */
    void submitAllTestPointsFinished(Integer submitId, Submit submit, boolean completed);
}
