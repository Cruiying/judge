package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.DO.ProblemExampleListDO;
import com.hqz.hzuoj.entity.model.ProblemExample;
import java.util.List;

/**
 * (ProblemExample)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface ProblemExampleService {

    /**
     * 通过ID查询单条数据
     *
     * @param problemExampleId 主键
     * @return 实例对象
     */
    ProblemExample queryById(Integer problemExampleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProblemExample> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param problemExample 实例对象
     * @return 实例对象
     */
    ProblemExample insert(ProblemExample problemExample);

    /**
     * 修改数据
     *
     * @param problemExample 实例对象
     * @return 实例对象
     */
    ProblemExample update(ProblemExample problemExample);

    /**
     * 通过主键删除数据
     *
     * @param problemExampleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer problemExampleId);

    /**
     * 获取题目样例
     * @param problemId
     * @return
     */
    List<ProblemExampleListDO> findProblemExamples(Integer problemId);
}
