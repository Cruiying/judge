package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (ProblemTag)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class ProblemTag implements Serializable {
    private static final long serialVersionUID = -37139277718888132L;

    @ApiModelProperty("${column.comment}")
    private Integer problemTagId;
    /**
    * 题目ID
    */
    @ApiModelProperty("题目ID")
    private Integer problemId;
    /**
    * 标签
    */
    @ApiModelProperty("标签")
    private String tagCode;


    public Integer getProblemTagId() {
        return problemTagId;
    }

    public void setProblemTagId(Integer problemTagId) {
        this.problemTagId = problemTagId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

}
