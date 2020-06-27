package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.ContestRankInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ContestRankInfo)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface ContestRankInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param contestRankInfoId 主键
     * @return 实例对象
     */
    ContestRankInfo queryById(Integer contestRankInfoId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ContestRankInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param contestRankInfo 实例对象
     * @return 对象列表
     */
    List<ContestRankInfo> queryAll(ContestRankInfo contestRankInfo);

    /**
     * 新增数据
     *
     * @param contestRankInfo 实例对象
     * @return 影响行数
     */
    int insert(ContestRankInfo contestRankInfo);

    /**
     * 修改数据
     *
     * @param contestRankInfo 实例对象
     * @return 影响行数
     */
    int update(ContestRankInfo contestRankInfo);

    /**
     * 通过主键删除数据
     *
     * @param contestRankInfoId 主键
     * @return 影响行数
     */
    int deleteById(Integer contestRankInfoId);

}
