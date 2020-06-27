package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.AccessRecord;
import java.util.List;

/**
 * (AccessRecord)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface AccessRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AccessRecord queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AccessRecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param accessRecord 实例对象
     * @return 实例对象
     */
    AccessRecord insert(AccessRecord accessRecord);

    /**
     * 修改数据
     *
     * @param accessRecord 实例对象
     * @return 实例对象
     */
    AccessRecord update(AccessRecord accessRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
