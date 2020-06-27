package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.SysRoleMenu;
import com.hqz.hzuoj.mapper.SysRoleMenuMapper;
import com.hqz.hzuoj.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysRoleMenu)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Resource
    private SysRoleMenuMapper sysRoleMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRoleMenu queryById(Integer id) {
        return this.sysRoleMenuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysRoleMenu> queryAllByLimit(int offset, int limit) {
        return this.sysRoleMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoleMenu insert(SysRoleMenu sysRoleMenu) {
        this.sysRoleMenuDao.insert(sysRoleMenu);
        return sysRoleMenu;
    }

    /**
     * 修改数据
     *
     * @param sysRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoleMenu update(SysRoleMenu sysRoleMenu) {
        this.sysRoleMenuDao.update(sysRoleMenu);
        return this.queryById(sysRoleMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysRoleMenuDao.deleteById(id) > 0;
    }
}
