package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.SysMenu;
import java.util.List;

/**
 * (SysMenu)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface SysMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param menuId 主键
     * @return 实例对象
     */
    SysMenu queryById(Integer menuId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysMenu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    SysMenu insert(SysMenu sysMenu);

    /**
     * 修改数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    SysMenu update(SysMenu sysMenu);

    /**
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer menuId);

}
