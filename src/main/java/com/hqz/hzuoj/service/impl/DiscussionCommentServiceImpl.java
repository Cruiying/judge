package com.hqz.hzuoj.service.impl;

import com.hqz.hzuoj.common.base.CurrentUser;
import com.hqz.hzuoj.common.exception.MyException;
import com.hqz.hzuoj.entity.DTO.DiscussionCommentDTO;
import com.hqz.hzuoj.entity.model.Discussion;
import com.hqz.hzuoj.entity.model.DiscussionComment;
import com.hqz.hzuoj.mapper.DiscussionCommentMapper;
import com.hqz.hzuoj.service.DiscussionCommentService;
import com.hqz.hzuoj.service.DiscussionService;
import com.hqz.hzuoj.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (DiscussionComment)表服务实现类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Service("discussionCommentService")
public class DiscussionCommentServiceImpl implements DiscussionCommentService {

    @Resource
    private DiscussionCommentMapper discussionCommentMapper;

    @Resource
    private UserService userService;

    @Resource
    private DiscussionService discussionService;


    /**
     * 通过ID查询单条数据
     *
     * @param discussionCommentId 主键
     * @return 实例对象
     */
    @Override
    public DiscussionComment queryById(Integer discussionCommentId) {
        return this.discussionCommentMapper.queryById(discussionCommentId);
    }


    /**
     * 通过主键删除数据
     *
     * @param discussionCommentId 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(Integer discussionCommentId) {
        return this.discussionCommentMapper.deleteById(discussionCommentId) > 0;
    }

    /**
     * 获取讨论回复
     * @param discussionId
     * @return
     */
    @Override
    public List<DiscussionCommentDTO> findDiscussionComment(Integer discussionId) {
        //获取讨论回复
        List<DiscussionComment> discussionComments = discussionCommentMapper.queryDiscussionComment(discussionId);
        List<DiscussionCommentDTO> discussionCommentList = new ArrayList<>();
        //封装请求参数
        for (DiscussionComment discussionComment : discussionComments) {
            DiscussionCommentDTO discussionCommentDTO = new DiscussionCommentDTO();
            discussionCommentDTO.setDiscussionComment(discussionComment);
            DiscussionComment parentDiscussionComment = this.queryById(discussionComment.getParentCommentId());
            discussionCommentDTO.setParentDiscussionComment(parentDiscussionComment);
            discussionCommentDTO.setUser(userService.queryById(discussionComment.getUserId()));
            if (parentDiscussionComment != null) {
                discussionCommentDTO.setParentUser(userService.queryById(parentDiscussionComment.getUserId()));
            }
            discussionCommentList.add(discussionCommentDTO);
        }

        return discussionCommentList;
    }

    /**
     * 保存讨论回复
     * @param discussionComment
     */
    @Override
    @Transactional
    public DiscussionComment saveDiscussionComment(DiscussionComment discussionComment) {
        Discussion discussion = discussionService.queryById(discussionComment.getDiscussionId());
        if (discussion == null) {
            throw new MyException("讨论不存在");
        }
        if (null == discussionComment.getParentCommentId()) {
            throw new MyException("回复不存在");
        }
        DiscussionComment dbDiscussionComment = this.queryById(discussionComment.getDiscussionCommentId());
        if (discussionComment.getParentCommentId() != -1 && dbDiscussionComment == null) {
            throw new MyException("回复不存在");
        }
        discussionComment.setUserId(CurrentUser.getUserId());
        discussionComment.setCommentTime(new Date());
        discussionCommentMapper.insert(discussionComment);
        return discussionComment;
    }
}
