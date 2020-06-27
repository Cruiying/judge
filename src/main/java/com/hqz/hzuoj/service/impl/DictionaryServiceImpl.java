package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.Dictionary;
import com.hqz.hzuoj.mapper.DictionaryMapper;
import com.hqz.hzuoj.service.DictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dictionary)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
    @Resource
    private DictionaryMapper dictionaryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Dictionary queryById(Integer id) {
        return this.dictionaryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Dictionary> queryAllByLimit(int offset, int limit) {
        return this.dictionaryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dictionary 实例对象
     * @return 实例对象
     */
    @Override
    public Dictionary insert(Dictionary dictionary) {
        this.dictionaryDao.insert(dictionary);
        return dictionary;
    }

    /**
     * 修改数据
     *
     * @param dictionary 实例对象
     * @return 实例对象
     */
    @Override
    public Dictionary update(Dictionary dictionary) {
        this.dictionaryDao.update(dictionary);
        return this.queryById(dictionary.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dictionaryDao.deleteById(id) > 0;
    }
}
