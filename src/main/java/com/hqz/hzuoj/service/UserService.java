package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.User;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

    /**
     * 通过用户名返回用户信息
     * @param username
     * @return
     */
    User queryByUsername(String username);
}
