package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (ContestRankInfo)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public class ContestRankInfo implements Serializable {
    private static final long serialVersionUID = 982493185843314396L;

    @ApiModelProperty("${column.comment}")
    private Integer contestRankInfoId;
    /**
    * 比赛排名
    */
    @ApiModelProperty("比赛排名")
    private Integer contestRankId;
    /**
    * 比赛题目
    */
    @ApiModelProperty("比赛题目")
    private Integer problemId;
    /**
    * 是否是第一个通过该题目
    */
    @ApiModelProperty("是否是第一个通过该题目")
    private Object firstAccepted;
    /**
    * 获得罚时
    */
    @ApiModelProperty("获得罚时")
    private Date punishTime;
    /**
    * 获得分数
    */
    @ApiModelProperty("获得分数")
    private Integer score;
    /**
    * 是否通过该题目
    */
    @ApiModelProperty("是否通过该题目")
    private Object accepted;


    public Integer getContestRankInfoId() {
        return contestRankInfoId;
    }

    public void setContestRankInfoId(Integer contestRankInfoId) {
        this.contestRankInfoId = contestRankInfoId;
    }

    public Integer getContestRankId() {
        return contestRankId;
    }

    public void setContestRankId(Integer contestRankId) {
        this.contestRankId = contestRankId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Object getFirstAccepted() {
        return firstAccepted;
    }

    public void setFirstAccepted(Object firstAccepted) {
        this.firstAccepted = firstAccepted;
    }

    public Date getPunishTime() {
        return punishTime;
    }

    public void setPunishTime(Date punishTime) {
        this.punishTime = punishTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Object getAccepted() {
        return accepted;
    }

    public void setAccepted(Object accepted) {
        this.accepted = accepted;
    }

}
