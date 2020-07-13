package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.Problem;

import java.util.List;

/**
 * (Problem)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface ProblemService {

    /**
     * 通过ID查询单条数据
     *
     * @param problemId 主键
     * @return 实例对象
     */
    Problem queryById(Integer problemId);

    /**
     * 新增数据
     *
     * @param problem 实例对象
     * @return 实例对象
     */
    Problem insert(Problem problem);

    /**
     * 修改数据
     *
     * @param problem 实例对象
     * @return 实例对象
     */
    Problem update(Problem problem);

    /**
     * 通过主键删除数据
     *
     * @param problemId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer problemId);

}
