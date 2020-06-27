package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (ContestSubmit)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public class ContestSubmit implements Serializable {
    private static final long serialVersionUID = -92838562221966681L;

    @ApiModelProperty("${column.comment}")
    private Integer contestSubmitId;
    /**
    * 比赛ID
    */
    @ApiModelProperty("比赛ID")
    private Integer contestId;
    /**
    * 提交ID
    */
    @ApiModelProperty("提交ID")
    private Integer submitId;


    public Integer getContestSubmitId() {
        return contestSubmitId;
    }

    public void setContestSubmitId(Integer contestSubmitId) {
        this.contestSubmitId = contestSubmitId;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getSubmitId() {
        return submitId;
    }

    public void setSubmitId(Integer submitId) {
        this.submitId = submitId;
    }

}
