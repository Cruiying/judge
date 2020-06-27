package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.SysUserRole;
import com.hqz.hzuoj.mapper.SysUserRoleMapper;
import com.hqz.hzuoj.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUserRole)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUserRole queryById(Integer id) {
        return this.sysUserRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUserRole> queryAllByLimit(int offset, int limit) {
        return this.sysUserRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserRole insert(SysUserRole sysUserRole) {
        this.sysUserRoleDao.insert(sysUserRole);
        return sysUserRole;
    }

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserRole update(SysUserRole sysUserRole) {
        this.sysUserRoleDao.update(sysUserRole);
        return this.queryById(sysUserRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysUserRoleDao.deleteById(id) > 0;
    }
}
