package com.hqz.hzuoj.entity.DO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("")
public class SubmitDO implements Serializable {

    @ApiModelProperty("${column.comment}")
    private Integer submitId;

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
     * 语言名称
     */
    @ApiModelProperty("语言名称")
    private String name;

    /**
     * 代码长度
     */
    @ApiModelProperty("代码长度")
    private Integer codeLength;
    /**
     * 测评结果
     */
    @ApiModelProperty("测评结果")
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
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 积分
     */
    @ApiModelProperty("积分")
    private Integer rating;

    /**
     * 题目ID
     */
    @ApiModelProperty("题目ID")
    private Integer problemId;

    /**
     * 题目标题
     */
    @ApiModelProperty("题目标题")
    private String title;

    public Integer getSubmitId() {
        return submitId;
    }

    public void setSubmitId(Integer submitId) {
        this.submitId = submitId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(Integer codeLength) {
        this.codeLength = codeLength;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SubmitDO{" +
                "submitId=" + submitId +
                ", submitTime=" + submitTime +
                ", code='" + code + '\'' +
                ", compileInfo='" + compileInfo + '\'' +
                ", languageId=" + languageId +
                ", name='" + name + '\'' +
                ", codeLength=" + codeLength +
                ", judgeResultId=" + judgeResultId +
                ", judgeName='" + judgeName + '\'' +
                ", judgeNameAbbr='" + judgeNameAbbr + '\'' +
                ", score=" + score +
                ", runtimeTime=" + runtimeTime +
                ", runtimeMemory=" + runtimeMemory +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", rating=" + rating +
                ", problemId=" + problemId +
                ", title='" + title + '\'' +
                '}';
    }
}
