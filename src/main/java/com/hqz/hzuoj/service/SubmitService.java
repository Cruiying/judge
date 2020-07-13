package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.DO.SubmitDO;
import com.hqz.hzuoj.entity.model.Submit;

import java.util.List;

/**
 * (Submit)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface SubmitService {

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
     * @return 实例对象
     */
    Submit insert(Submit submit);

    /**
     * 修改数据
     *
     * @param submit 实例对象
     * @return 实例对象
     */
    Submit update(Submit submit);

    /**
     * 通过主键删除数据
     *
     * @param submitId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer submitId);



    /**
     * 保存测评记录
     * @param submit
     * @return
     */
    Integer saveSubmit(Submit submit);

    /**
     * 提交信息
     * @param submitId
     * @return
     */
    SubmitDO findSubmit(Integer submitId);

}
