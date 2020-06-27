package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.common.exception.MyException;
import com.hqz.hzuoj.common.util.PageUtils;
import com.hqz.hzuoj.entity.DO.SubmitDO;
import com.hqz.hzuoj.entity.VO.SubmitListQueryVO;
import com.hqz.hzuoj.entity.model.Submit;
import com.hqz.hzuoj.mapper.SubmitMapper;
import com.hqz.hzuoj.service.SubmitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Submit> queryAllByLimit(int offset, int limit) {
        return this.submitMapper.queryAllByLimit(offset, limit);
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
     * 获取题目提交通过数量
     * @param problemId
     * @return
     */
    @Override
    public Integer findProblemAcceptedTotal(Integer problemId) {
        return submitMapper.findProblemAcceptedTotal(problemId);
    }

    /**
     * 获取提交测评列表
     * @param submitListQueryVO
     * @return
     */
    @Override
    public PageUtils findSubmits(SubmitListQueryVO submitListQueryVO) {
        return null;
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
}
