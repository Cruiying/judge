package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.JudgeResult;
import java.util.List;

/**
 * (JudgeResult)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface JudgeResultService {

    /**
     * 通过ID查询单条数据
     *
     * @param judgeResultId 主键
     * @return 实例对象
     */
    JudgeResult queryById(Integer judgeResultId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<JudgeResult> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param judgeResult 实例对象
     * @return 实例对象
     */
    JudgeResult insert(JudgeResult judgeResult);

    /**
     * 修改数据
     *
     * @param judgeResult 实例对象
     * @return 实例对象
     */
    JudgeResult update(JudgeResult judgeResult);

    /**
     * 通过主键删除数据
     *
     * @param judgeResultId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer judgeResultId);

    /**
     * 获取所有测评结果
     * @return
     */
    List<JudgeResult> findJudgeResults();

    /**
     * 根据测评缩写查找测评结果
     * @param judgeNameAbbr
     * @return
     */
    JudgeResult findJudgeResultByJudgeNameAbbr(String judgeNameAbbr);
}
