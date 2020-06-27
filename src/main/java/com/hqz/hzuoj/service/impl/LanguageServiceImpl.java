package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.entity.model.Language;
import com.hqz.hzuoj.mapper.LanguageMapper;
import com.hqz.hzuoj.service.LanguageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Language)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("languageService")
public class LanguageServiceImpl implements LanguageService {
    @Resource
    private LanguageMapper languageMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param languageId 主键
     * @return 实例对象
     */
    @Override
    public Language queryById(Integer languageId) {
        return this.languageMapper.queryById(languageId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Language> queryAllByLimit(int offset, int limit) {
        return this.languageMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param language 实例对象
     * @return 实例对象
     */
    @Override
    public Language insert(Language language) {
        this.languageMapper.insert(language);
        return language;
    }

    /**
     * 修改数据
     *
     * @param language 实例对象
     * @return 实例对象
     */
    @Override
    public Language update(Language language) {
        this.languageMapper.update(language);
        return this.queryById(language.getLanguageId());
    }

    /**
     * 通过主键删除数据
     *
     * @param languageId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer languageId) {
        return this.languageMapper.deleteById(languageId) > 0;
    }

    /**
     * 获取语言列表
     * @return
     */
    @Override
    public List<Language> findLanguages() {
        return languageMapper.findLanguages();
    }
}
