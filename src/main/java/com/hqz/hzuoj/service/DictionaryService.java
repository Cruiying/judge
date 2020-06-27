package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.Dictionary;
import java.util.List;

/**
 * (Dictionary)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface DictionaryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dictionary queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Dictionary> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dictionary 实例对象
     * @return 实例对象
     */
    Dictionary insert(Dictionary dictionary);

    /**
     * 修改数据
     *
     * @param dictionary 实例对象
     * @return 实例对象
     */
    Dictionary update(Dictionary dictionary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
