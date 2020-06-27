package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (DiscussionComment)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public class DiscussionComment implements Serializable {
    private static final long serialVersionUID = 667016997801863146L;

    @ApiModelProperty("${column.comment}")
    private Integer discussionCommentId;
    /**
    * 讨论id
    */
    @ApiModelProperty("讨论id")
    private Integer discussionId;
    /**
    * 回复内容
    */
    @ApiModelProperty("回复内容")
    private String content;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
    * 回复时间
    */
    @ApiModelProperty("回复时间")
    private Date commentTime;
    /**
    * 回复父亲节点
    */
    @ApiModelProperty("回复父亲节点")
    private Integer parentCommentId;


    public Integer getDiscussionCommentId() {
        return discussionCommentId;
    }

    public void setDiscussionCommentId(Integer discussionCommentId) {
        this.discussionCommentId = discussionCommentId;
    }

    public Integer getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Integer discussionId) {
        this.discussionId = discussionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

}
