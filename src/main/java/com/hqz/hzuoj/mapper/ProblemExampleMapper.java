package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.DO.ProblemExampleListDO;
import com.hqz.hzuoj.entity.model.ProblemExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ProblemExample)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface ProblemExampleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param problemExampleId 主键
     * @return 实例对象
     */
    ProblemExample queryById(Integer problemExampleId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProblemExample> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param problemExample 实例对象
     * @return 对象列表
     */
    List<ProblemExample> queryAll(ProblemExample problemExample);

    /**
     * 新增数据
     *
     * @param problemExample 实例对象
     * @return 影响行数
     */
    int insert(ProblemExample problemExample);

    /**
     * 修改数据
     *
     * @param problemExample 实例对象
     * @return 影响行数
     */
    int update(ProblemExample problemExample);

    /**
     * 通过主键删除数据
     *
     * @param problemExampleId 主键
     * @return 影响行数
     */
    int deleteById(Integer problemExampleId);

    /**
     * 获取题目样例
     * @param problemId
     * @return
     */
    List<ProblemExampleListDO> findProblemExamples(Integer problemId);
}
