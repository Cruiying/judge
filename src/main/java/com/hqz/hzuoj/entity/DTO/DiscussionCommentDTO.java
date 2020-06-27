package com.hqz.hzuoj.entity.DTO;

import com.hqz.hzuoj.entity.model.DiscussionComment;
import com.hqz.hzuoj.entity.model.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class DiscussionCommentDTO implements Serializable {
    /**
     * 讨论回复
     */
    @ApiModelProperty("讨论回复")
    private DiscussionComment discussionComment;
    /**
     * 父亲回复
     */
    @ApiModelProperty("父亲回复")
    private DiscussionComment parentDiscussionComment;
    /**
     * 回复用户
     */
    @ApiModelProperty("回复用户")
    private User user;
    /**
     * 父亲回复用户
     */
    @ApiModelProperty("父亲回复用户")
    private User parentUser;

    public DiscussionComment getDiscussionComment() {
        return discussionComment;
    }

    public void setDiscussionComment(DiscussionComment discussionComment) {
        this.discussionComment = discussionComment;
    }

    public DiscussionComment getParentDiscussionComment() {
        return parentDiscussionComment;
    }

    public void setParentDiscussionComment(DiscussionComment parentDiscussionComment) {
        this.parentDiscussionComment = parentDiscussionComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getParentUser() {
        return parentUser;
    }

    public void setParentUser(User parentUser) {
        this.parentUser = parentUser;
    }

    @Override
    public String toString() {
        return "DiscussionCommentDTO{" +
                "discussionComment=" + discussionComment +
                ", parentDiscussionComment=" + parentDiscussionComment +
                ", user=" + user +
                ", parentUser=" + parentUser +
                '}';
    }
}
