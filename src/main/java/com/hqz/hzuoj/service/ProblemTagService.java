package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.ProblemTag;
import java.util.List;

/**
 * (ProblemTag)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface ProblemTagService {

    /**
     * 通过ID查询单条数据
     *
     * @param problemTagId 主键
     * @return 实例对象
     */
    ProblemTag queryById(Integer problemTagId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProblemTag> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param problemTag 实例对象
     * @return 实例对象
     */
    ProblemTag insert(ProblemTag problemTag);

    /**
     * 修改数据
     *
     * @param problemTag 实例对象
     * @return 实例对象
     */
    ProblemTag update(ProblemTag problemTag);

    /**
     * 通过主键删除数据
     *
     * @param problemTagId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer problemTagId);

}
