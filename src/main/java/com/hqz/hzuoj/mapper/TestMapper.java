package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.Test;

public interface TestMapper {
    /**
     * 获取用户自测信息
     * @param testId
     * @return
     */
    Test findTest(Integer testId);

    /**
     * 更新自测
     * @param test
     */
    void update(Test test);
}
