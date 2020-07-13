package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.Language;

import java.util.List;

/**
 * (Language)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface LanguageService {

    /**
     * 通过ID查询单条数据
     *
     * @param languageId 主键
     * @return 实例对象
     */
    Language queryById(Integer languageId);


    /**
     * 新增数据
     *
     * @param language 实例对象
     * @return 实例对象
     */
    Language insert(Language language);

    /**
     * 修改数据
     *
     * @param language 实例对象
     * @return 实例对象
     */
    Language update(Language language);

    /**
     * 通过主键删除数据
     *
     * @param languageId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer languageId);

    /**
     * 获取语言列表
     * @return
     */
    List<Language> findLanguages();
}
