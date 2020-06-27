package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.ProblemTag;
import com.hqz.hzuoj.mapper.ProblemTagMapper;
import com.hqz.hzuoj.service.ProblemTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProblemTag)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("problemTagService")
public class ProblemTagServiceImpl implements ProblemTagService {
    @Resource
    private ProblemTagMapper problemTagDao;

    /**
     * 通过ID查询单条数据
     *
     * @param problemTagId 主键
     * @return 实例对象
     */
    @Override
    public ProblemTag queryById(Integer problemTagId) {
        return this.problemTagDao.queryById(problemTagId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProblemTag> queryAllByLimit(int offset, int limit) {
        return this.problemTagDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param problemTag 实例对象
     * @return 实例对象
     */
    @Override
    public ProblemTag insert(ProblemTag problemTag) {
        this.problemTagDao.insert(problemTag);
        return problemTag;
    }

    /**
     * 修改数据
     *
     * @param problemTag 实例对象
     * @return 实例对象
     */
    @Override
    public ProblemTag update(ProblemTag problemTag) {
        this.problemTagDao.update(problemTag);
        return this.queryById(problemTag.getProblemTagId());
    }

    /**
     * 通过主键删除数据
     *
     * @param problemTagId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer problemTagId) {
        return this.problemTagDao.deleteById(problemTagId) > 0;
    }
}
