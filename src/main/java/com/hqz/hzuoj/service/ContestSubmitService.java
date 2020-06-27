package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.ContestSubmit;
import java.util.List;

/**
 * (ContestSubmit)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface ContestSubmitService {

    /**
     * 通过ID查询单条数据
     *
     * @param contestSubmitId 主键
     * @return 实例对象
     */
    ContestSubmit queryById(Integer contestSubmitId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ContestSubmit> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param contestSubmit 实例对象
     * @return 实例对象
     */
    ContestSubmit insert(ContestSubmit contestSubmit);

    /**
     * 修改数据
     *
     * @param contestSubmit 实例对象
     * @return 实例对象
     */
    ContestSubmit update(ContestSubmit contestSubmit);

    /**
     * 通过主键删除数据
     *
     * @param contestSubmitId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer contestSubmitId);

}
