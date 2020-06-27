package com.hqz.hzuoj.mapper;

import com.hqz.hzuoj.entity.model.DiscussionComment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DiscussionComment)表数据库访问层
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface DiscussionCommentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param discussionCommentId 主键
     * @return 实例对象
     */
    DiscussionComment queryById(Integer discussionCommentId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DiscussionComment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param discussionComment 实例对象
     * @return 对象列表
     */
    List<DiscussionComment> queryAll(DiscussionComment discussionComment);

    /**
     * 新增数据
     *
     * @param discussionComment 实例对象
     * @return 影响行数
     */
    int insert(DiscussionComment discussionComment);

    /**
     * 修改数据
     *
     * @param discussionComment 实例对象
     * @return 影响行数
     */
    int update(DiscussionComment discussionComment);

    /**
     * 通过主键删除数据
     *
     * @param discussionCommentId 主键
     * @return 影响行数
     */
    int deleteById(Integer discussionCommentId);

    /**
     * 获取讨论回复
     * @param discussionId
     * @return
     */
    List<DiscussionComment> queryDiscussionComment(Integer discussionId);
}
