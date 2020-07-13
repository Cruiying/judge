package com.hqz.hzuoj.service.impl;


import com.hqz.hzuoj.entity.model.Problem;
import com.hqz.hzuoj.mapper.ProblemMapper;
import com.hqz.hzuoj.service.ProblemDataService;
import com.hqz.hzuoj.service.ProblemService;
import com.hqz.hzuoj.service.SubmitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Problem)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("problemService")
public class ProblemServiceImpl implements ProblemService {

    @Resource
    private ProblemMapper problemMapper;

    @Resource
    private ProblemDataService problemDataService;

    @Resource
    private SubmitService submitService;

    /**
     * 通过ID查询单条数据
     *
     * @param problemId 主键
     * @return 实例对象
     */
    @Override
    public Problem queryById(Integer problemId) {
        return this.problemMapper.queryById(problemId);
    }


    /**
     * 新增数据
     *
     * @param problem 实例对象
     * @return 实例对象
     */
    @Override
    public Problem insert(Problem problem) {
        this.problemMapper.insert(problem);
        return problem;
    }

    /**
     * 修改数据
     *
     * @param problem 实例对象
     * @return 实例对象
     */
    @Override
    public Problem update(Problem problem) {
        this.problemMapper.update(problem);
        return this.queryById(problem.getProblemId());
    }

    /**
     * 通过主键删除数据
     *
     * @param problemId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer problemId) {
        return this.problemMapper.deleteById(problemId) > 0;
    }

}
