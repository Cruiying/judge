package com.hqz.hzuoj.entity.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("讨论回复")
public class DiscussionCommentVO implements Serializable {

    /**
     * 回复讨论id
     */
    @ApiModelProperty("回复讨论")
    private Integer discussionId;

    /**
     * 父亲回复id
     */
    @ApiModelProperty("父亲回复ID")
    private Integer parentCommentId;
    /**
     * 回复内容
     */
    @ApiModelProperty("回复内容")
    private String content;

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

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    @Override
    public String toString() {
        return "DiscussionCommentVO{" +
                "discussionId=" + discussionId +
                ", parentCommentId=" + parentCommentId +
                ", content='" + content + '\'' +
                '}';
    }
}
