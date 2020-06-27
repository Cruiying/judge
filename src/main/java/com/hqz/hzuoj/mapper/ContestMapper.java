package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.Contest;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Contest)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface ContestMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param contestId 主键
     * @return 实例对象
     */
    Contest queryById(Integer contestId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Contest> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param contest 实例对象
     * @return 对象列表
     */
    List<Contest> queryAll(Contest contest);

    /**
     * 新增数据
     *
     * @param contest 实例对象
     * @return 影响行数
     */
    int insert(Contest contest);

    /**
     * 修改数据
     *
     * @param contest 实例对象
     * @return 影响行数
     */
    int update(Contest contest);

    /**
     * 通过主键删除数据
     *
     * @param contestId 主键
     * @return 影响行数
     */
    int deleteById(Integer contestId);

}
