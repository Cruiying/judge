package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.ContestRegister;
import com.hqz.hzuoj.mapper.ContestRegisterMapper;
import com.hqz.hzuoj.service.ContestRegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ContestRegister)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("contestRegisterService")
public class ContestRegisterServiceImpl implements ContestRegisterService {
    @Resource
    private ContestRegisterMapper contestRegisterMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param contestRegisterId 主键
     * @return 实例对象
     */
    @Override
    public ContestRegister queryById(Integer contestRegisterId) {
        return this.contestRegisterMapper.queryById(contestRegisterId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ContestRegister> queryAllByLimit(int offset, int limit) {
        return this.contestRegisterMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param contestRegister 实例对象
     * @return 实例对象
     */
    @Override
    public ContestRegister insert(ContestRegister contestRegister) {
        this.contestRegisterMapper.insert(contestRegister);
        return contestRegister;
    }

    /**
     * 修改数据
     *
     * @param contestRegister 实例对象
     * @return 实例对象
     */
    @Override
    public ContestRegister update(ContestRegister contestRegister) {
        this.contestRegisterMapper.update(contestRegister);
        return this.queryById(contestRegister.getContestRegisterId());
    }

    /**
     * 通过主键删除数据
     *
     * @param contestRegisterId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer contestRegisterId) {
        return this.contestRegisterMapper.deleteById(contestRegisterId) > 0;
    }
}
