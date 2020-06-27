package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.ContestSubmit;
import com.hqz.hzuoj.mapper.ContestSubmitMapper;
import com.hqz.hzuoj.service.ContestSubmitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ContestSubmit)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("contestSubmitService")
public class ContestSubmitServiceImpl implements ContestSubmitService {
    @Resource
    private ContestSubmitMapper contestSubmitMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param contestSubmitId 主键
     * @return 实例对象
     */
    @Override
    public ContestSubmit queryById(Integer contestSubmitId) {
        return this.contestSubmitMapper.queryById(contestSubmitId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ContestSubmit> queryAllByLimit(int offset, int limit) {
        return this.contestSubmitMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param contestSubmit 实例对象
     * @return 实例对象
     */
    @Override
    public ContestSubmit insert(ContestSubmit contestSubmit) {
        this.contestSubmitMapper.insert(contestSubmit);
        return contestSubmit;
    }

    /**
     * 修改数据
     *
     * @param contestSubmit 实例对象
     * @return 实例对象
     */
    @Override
    public ContestSubmit update(ContestSubmit contestSubmit) {
        this.contestSubmitMapper.update(contestSubmit);
        return this.queryById(contestSubmit.getContestSubmitId());
    }

    /**
     * 通过主键删除数据
     *
     * @param contestSubmitId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer contestSubmitId) {
        return this.contestSubmitMapper.deleteById(contestSubmitId) > 0;
    }
}
