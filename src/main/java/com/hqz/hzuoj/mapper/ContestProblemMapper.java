package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.ContestProblem;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ContestProblem)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface ContestProblemMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param contestProblemId 主键
     * @return 实例对象
     */
    ContestProblem queryById(Integer contestProblemId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ContestProblem> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param contestProblem 实例对象
     * @return 对象列表
     */
    List<ContestProblem> queryAll(ContestProblemMapper contestProblem);

    /**
     * 新增数据
     *
     * @param contestProblem 实例对象
     * @return 影响行数
     */
    int insert(ContestProblem contestProblem);

    /**
     * 修改数据
     *
     * @param contestProblem 实例对象
     * @return 影响行数
     */
    int update(ContestProblem contestProblem);

    /**
     * 通过主键删除数据
     *
     * @param contestProblemId 主键
     * @return 影响行数
     */
    int deleteById(Integer contestProblemId);

}
