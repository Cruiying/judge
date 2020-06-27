package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (ContestProblem)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public class ContestProblem implements Serializable {
    private static final long serialVersionUID = -69447665449660147L;

    @ApiModelProperty("${column.comment}")
    private Integer contestProblemId;
    /**
    * 题目id
    */
    @ApiModelProperty("题目id")
    private Integer problemId;
    /**
    * 比赛ID
    */
    @ApiModelProperty("比赛ID")
    private Integer contestId;
    /**
    * 分数
    */
    @ApiModelProperty("分数")
    private Integer score;


    public Integer getContestProblemId() {
        return contestProblemId;
    }

    public void setContestProblemId(Integer contestProblemId) {
        this.contestProblemId = contestProblemId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
