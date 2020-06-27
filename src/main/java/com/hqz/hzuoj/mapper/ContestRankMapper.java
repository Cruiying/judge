package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.ContestRank;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ContestRank)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface ContestRankMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param contestRankId 主键
     * @return 实例对象
     */
    ContestRank queryById(Integer contestRankId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ContestRank> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param contestRank 实例对象
     * @return 对象列表
     */
    List<ContestRank> queryAll(ContestRank contestRank);

    /**
     * 新增数据
     *
     * @param contestRank 实例对象
     * @return 影响行数
     */
    int insert(ContestRank contestRank);

    /**
     * 修改数据
     *
     * @param contestRank 实例对象
     * @return 影响行数
     */
    int update(ContestRank contestRank);

    /**
     * 通过主键删除数据
     *
     * @param contestRankId 主键
     * @return 影响行数
     */
    int deleteById(Integer contestRankId);

}
