package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.DictionaryOption;
import java.util.List;

/**
 * (DictionaryOption)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface DictionaryOptionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictionaryOption queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DictionaryOption> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dictionaryOption 实例对象
     * @return 实例对象
     */
    DictionaryOption insert(DictionaryOption dictionaryOption);

    /**
     * 修改数据
     *
     * @param dictionaryOption 实例对象
     * @return 实例对象
     */
    DictionaryOption update(DictionaryOption dictionaryOption);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
