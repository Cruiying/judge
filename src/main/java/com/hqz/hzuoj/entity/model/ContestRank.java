package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (ContestRank)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public class ContestRank implements Serializable {
    private static final long serialVersionUID = 512202872988418213L;

    @ApiModelProperty("${column.comment}")
    private Integer contestRankId;
    /**
    * 比赛id
    */
    @ApiModelProperty("比赛id")
    private Integer contestId;
    /**
    * 排名
    */
    @ApiModelProperty("排名")
    private Integer rank;
    /**
    * 比赛报名id
    */
    @ApiModelProperty("比赛报名id")
    private Integer contestRegisterId;
    /**
    * 通过题目数量
    */
    @ApiModelProperty("通过题目数量")
    private Integer totalAccepted;
    /**
    * 获得总分
    */
    @ApiModelProperty("获得总分")
    private Integer totalScore;
    /**
    * 总发送
    */
    @ApiModelProperty("总发送")
    private Integer totalPunish;


    public Integer getContestRankId() {
        return contestRankId;
    }

    public void setContestRankId(Integer contestRankId) {
        this.contestRankId = contestRankId;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getContestRegisterId() {
        return contestRegisterId;
    }

    public void setContestRegisterId(Integer contestRegisterId) {
        this.contestRegisterId = contestRegisterId;
    }

    public Integer getTotalAccepted() {
        return totalAccepted;
    }

    public void setTotalAccepted(Integer totalAccepted) {
        this.totalAccepted = totalAccepted;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getTotalPunish() {
        return totalPunish;
    }

    public void setTotalPunish(Integer totalPunish) {
        this.totalPunish = totalPunish;
    }

}
