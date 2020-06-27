package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.OssResource;
import com.hqz.hzuoj.mapper.OssResourceMapper;
import com.hqz.hzuoj.service.OssResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OssResource)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
@Service("ossResourceService")
public class OssResourceServiceImpl implements OssResourceService {
    @Resource
    private OssResourceMapper ossResourceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OssResource queryById(Integer id) {
        return this.ossResourceDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OssResource> queryAllByLimit(int offset, int limit) {
        return this.ossResourceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ossResource 实例对象
     * @return 实例对象
     */
    @Override
    public OssResource insert(OssResource ossResource) {
        this.ossResourceDao.insert(ossResource);
        return ossResource;
    }

    /**
     * 修改数据
     *
     * @param ossResource 实例对象
     * @return 实例对象
     */
    @Override
    public OssResource update(OssResource ossResource) {
        this.ossResourceDao.update(ossResource);
        return this.queryById(ossResource.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.ossResourceDao.deleteById(id) > 0;
    }
}
