package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.ContestRegister;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ContestRegister)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface ContestRegisterMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param contestRegisterId 主键
     * @return 实例对象
     */
    ContestRegister queryById(Integer contestRegisterId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ContestRegister> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param contestRegister 实例对象
     * @return 对象列表
     */
    List<ContestRegister> queryAll(ContestRegister contestRegister);

    /**
     * 新增数据
     *
     * @param contestRegister 实例对象
     * @return 影响行数
     */
    int insert(ContestRegister contestRegister);

    /**
     * 修改数据
     *
     * @param contestRegister 实例对象
     * @return 影响行数
     */
    int update(ContestRegister contestRegister);

    /**
     * 通过主键删除数据
     *
     * @param contestRegisterId 主键
     * @return 影响行数
     */
    int deleteById(Integer contestRegisterId);

}
