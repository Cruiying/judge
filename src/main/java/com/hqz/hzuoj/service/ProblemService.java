package com.hqz.hzuoj.service;

import com.hqz.hzuoj.common.util.PageUtils;
import com.hqz.hzuoj.entity.DO.ProblemDO;
import com.hqz.hzuoj.entity.VO.ProblemQueryVO;
import com.hqz.hzuoj.entity.model.Problem;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * (Problem)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface ProblemService {

    /**
     * 通过ID查询单条数据
     *
     * @param problemId 主键
     * @return 实例对象
     */
    Problem queryById(Integer problemId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Problem> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param problem 实例对象
     * @return 实例对象
     */
    Problem insert(Problem problem);

    /**
     * 修改数据
     *
     * @param problem 实例对象
     * @return 实例对象
     */
    Problem update(Problem problem);

    /**
     * 通过主键删除数据
     *
     * @param problemId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer problemId);

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
    PageUtils findProblems(ProblemQueryVO problemQueryVO);
}
