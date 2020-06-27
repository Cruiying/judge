package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.Solution;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Solution)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface SolutionMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param solutionId 主键
     * @return 实例对象
     */
    Solution queryById(Integer solutionId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Solution> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param solution 实例对象
     * @return 对象列表
     */
    List<Solution> queryAll(Solution solution);

    /**
     * 新增数据
     *
     * @param solution 实例对象
     * @return 影响行数
     */
    int insert(Solution solution);

    /**
     * 修改数据
     *
     * @param solution 实例对象
     * @return 影响行数
     */
    int update(Solution solution);

    /**
     * 通过主键删除数据
     *
     * @param solutionId 主键
     * @return 影响行数
     */
    int deleteById(Integer solutionId);

}
