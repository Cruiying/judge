package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.ContestRankInfo;
import java.util.List;

/**
 * (ContestRankInfo)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface ContestRankInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param contestRankInfoId 主键
     * @return 实例对象
     */
    ContestRankInfo queryById(Integer contestRankInfoId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ContestRankInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param contestRankInfo 实例对象
     * @return 实例对象
     */
    ContestRankInfo insert(ContestRankInfo contestRankInfo);

    /**
     * 修改数据
     *
     * @param contestRankInfo 实例对象
     * @return 实例对象
     */
    ContestRankInfo update(ContestRankInfo contestRankInfo);

    /**
     * 通过主键删除数据
     *
     * @param contestRankInfoId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer contestRankInfoId);

}
