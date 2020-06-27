package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (Solution)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class Solution implements Serializable {
    private static final long serialVersionUID = -74483757005357866L;

    @ApiModelProperty("${column.comment}")
    private Integer solutionId;
    /**
    * 题目ID
    */
    @ApiModelProperty("题目ID")
    private Integer problemId;
    /**
    * 题解内容
    */
    @ApiModelProperty("题解内容")
    private String content;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
    * 审核结果
    */
    @ApiModelProperty("审核结果")
    private String statusCode;
    /**
    * 用户ID
    */
    @ApiModelProperty("用户ID")
    private Integer userId;
    /**
    * 标题
    */
    @ApiModelProperty("标题")
    private String title;
    /**
    * 修改时间
    */
    @ApiModelProperty("修改时间")
    private Date modifyTime;


    public Integer getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer solutionId) {
        this.solutionId = solutionId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
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

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}
