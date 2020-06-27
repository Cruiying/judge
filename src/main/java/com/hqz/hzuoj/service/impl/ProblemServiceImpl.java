package com.hqz.hzuoj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqz.hzuoj.common.exception.MyException;
import com.hqz.hzuoj.common.util.MarkdownUtils;
import com.hqz.hzuoj.common.util.PageUtils;
import com.hqz.hzuoj.entity.DO.ProblemDO;
import com.hqz.hzuoj.entity.DO.ProblemDataDO;
import com.hqz.hzuoj.entity.DO.ProblemExampleListDO;
import com.hqz.hzuoj.entity.DO.ProblemListDO;
import com.hqz.hzuoj.entity.VO.ProblemQueryVO;
import com.hqz.hzuoj.entity.model.Problem;
import com.hqz.hzuoj.mapper.ProblemMapper;
import com.hqz.hzuoj.service.*;
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
    private ProblemExampleService problemExampleService;

    @Resource
    private SubmitService submitService;

    @Resource
    private ProblemTagService problemTagService;

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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Problem> queryAllByLimit(int offset, int limit) {
        return this.problemMapper.queryAllByLimit(offset, limit);
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

    @Override
    public ProblemDO findById(Integer problemId) {
        //题目数据
        ProblemDO problemDO = problemMapper.findById(problemId);
        if (problemDO == null) {
            throw  new MyException("题目不存在");
        }
        //题目时间与内存限制
        ProblemDataDO problemDataDO = problemDataService.findProblemRuntimeTimeAndRuntimeMemory(problemId);
        //题目样例
        List<ProblemExampleListDO> problemExamples = problemExampleService.findProblemExamples(problemId);
        problemDO.setProblemDataDO(problemDataDO);
        problemDO.setExamples(problemExamples);
        return problemConvertMarkDown(problemDO);
    }

    /**
     * 获取题目列表
     * @param problemQueryVO
     * @return
     */
    @Override
    public PageUtils findProblems(ProblemQueryVO problemQueryVO) {
        PageHelper.startPage(problemQueryVO.getCurrPage(), problemQueryVO.getPageSize(), true);
        List<ProblemListDO> problemList = problemMapper.findProblems(problemQueryVO);
        PageInfo<ProblemListDO> pageInfo = new PageInfo<>(problemList);
        if (pageInfo.getList() != null) {
            for (ProblemListDO problem : pageInfo.getList()) {
                Integer problemId = problem.getProblemId();
                problem.setAcceptedTotal(submitService.findProblemAcceptedTotal(problemId));
                //problem.setSubmitTotal(submitService.findProblemSubmitTotal(problemId));
                //problem.setAccepted(submitService.findProblemAccepted(problemId));
                //problem.setTags(problemTagService.findProblemTags(problemId));
            }
        }

        return new PageUtils(pageInfo);
    }

    /**
     * 将题目markdown转为html
     * @param problemDO
     * @return
     */
    private static ProblemDO problemConvertMarkDown(ProblemDO problemDO) {
        problemDO.setBackground(MarkdownUtils.markdownToHtml(problemDO.getBackground()));
        problemDO.setContent(MarkdownUtils.markdownToHtml(problemDO.getContent()));
        problemDO.setExplain(MarkdownUtils.markdownToHtml(problemDO.getExplain()));
        problemDO.setInputContent(MarkdownUtils.markdownToHtml(problemDO.getInputContent()));
        problemDO.setOutputContent(MarkdownUtils.markdownToHtml(problemDO.getOutputContent()));
        return problemDO;
    }
}
