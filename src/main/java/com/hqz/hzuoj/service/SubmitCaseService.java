package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.model.SubmitCase;
import java.util.List;

/**
 * (SubmitCase)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public interface SubmitCaseService {

    /**
     * 通过ID查询单条数据
     *
     * @param submitCaseId 主键
     * @return 实例对象
     */
    SubmitCase queryById(Integer submitCaseId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SubmitCase> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param submitCase 实例对象
     * @return 实例对象
     */
    SubmitCase insert(SubmitCase submitCase);

    /**
     * 修改数据
     *
     * @param submitCase 实例对象
     * @return 实例对象
     */
    SubmitCase update(SubmitCase submitCase);

    /**
     * 通过主键删除数据
     *
     * @param submitCaseId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer submitCaseId);

}
