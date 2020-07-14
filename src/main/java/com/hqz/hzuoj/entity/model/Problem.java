package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (Problem)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class Problem implements Serializable {
    private static final long serialVersionUID = -28479785288972201L;

    @ApiModelProperty("${column.comment}")
    private Integer problemId;
    /**
    * 公开类型
    */
    @ApiModelProperty("公开类型")
    private String publicCode;
    /**
    * 题目标题
    */
    @ApiModelProperty("题目标题")
    private String title;
    /**
    * 题目内容
    */
    @ApiModelProperty("题目内容")
    private String content;
    /**
    * 题目说明
    */
    @ApiModelProperty("题目说明")
    private String explanation;
    /**
    * 输入内容
    */
    @ApiModelProperty("输入内容")
    private String inputContent;
    /**
    * 输出内容
    */
    @ApiModelProperty("输出内容")
    private String outputContent;
    /**
    * 题目背景
    */
    @ApiModelProperty("题目背景")
    private String background;
    /**
    * 题目数据地址
    */
    @ApiModelProperty("题目数据地址")
    private String dataAddress;
    /**
    * 题目创建者
    */
    @ApiModelProperty("题目创建者")
    private Integer createId;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
    * 题目更新者
    */
    @ApiModelProperty("题目更新者")
    private Date updateTime;
    /**
    * 更新时间
    */
    @ApiModelProperty("更新时间")
    private Integer updateId;
    /**
    * 题目等级
    */
    @ApiModelProperty("题目等级")
    private String levelCode;
    /**
    * 题目数据版本
    */
    @ApiModelProperty("题目数据版本")
    private String dataVersion;


    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getPublicCode() {
        return publicCode;
    }

    public void setPublicCode(String publicCode) {
        this.publicCode = publicCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public String getOutputContent() {
        return outputContent;
    }

    public void setOutputContent(String outputContent) {
        this.outputContent = outputContent;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getDataAddress() {
        return dataAddress;
    }

    public void setDataAddress(String dataAddress) {
        this.dataAddress = dataAddress;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "problemId=" + problemId +
                ", publicCode='" + publicCode + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", explanation='" + explanation + '\'' +
                ", inputContent='" + inputContent + '\'' +
                ", outputContent='" + outputContent + '\'' +
                ", background='" + background + '\'' +
                ", dataAddress='" + dataAddress + '\'' +
                ", createId=" + createId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", updateId=" + updateId +
                ", levelCode='" + levelCode + '\'' +
                ", dataVersion='" + dataVersion + '\'' +
                '}';
    }
}
