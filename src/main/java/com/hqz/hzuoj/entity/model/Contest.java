package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Contest)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
@Data
public class Contest implements Serializable {
    private static final long serialVersionUID = -56940215979472642L;
    /**
    * 主键
    */
    @ApiModelProperty("主键")
    private Integer contestId;
    /**
    * 比赛名称
    */
    @ApiModelProperty("比赛名称")
    private String name;
    /**
    * 比赛赛制类型
    */
    @ApiModelProperty("比赛赛制类型")
    private Integer typeCode;
    /**
    * 比赛注册人数
    */
    @ApiModelProperty("比赛注册人数")
    private Integer registerCount;
    /**
    * 比赛开始时间
    */
    @ApiModelProperty("比赛开始时间")
    private Date startTime;
    /**
    * 比赛结束时间
    */
    @ApiModelProperty("比赛结束时间")
    private Date endTime;
    /**
    * 比赛说明
    */
    @ApiModelProperty("比赛说明")
    private String explain;
    /**
    * 比赛创建人
    */
    @ApiModelProperty("比赛创建人")
    private Integer createId;
    /**
    * 比赛创建时间
    */
    @ApiModelProperty("比赛创建时间")
    private Date createTime;
    /**
    * 比赛最后修改人
    */
    @ApiModelProperty("比赛最后修改人")
    private Integer updateLastId;
    /**
    * 比赛最后修改时间
    */
    @ApiModelProperty("比赛最后修改时间")
    private Date updateLastTime;
    /**
    * 比赛注册开始事件
    */
    @ApiModelProperty("比赛注册开始事件")
    private Date registerStartTime;
    /**
    * 比赛注册结束时间
    */
    @ApiModelProperty("比赛注册结束时间")
    private Date registerEndTime;
    /**
    * 比赛状态类型
    */
    @ApiModelProperty("比赛状态类型")
    private String statusCode;
    /**
    * 比赛时长
    */
    @ApiModelProperty("比赛时长")
    private Long timeLength;
    /**
    * 公开类型类型
    */
    @ApiModelProperty("公开类型类型")
    private String publicCode;
    /**
    * 比赛注册状态类型
    */
    @ApiModelProperty("比赛注册状态类型")
    private String registerCode;
    /**
    * 是否计算rating
    */
    @ApiModelProperty("是否计算rating")
    private Object rating;
    /**
    * rating计算状态类型
    */
    @ApiModelProperty("rating计算状态类型")
    private String ratingCode;
    /**
    * 比赛排名状态类型
    */
    @ApiModelProperty("比赛排名状态类型")
    private String rankCode;
    /**
    * 是否终榜
    */
    @ApiModelProperty("是否终榜")
    private Object rankIsFinal;
    /**
    * 封榜时间
    */
    @ApiModelProperty("封榜时间")
    private Date finalTime;
    /**
    * 是否封榜
    */
    @ApiModelProperty("是否封榜")
    private Object rakingFinal;


    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(Integer registerCount) {
        this.registerCount = registerCount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
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

    public Integer getUpdateLastId() {
        return updateLastId;
    }

    public void setUpdateLastId(Integer updateLastId) {
        this.updateLastId = updateLastId;
    }

    public Date getUpdateLastTime() {
        return updateLastTime;
    }

    public void setUpdateLastTime(Date updateLastTime) {
        this.updateLastTime = updateLastTime;
    }

    public Date getRegisterStartTime() {
        return registerStartTime;
    }

    public void setRegisterStartTime(Date registerStartTime) {
        this.registerStartTime = registerStartTime;
    }

    public Date getRegisterEndTime() {
        return registerEndTime;
    }

    public void setRegisterEndTime(Date registerEndTime) {
        this.registerEndTime = registerEndTime;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Long getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Long timeLength) {
        this.timeLength = timeLength;
    }

    public String getPublicCode() {
        return publicCode;
    }

    public void setPublicCode(String publicCode) {
        this.publicCode = publicCode;
    }

    public String getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
    }

    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    public String getRatingCode() {
        return ratingCode;
    }

    public void setRatingCode(String ratingCode) {
        this.ratingCode = ratingCode;
    }

    public String getRankCode() {
        return rankCode;
    }

    public void setRankCode(String rankCode) {
        this.rankCode = rankCode;
    }

    public Object getRankIsFinal() {
        return rankIsFinal;
    }

    public void setRankIsFinal(Object rankIsFinal) {
        this.rankIsFinal = rankIsFinal;
    }

    public Date getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(Date finalTime) {
        this.finalTime = finalTime;
    }

    public Object getRakingFinal() {
        return rakingFinal;
    }

    public void setRakingFinal(Object rakingFinal) {
        this.rakingFinal = rakingFinal;
    }

}
