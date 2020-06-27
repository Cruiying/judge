package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.ContestRank;
import java.util.List;

/**
 * (ContestRank)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface ContestRankService {

    /**
     * 通过ID查询单条数据
     *
     * @param contestRankId 主键
     * @return 实例对象
     */
    ContestRank queryById(Integer contestRankId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ContestRank> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param contestRank 实例对象
     * @return 实例对象
     */
    ContestRank insert(ContestRank contestRank);

    /**
     * 修改数据
     *
     * @param contestRank 实例对象
     * @return 实例对象
     */
    ContestRank update(ContestRank contestRank);

    /**
     * 通过主键删除数据
     *
     * @param contestRankId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer contestRankId);

}
