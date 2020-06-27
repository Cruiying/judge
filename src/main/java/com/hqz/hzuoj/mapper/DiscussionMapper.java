package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.DO.DiscussionUserDO;
import com.hqz.hzuoj.entity.model.Discussion;
import com.hqz.hzuoj.entity.model.DiscussionComment;
import com.hqz.hzuoj.entity.VO.DiscussionQueryVO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Discussion)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface DiscussionMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param discussionId 主键
     * @return 实例对象
     */
    Discussion queryById(Integer discussionId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Discussion> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param discussion 实例对象
     * @return 对象列表
     */
    List<Discussion> queryAll(Discussion discussion);

    /**
     * 新增数据
     *
     * @param discussion 实例对象
     * @return 影响行数
     */
    int insert(Discussion discussion);

    /**
     * 修改数据
     *
     * @param discussion 实例对象
     * @return 影响行数
     */
    int update(Discussion discussion);

    /**
     * 通过主键删除数据
     *
     * @param discussionId 主键
     * @return 影响行数
     */
    int deleteById(Integer discussionId);

    /**
     * 查询讨论列表
     * @param discussionQueryVO
     * @return
     */
    List<Discussion> queryDiscussions(DiscussionQueryVO discussionQueryVO);

    /**
     * 获取讨论回复列表
     * @param discussionId
     * @return
     */
    List<DiscussionComment> queryDiscussionComment(Integer discussionId);

    /**
     * 通过ID查询讨论
     * @param discussionId
     * @return
     */
    DiscussionUserDO findById(Integer discussionId);

    List<DiscussionUserDO> findDiscussions(DiscussionQueryVO discussionQueryVO);
}
