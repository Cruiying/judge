package com.hqz.hzuoj.service;

import com.hqz.hzuoj.common.constants.Constants;
import com.hqz.hzuoj.entity.model.Submit;
import com.hqz.hzuoj.entity.model.Test;

public interface JudgeDispatcherService {

    /**
     * 运行用户提交
     * @param submitId
     */
    public void RunningSubmit(Integer submitId);

    /**
     * 运行用户自测
     * @param testId
     */
    public void RunningTest(Integer testId);
}
