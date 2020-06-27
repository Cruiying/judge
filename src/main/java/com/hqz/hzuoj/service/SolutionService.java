package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.Solution;
import java.util.List;

/**
 * (Solution)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface SolutionService {

    /**
     * 通过ID查询单条数据
     *
     * @param solutionId 主键
     * @return 实例对象
     */
    Solution queryById(Integer solutionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Solution> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param solution 实例对象
     * @return 实例对象
     */
    Solution insert(Solution solution);

    /**
     * 修改数据
     *
     * @param solution 实例对象
     * @return 实例对象
     */
    Solution update(Solution solution);

    /**
     * 通过主键删除数据
     *
     * @param solutionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer solutionId);

}
