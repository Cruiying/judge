package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.DO.SubmitDO;
import com.hqz.hzuoj.entity.model.Submit;

/**
 * (Submit)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface SubmitMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param submitId 主键
     * @return 实例对象
     */
    Submit queryById(Integer submitId);


    /**
     * 新增数据
     *
     * @param submit 实例对象
     * @return 影响行数
     */
    int insert(Submit submit);

    /**
     * 修改数据
     *
     * @param submit 实例对象
     * @return 影响行数
     */
    int update(Submit submit);

    /**
     * 通过主键删除数据
     *
     * @param submitId 主键
     * @return 影响行数
     */
    int deleteById(Integer submitId);


    /**
     * 获取提交测评详细
     * @param submitId
     * @return
     */
    SubmitDO findSubmit(Integer submitId);

    /**
     * 保存测评记录
     * @param submit
     */
    void saveSubmit(Submit submit);
}
