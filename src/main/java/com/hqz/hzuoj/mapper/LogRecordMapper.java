package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.LogRecord;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (LogRecord)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface LogRecordMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LogRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LogRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param logRecord 实例对象
     * @return 对象列表
     */
    List<LogRecord> queryAll(LogRecord logRecord);

    /**
     * 新增数据
     *
     * @param logRecord 实例对象
     * @return 影响行数
     */
    int insert(LogRecord logRecord);

    /**
     * 修改数据
     *
     * @param logRecord 实例对象
     * @return 影响行数
     */
    int update(LogRecord logRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
