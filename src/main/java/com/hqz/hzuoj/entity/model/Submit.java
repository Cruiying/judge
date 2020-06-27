package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (Submit)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class Submit implements Serializable {
    private static final long serialVersionUID = -49619821184281830L;

    @ApiModelProperty("${column.comment}")
    private Integer submitId;
    /**
    * 题目ID
    */
    @ApiModelProperty("题目ID")
    private Integer problemId;
    /**
    * 用户ID
    */
    @ApiModelProperty("用户ID")
    private Integer userId;
    /**
    * 提交时间
    */
    @ApiModelProperty("提交时间")
    private Date submitTime;
    /**
    * 提交代码
    */
    @ApiModelProperty("提交代码")
    private String code;
    /**
    * 编译信息
    */
    @ApiModelProperty("编译信息")
    private String compileInfo;
    /**
    * 语言ID
    */
    @ApiModelProperty("语言ID")
    private Integer languageId;
    /**
    * 代码长度
    */
    @ApiModelProperty("代码长度")
    private Integer codeLength;
    /**
    * 用户可见类型
    */
    @ApiModelProperty("用户可见类型")
    private String publicCode;
    /**
    * 测评结果
    */
    @ApiModelProperty("测评结果")
    private Integer judgeResultId;
    /**
    * 获得分数
    */
    @ApiModelProperty("获得分数")
    private Integer score;
    /**
    * 运行时间
    */
    @ApiModelProperty("运行时间")
    private Integer runtimeTime;
    /**
    * 运行内存
    */
    @ApiModelProperty("运行内存")
    private Integer runtimeMemory;
    /**
    * 提交类型
    */
    @ApiModelProperty("提交类型")
    private String submitType;


    public Integer getSubmitId() {
        return submitId;
    }

    public void setSubmitId(Integer submitId) {
        this.submitId = submitId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompileInfo() {
        return compileInfo;
    }

    public void setCompileInfo(String compileInfo) {
        this.compileInfo = compileInfo;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(Integer codeLength) {
        this.codeLength = codeLength;
    }

    public String getPublicCode() {
        return publicCode;
    }

    public void setPublicCode(String publicCode) {
        this.publicCode = publicCode;
    }

    public Integer getJudgeResultId() {
        return judgeResultId;
    }

    public void setJudgeResultId(Integer judgeResultId) {
        this.judgeResultId = judgeResultId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getRuntimeTime() {
        return runtimeTime;
    }

    public void setRuntimeTime(Integer runtimeTime) {
        this.runtimeTime = runtimeTime;
    }

    public Integer getRuntimeMemory() {
        return runtimeMemory;
    }

    public void setRuntimeMemory(Integer runtimeMemory) {
        this.runtimeMemory = runtimeMemory;
    }

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

}
