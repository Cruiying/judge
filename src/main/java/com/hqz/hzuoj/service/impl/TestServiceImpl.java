package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.Test;
import com.hqz.hzuoj.mapper.TestMapper;
import com.hqz.hzuoj.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    /**
     * 获取自测信息
     * @param testId
     * @return
     */
    @Override
    public Test findTest(Integer testId) {
        return testMapper.findTest(testId);
    }

    /**
     * 更新自测
     * @param test
     * @return
     */
    @Override
    public Test update(Test test) {
        this.testMapper.update(test);
        return this.testMapper.findTest(test.getTestId());
    }
}
