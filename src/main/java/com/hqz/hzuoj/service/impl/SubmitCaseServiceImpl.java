package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.SubmitCase;
import com.hqz.hzuoj.mapper.SubmitCaseMapper;
import com.hqz.hzuoj.service.SubmitCaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SubmitCase)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("submitCaseService")
public class SubmitCaseServiceImpl implements SubmitCaseService {
    @Resource
    private SubmitCaseMapper submitCaseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param submitCaseId 主键
     * @return 实例对象
     */
    @Override
    public SubmitCase queryById(Integer submitCaseId) {
        return this.submitCaseDao.queryById(submitCaseId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SubmitCase> queryAllByLimit(int offset, int limit) {
        return this.submitCaseDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param submitCase 实例对象
     * @return 实例对象
     */
    @Override
    public SubmitCase insert(SubmitCase submitCase) {
        this.submitCaseDao.insert(submitCase);
        return submitCase;
    }

    /**
     * 修改数据
     *
     * @param submitCase 实例对象
     * @return 实例对象
     */
    @Override
    public SubmitCase update(SubmitCase submitCase) {
        this.submitCaseDao.update(submitCase);
        return this.queryById(submitCase.getSubmitCaseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param submitCaseId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer submitCaseId) {
        return this.submitCaseDao.deleteById(submitCaseId) > 0;
    }
}
