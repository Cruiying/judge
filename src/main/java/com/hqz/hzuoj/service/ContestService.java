package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.Contest;
import java.util.List;

/**
 * (Contest)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface ContestService {

    /**
     * 通过ID查询单条数据
     *
     * @param contestId 主键
     * @return 实例对象
     */
    Contest queryById(Integer contestId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Contest> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param contest 实例对象
     * @return 实例对象
     */
    Contest insert(Contest contest);

    /**
     * 修改数据
     *
     * @param contest 实例对象
     * @return 实例对象
     */
    Contest update(Contest contest);

    /**
     * 通过主键删除数据
     *
     * @param contestId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer contestId);

}
