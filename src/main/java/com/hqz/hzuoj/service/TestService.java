package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.Test;

public interface TestService {
    /**
     * 获取自测信息
     * @param testId
     * @return
     */
    Test findTest(Integer testId);

    /**
     * 更新自测
     * @param test
     */
    Test update(Test test);
}
