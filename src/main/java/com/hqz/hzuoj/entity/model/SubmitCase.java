package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (SubmitCase)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class SubmitCase implements Serializable {
    private static final long serialVersionUID = -19770291699190789L;

    @ApiModelProperty("${column.comment}")
    private Integer submitCaseId;
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
    * 运行分数
    */
    @ApiModelProperty("运行分数")
    private Integer score;
    /**
    * 提交ID
    */
    @ApiModelProperty("提交ID")
    private Integer submitId;
    /**
    * 测评结果ID
    */
    @ApiModelProperty("测评结果ID")
    private Integer judgeResultId;


    public Integer getSubmitCaseId() {
        return submitCaseId;
    }

    public void setSubmitCaseId(Integer submitCaseId) {
        this.submitCaseId = submitCaseId;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getSubmitId() {
        return submitId;
    }

    public void setSubmitId(Integer submitId) {
        this.submitId = submitId;
    }

    public Integer getJudgeResultId() {
        return judgeResultId;
    }

    public void setJudgeResultId(Integer judgeResultId) {
        this.judgeResultId = judgeResultId;
    }

}
