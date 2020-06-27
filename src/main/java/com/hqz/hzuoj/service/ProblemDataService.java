package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.DO.ProblemDataDO;
import com.hqz.hzuoj.entity.model.ProblemData;
import java.util.List;

/**
 * (ProblemData)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface ProblemDataService {

    /**
     * 通过ID查询单条数据
     *
     * @param problemDataId 主键
     * @return 实例对象
     */
    ProblemData queryById(Integer problemDataId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProblemData> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param problemData 实例对象
     * @return 实例对象
     */
    ProblemData insert(ProblemData problemData);

    /**
     * 修改数据
     *
     * @param problemData 实例对象
     * @return 实例对象
     */
    ProblemData update(ProblemData problemData);

    /**
     * 通过主键删除数据
     *
     * @param problemDataId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer problemDataId);

    /**
     * 获取题目与内存事件限制
     * @param problemId
     * @return
     */
    ProblemDataDO findProblemRuntimeTimeAndRuntimeMemory(Integer problemId);
}
