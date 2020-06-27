package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.DO.ProblemDataDO;
import com.hqz.hzuoj.entity.model.ProblemData;
import com.hqz.hzuoj.mapper.ProblemDataMapper;
import com.hqz.hzuoj.service.ProblemDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProblemData)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("problemDataService")
public class ProblemDataServiceImpl implements ProblemDataService {
    @Resource
    private ProblemDataMapper problemDataMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param problemDataId 主键
     * @return 实例对象
     */
    @Override
    public ProblemData queryById(Integer problemDataId) {
        return this.problemDataMapper.queryById(problemDataId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProblemData> queryAllByLimit(int offset, int limit) {
        return this.problemDataMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param problemData 实例对象
     * @return 实例对象
     */
    @Override
    public ProblemData insert(ProblemData problemData) {
        this.problemDataMapper.insert(problemData);
        return problemData;
    }

    /**
     * 修改数据
     *
     * @param problemData 实例对象
     * @return 实例对象
     */
    @Override
    public ProblemData update(ProblemData problemData) {
        this.problemDataMapper.update(problemData);
        return this.queryById(problemData.getProblemDataId());
    }

    /**
     * 通过主键删除数据
     *
     * @param problemDataId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer problemDataId) {
        return this.problemDataMapper.deleteById(problemDataId) > 0;
    }

    /**
     * 获取题目时间与内存限制
     * @param problemId
     * @return
     */
    @Override
    public ProblemDataDO findProblemRuntimeTimeAndRuntimeMemory(Integer problemId) {
        return problemDataMapper.findProblemRuntimeTimeAndRuntimeMemory(problemId);
    }
}
