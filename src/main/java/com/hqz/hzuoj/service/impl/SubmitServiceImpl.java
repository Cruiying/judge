package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.common.base.CurrentUser;
import com.hqz.hzuoj.common.exception.MyException;
import com.hqz.hzuoj.entity.DO.SubmitDO;
import com.hqz.hzuoj.entity.model.Submit;
import com.hqz.hzuoj.mapper.SubmitMapper;
import com.hqz.hzuoj.service.JudgeResultService;
import com.hqz.hzuoj.service.SubmitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (Submit)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("submitService")
public class SubmitServiceImpl implements SubmitService {
    @Resource
    private SubmitMapper submitMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param submitId 主键
     * @return 实例对象
     */
    @Override
    public Submit queryById(Integer submitId) {
        return this.submitMapper.queryById(submitId);
    }

    /**
     * 新增数据
     *
     * @param submit 实例对象
     * @return 实例对象
     */
    @Override
    public Submit insert(Submit submit) {
        this.submitMapper.insert(submit);
        return submit;
    }

    /**
     * 修改数据
     *
     * @param submit 实例对象
     * @return 实例对象
     */
    @Override
    public Submit update(Submit submit) {
        this.submitMapper.update(submit);
        return this.queryById(submit.getSubmitId());
    }

    /**
     * 通过主键删除数据
     *
     * @param submitId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer submitId) {
        return this.submitMapper.deleteById(submitId) > 0;
    }


    /**
     * 获取提交测评详情
     * @param submitId
     * @return
     */
    @Override
    public SubmitDO findSubmit(Integer submitId) {
        SubmitDO submit = submitMapper.findSubmit(submitId);
        if (submit == null) {
            throw new MyException("测评为空");
        }
        return submit;
    }

    /**
     * 保存测评记录
     * @param submit
     * @return
     */
    @Override
    @Transactional
    public Integer saveSubmit(Submit submit) {
        Integer userId = CurrentUser.getUserId();
        submit.setUserId(userId);
        submitMapper.saveSubmit(submit);
        return submit.getSubmitId();
    }

}
