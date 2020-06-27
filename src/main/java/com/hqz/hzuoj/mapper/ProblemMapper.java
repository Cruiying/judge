package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.DO.ProblemDO;
import com.hqz.hzuoj.entity.DO.ProblemListDO;
import com.hqz.hzuoj.entity.VO.ProblemQueryVO;
import com.hqz.hzuoj.entity.model.Problem;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Problem)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface ProblemMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param problemId 主键
     * @return 实例对象
     */
    Problem queryById(Integer problemId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Problem> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param problem 实例对象
     * @return 对象列表
     */
    List<Problem> queryAll(Problem problem);

    /**
     * 新增数据
     *
     * @param problem 实例对象
     * @return 影响行数
     */
    int insert(Problem problem);

    /**
     * 修改数据
     *
     * @param problem 实例对象
     * @return 影响行数
     */
    int update(Problem problem);

    /**
     * 通过主键删除数据
     *
     * @param problemId 主键
     * @return 影响行数
     */
    int deleteById(Integer problemId);

    /**
     * 通过ID获取题目
     * @param problemId
     * @return
     */
    ProblemDO findById(Integer problemId);

    /**
     * 获取题目列表
     * @param problemQueryVO
     * @return
     */
    List<ProblemListDO> findProblems(ProblemQueryVO problemQueryVO);
}
