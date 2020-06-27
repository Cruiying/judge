package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.AccessRecord;
import com.hqz.hzuoj.mapper.AccessRecordMapper;
import com.hqz.hzuoj.service.AccessRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AccessRecord)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("accessRecordService")
public class AccessRecordServiceImpl implements AccessRecordService {
    @Resource
    private AccessRecordMapper accessRecordMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AccessRecord queryById(Long id) {
        return this.accessRecordMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AccessRecord> queryAllByLimit(int offset, int limit) {
        return this.accessRecordMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param accessRecord 实例对象
     * @return 实例对象
     */
    @Override
    public AccessRecord insert(AccessRecord accessRecord) {
        this.accessRecordMapper.insert(accessRecord);
        return accessRecord;
    }

    /**
     * 修改数据
     *
     * @param accessRecord 实例对象
     * @return 实例对象
     */
    @Override
    public AccessRecord update(AccessRecord accessRecord) {
        this.accessRecordMapper.update(accessRecord);
        return this.queryById(accessRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.accessRecordMapper.deleteById(id) > 0;
    }
}
