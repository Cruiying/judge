package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.ContestProblem;
import java.util.List;

/**
 * (ContestProblem)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface ContestProblemService {

    /**
     * 通过ID查询单条数据
     *
     * @param contestProblemId 主键
     * @return 实例对象
     */
    ContestProblem queryById(Integer contestProblemId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ContestProblem> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param contestProblem 实例对象
     * @return 实例对象
     */
    ContestProblem insert(ContestProblem contestProblem);

    /**
     * 修改数据
     *
     * @param contestProblem 实例对象
     * @return 实例对象
     */
    ContestProblem update(ContestProblem contestProblem);

    /**
     * 通过主键删除数据
     *
     * @param contestProblemId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer contestProblemId);

}
