package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.ProblemTag;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ProblemTag)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface ProblemTagMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param problemTagId 主键
     * @return 实例对象
     */
    ProblemTag queryById(Integer problemTagId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProblemTag> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param problemTag 实例对象
     * @return 对象列表
     */
    List<ProblemTag> queryAll(ProblemTag problemTag);

    /**
     * 新增数据
     *
     * @param problemTag 实例对象
     * @return 影响行数
     */
    int insert(ProblemTag problemTag);

    /**
     * 修改数据
     *
     * @param problemTag 实例对象
     * @return 影响行数
     */
    int update(ProblemTag problemTag);

    /**
     * 通过主键删除数据
     *
     * @param problemTagId 主键
     * @return 影响行数
     */
    int deleteById(Integer problemTagId);

}
