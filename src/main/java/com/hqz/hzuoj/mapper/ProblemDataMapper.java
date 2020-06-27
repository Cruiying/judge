package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.DO.ProblemDataDO;
import com.hqz.hzuoj.entity.model.ProblemData;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ProblemData)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface ProblemDataMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param problemDataId 主键
     * @return 实例对象
     */
    ProblemData queryById(Integer problemDataId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProblemData> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param problemData 实例对象
     * @return 对象列表
     */
    List<ProblemData> queryAll(ProblemData problemData);

    /**
     * 新增数据
     *
     * @param problemData 实例对象
     * @return 影响行数
     */
    int insert(ProblemData problemData);

    /**
     * 修改数据
     *
     * @param problemData 实例对象
     * @return 影响行数
     */
    int update(ProblemData problemData);

    /**
     * 通过主键删除数据
     *
     * @param problemDataId 主键
     * @return 影响行数
     */
    int deleteById(Integer problemDataId);

    /**
     * 获取题目时间与内存限制
     * @param problemId
     * @return
     */
    ProblemDataDO findProblemRuntimeTimeAndRuntimeMemory(Integer problemId);
}
