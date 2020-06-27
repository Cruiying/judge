package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.Language;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Language)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface LanguageMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param languageId 主键
     * @return 实例对象
     */
    Language queryById(Integer languageId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Language> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param language 实例对象
     * @return 对象列表
     */
    List<Language> queryAll(Language language);

    /**
     * 新增数据
     *
     * @param language 实例对象
     * @return 影响行数
     */
    int insert(Language language);

    /**
     * 修改数据
     *
     * @param language 实例对象
     * @return 影响行数
     */
    int update(Language language);

    /**
     * 通过主键删除数据
     *
     * @param languageId 主键
     * @return 影响行数
     */
    int deleteById(Integer languageId);

    /**
     * 获取语言列表
     * @return
     */
    List<Language> findLanguages();
}
