package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.DictionaryOption;
import com.hqz.hzuoj.mapper.DictionaryOptionMapper;
import com.hqz.hzuoj.service.DictionaryOptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DictionaryOption)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("dictionaryOptionService")
public class DictionaryOptionServiceImpl implements DictionaryOptionService {
    @Resource
    private DictionaryOptionMapper dictionaryOptionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DictionaryOption queryById(Integer id) {
        return this.dictionaryOptionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DictionaryOption> queryAllByLimit(int offset, int limit) {
        return this.dictionaryOptionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dictionaryOption 实例对象
     * @return 实例对象
     */
    @Override
    public DictionaryOption insert(DictionaryOption dictionaryOption) {
        this.dictionaryOptionDao.insert(dictionaryOption);
        return dictionaryOption;
    }

    /**
     * 修改数据
     *
     * @param dictionaryOption 实例对象
     * @return 实例对象
     */
    @Override
    public DictionaryOption update(DictionaryOption dictionaryOption) {
        this.dictionaryOptionDao.update(dictionaryOption);
        return this.queryById(dictionaryOption.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dictionaryOptionDao.deleteById(id) > 0;
    }
}
