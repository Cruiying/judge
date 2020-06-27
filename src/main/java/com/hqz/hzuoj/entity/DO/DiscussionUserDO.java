package com.hqz.hzuoj.entity.DO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel()
public class DiscussionUserDO implements Serializable {

    @ApiModelProperty("id")
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
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    private String img;
    /**
     * 积分
     */
    @ApiModelProperty("积分")
    private Integer rating;

}
