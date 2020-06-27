package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (ContestRegister)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public class ContestRegister implements Serializable {
    private static final long serialVersionUID = -11499910831067565L;

    @ApiModelProperty("${column.comment}")
    private Integer contestRegisterId;
    /**
    * 比赛id
    */
    @ApiModelProperty("比赛id")
    private Integer contestId;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
    * 备注
    */
    @ApiModelProperty("备注")
    private String remarkName;
    /**
    * 注册时间
    */
    @ApiModelProperty("注册时间")
    private Date registerTime;
    /**
    * 用户注册前rating
    */
    @ApiModelProperty("用户注册前rating")
    private Integer beforeRating;
    /**
    * 用户注册后rating
    */
    @ApiModelProperty("用户注册后rating")
    private Integer afterRating;


    public Integer getContestRegisterId() {
        return contestRegisterId;
    }

    public void setContestRegisterId(Integer contestRegisterId) {
        this.contestRegisterId = contestRegisterId;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getBeforeRating() {
        return beforeRating;
    }

    public void setBeforeRating(Integer beforeRating) {
        this.beforeRating = beforeRating;
    }

    public Integer getAfterRating() {
        return afterRating;
    }

    public void setAfterRating(Integer afterRating) {
        this.afterRating = afterRating;
    }

}
