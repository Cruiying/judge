package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.Dictionary;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Dictionary)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface DictionaryMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dictionary queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Dictionary> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dictionary 实例对象
     * @return 对象列表
     */
    List<Dictionary> queryAll(Dictionary dictionary);

    /**
     * 新增数据
     *
     * @param dictionary 实例对象
     * @return 影响行数
     */
    int insert(Dictionary dictionary);

    /**
     * 修改数据
     *
     * @param dictionary 实例对象
     * @return 影响行数
     */
    int update(Dictionary dictionary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
