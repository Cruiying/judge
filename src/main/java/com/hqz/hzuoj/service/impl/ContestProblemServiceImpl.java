package com.hqz.hzuoj.service.impl;


import com.hqz.hzuoj.mapper.ContestProblemMapper;
import com.hqz.hzuoj.entity.model.ContestProblem;
import com.hqz.hzuoj.service.ContestProblemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ContestProblem)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("contestProblemService")
public class ContestProblemServiceImpl implements ContestProblemService {
    @Resource
    private ContestProblemMapper contestProblemMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param contestProblemId 主键
     * @return 实例对象
     */
    @Override
    public ContestProblem queryById(Integer contestProblemId) {
        return this.contestProblemMapper.queryById(contestProblemId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ContestProblem> queryAllByLimit(int offset, int limit) {
        return this.contestProblemMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param contestProblem 实例对象
     * @return 实例对象
     */
    @Override
    public ContestProblem insert(ContestProblem contestProblem) {
        this.contestProblemMapper.insert(contestProblem);
        return contestProblem;
    }

    /**
     * 修改数据
     *
     * @param contestProblem 实例对象
     * @return 实例对象
     */
    @Override
    public ContestProblem update(ContestProblem contestProblem) {
        this.contestProblemMapper.update(contestProblem);
        return this.queryById(contestProblem.getContestProblemId());
    }

    /**
     * 通过主键删除数据
     *
     * @param contestProblemId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer contestProblemId) {
        return this.contestProblemMapper.deleteById(contestProblemId) > 0;
    }
}
