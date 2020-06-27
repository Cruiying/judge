package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (JudgeResult)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public class JudgeResult implements Serializable {
    private static final long serialVersionUID = -48842789369632693L;

    @ApiModelProperty("${column.comment}")
    private Integer judgeResultId;
    /**
    * 测评结果名称
    */
    @ApiModelProperty("测评结果名称")
    private String judgeName;
    /**
    * 测评结果名称缩写
    */
    @ApiModelProperty("测评结果名称缩写")
    private String judgeNameAbbr;


    public Integer getJudgeResultId() {
        return judgeResultId;
    }

    public void setJudgeResultId(Integer judgeResultId) {
        this.judgeResultId = judgeResultId;
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }

    public String getJudgeNameAbbr() {
        return judgeNameAbbr;
    }

    public void setJudgeNameAbbr(String judgeNameAbbr) {
        this.judgeNameAbbr = judgeNameAbbr;
    }

}
