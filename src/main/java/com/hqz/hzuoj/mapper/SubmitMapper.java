package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.DO.SubmitDO;
import com.hqz.hzuoj.entity.model.Submit;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Submit)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface SubmitMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param submitId 主键
     * @return 实例对象
     */
    Submit queryById(Integer submitId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Submit> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param submit 实例对象
     * @return 对象列表
     */
    List<Submit> queryAll(Submit submit);

    /**
     * 新增数据
     *
     * @param submit 实例对象
     * @return 影响行数
     */
    int insert(Submit submit);

    /**
     * 修改数据
     *
     * @param submit 实例对象
     * @return 影响行数
     */
    int update(Submit submit);

    /**
     * 通过主键删除数据
     *
     * @param submitId 主键
     * @return 影响行数
     */
    int deleteById(Integer submitId);

    /**
     * 获取题目通过数量
     * @param problemId
     * @return
     */
    Integer findProblemAcceptedTotal(Integer problemId);

    /**
     * 获取提交测评详细
     * @param submitId
     * @return
     */
    SubmitDO findSubmit(Integer submitId);
}
