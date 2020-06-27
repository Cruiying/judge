package com.hqz.hzuoj.service;

import com.hqz.hzuoj.entity.DTO.DiscussionCommentDTO;
import com.hqz.hzuoj.entity.model.DiscussionComment;

import java.util.List;

/**
 * (DiscussionComment)表服务接口
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public interface DiscussionCommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param discussionCommentId 主键
     * @return 实例对象
     */
    DiscussionComment queryById(Integer discussionCommentId);

    /**
     * 通过主键删除数据
     *
     * @param discussionCommentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer discussionCommentId);

    /**
     * 获取讨论回复列表
     * @param discussionId
     * @return
     */
    List<DiscussionCommentDTO> findDiscussionComment(Integer discussionId);

    /**
     * 保存讨论回复
     * @param discussionComment
     */
    DiscussionComment saveDiscussionComment(DiscussionComment discussionComment);

}
