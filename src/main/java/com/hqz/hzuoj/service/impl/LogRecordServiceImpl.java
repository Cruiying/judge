package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.LogRecord;
import com.hqz.hzuoj.mapper.LogRecordMapper;
import com.hqz.hzuoj.service.LogRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LogRecord)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("logRecordService")
public class LogRecordServiceImpl implements LogRecordService {
    @Resource
    private LogRecordMapper logRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public LogRecord queryById(Integer id) {
        return this.logRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<LogRecord> queryAllByLimit(int offset, int limit) {
        return this.logRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param logRecord 实例对象
     * @return 实例对象
     */
    @Override
    public LogRecord insert(LogRecord logRecord) {
        this.logRecordDao.insert(logRecord);
        return logRecord;
    }

    /**
     * 修改数据
     *
     * @param logRecord 实例对象
     * @return 实例对象
     */
    @Override
    public LogRecord update(LogRecord logRecord) {
        this.logRecordDao.update(logRecord);
        return this.queryById(logRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.logRecordDao.deleteById(id) > 0;
    }
}
