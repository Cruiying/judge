package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.DO.DiscussionUserDO;
import com.hqz.hzuoj.common.util.PageUtils;
import com.hqz.hzuoj.entity.model.Discussion;
import com.hqz.hzuoj.entity.VO.DiscussionQueryVO;

/**
 * (Discussion)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface DiscussionService {

    /**
     * 通过ID查询单条数据
     *
     * @param discussionId 主键
     * @return 实例对象
     */
    Discussion queryById(Integer discussionId);

    /**
     * 新增数据
     *
     * @param discussion 实例对象
     * @return 实例对象
     */
    Discussion insert(Discussion discussion);

    /**
     * 修改数据
     *
     * @param discussion 实例对象
     * @return 实例对象
     */
    Discussion update(Discussion discussion);

    /**
     * 通过主键删除数据
     *
     * @param discussionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer discussionId);
    /**
     * 通过ID查询讨论
     * @param discussionId
     * @return
     */
    DiscussionUserDO findById(Integer discussionId);
    /**
     * 分页查询
     * @param discussionQueryVO
     * @return
     */
    PageUtils findDiscussions(DiscussionQueryVO discussionQueryVO);

}
