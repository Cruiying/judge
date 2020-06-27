package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.JudgeResult;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (JudgeResult)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface JudgeResultMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param judgeResultId 主键
     * @return 实例对象
     */
    JudgeResult queryById(Integer judgeResultId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<JudgeResult> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param judgeResult 实例对象
     * @return 对象列表
     */
    List<JudgeResult> queryAll(JudgeResult judgeResult);

    /**
     * 新增数据
     *
     * @param judgeResult 实例对象
     * @return 影响行数
     */
    int insert(JudgeResult judgeResult);

    /**
     * 修改数据
     *
     * @param judgeResult 实例对象
     * @return 影响行数
     */
    int update(JudgeResult judgeResult);

    /**
     * 通过主键删除数据
     *
     * @param judgeResultId 主键
     * @return 影响行数
     */
    int deleteById(Integer judgeResultId);

    /**
     * 获取所有测评结果
     * @return
     */
    List<JudgeResult> findJudgeResults();

    /**
     * 根据测评名称查找测评结果
     * @param judgeNameAbbr
     * @return
     */
    JudgeResult findJudgeResultByJudgeNameAbbr(String judgeNameAbbr);
}
