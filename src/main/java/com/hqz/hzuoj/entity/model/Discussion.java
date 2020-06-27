package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Table;
import java.util.Date;
import java.io.Serializable;

/**
 * (Discussion)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Table(name = "discussion")
public class Discussion implements Serializable {
    private static final long serialVersionUID = 449768813947354286L;

    @ApiModelProperty("${column.comment}")
    private Integer discussionId;
    /**
    * 内容
    */
    @ApiModelProperty("内容")
    private String content;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
    * 修改时间
    */
    @ApiModelProperty("修改时间")
    private Date modifyTime;
    /**
    * 标题
    */
    @ApiModelProperty("标题")
    private String title;
    /**
    * 是否置顶
    */
    @ApiModelProperty("是否置顶")
    private Object top;
    /**
    * 回复数量
    */
    @ApiModelProperty("回复数量")
    private Integer commentCount;
    /**
    * 点赞数量
    */
    @ApiModelProperty("点赞数量")
    private Integer commendCount;
    /**
    * 流量数量
    */
    @ApiModelProperty("流量数量")
    private Integer browseCount;


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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getTop() {
        return top;
    }

    public void setTop(Object top) {
        this.top = top;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getCommendCount() {
        return commendCount;
    }

    public void setCommendCount(Integer commendCount) {
        this.commendCount = commendCount;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }


    @Override
    public String toString() {
        return "Discussion{" +
                "discussionId=" + discussionId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", modifyTime=" + modifyTime +
                ", title='" + title + '\'' +
                ", top=" + top +
                ", commentCount=" + commentCount +
                ", commendCount=" + commendCount +
                ", browseCount=" + browseCount +
                '}';
    }
}
