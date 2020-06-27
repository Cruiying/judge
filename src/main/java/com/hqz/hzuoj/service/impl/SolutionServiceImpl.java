package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.Solution;
import com.hqz.hzuoj.mapper.SolutionMapper;
import com.hqz.hzuoj.service.SolutionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Solution)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("solutionService")
public class SolutionServiceImpl implements SolutionService {
    @Resource
    private SolutionMapper solutionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param solutionId 主键
     * @return 实例对象
     */
    @Override
    public Solution queryById(Integer solutionId) {
        return this.solutionDao.queryById(solutionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Solution> queryAllByLimit(int offset, int limit) {
        return this.solutionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param solution 实例对象
     * @return 实例对象
     */
    @Override
    public Solution insert(Solution solution) {
        this.solutionDao.insert(solution);
        return solution;
    }

    /**
     * 修改数据
     *
     * @param solution 实例对象
     * @return 实例对象
     */
    @Override
    public Solution update(Solution solution) {
        this.solutionDao.update(solution);
        return this.queryById(solution.getSolutionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param solutionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer solutionId) {
        return this.solutionDao.deleteById(solutionId) > 0;
    }
}
