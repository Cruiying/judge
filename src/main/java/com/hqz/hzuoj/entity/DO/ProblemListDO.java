package com.hqz.hzuoj.entity.DO;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProblemListDO implements Serializable {
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
    /**
     * 是否通过
     */
    @ApiModelProperty("是否通过")
    private Boolean accepted;
    /**
     * 通过数量
     */
    @ApiModelProperty("通过数量")
    private Integer acceptedTotal;

    /**
     * 提交数量
     */
    @ApiModelProperty("提交数量")
    private Integer submitTotal;
    /**
     * 等级
     */
    @ApiModelProperty("等级")
    private String levelCode;
    /**
     * 等级名称
     */
    @ApiModelProperty("等级名称")
    private String levelName;
    /**
     * 标签
     */
    @ApiModelProperty("标签")
    private List<TagDO> tags;


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

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Integer getAcceptedTotal() {
        return acceptedTotal;
    }

    public void setAcceptedTotal(Integer acceptedTotal) {
        this.acceptedTotal = acceptedTotal;
    }

    public Integer getSubmitTotal() {
        return submitTotal;
    }

    public void setSubmitTotal(Integer submitTotal) {
        this.submitTotal = submitTotal;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public List<TagDO> getTags() {
        return tags;
    }

    public void setTags(List<TagDO> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "ProblemListDO{" +
                "problemId=" + problemId +
                ", title='" + title + '\'' +
                ", accepted=" + accepted +
                ", acceptedTotal=" + acceptedTotal +
                ", submitTotal=" + submitTotal +
                ", levelCode='" + levelCode + '\'' +
                ", levelName='" + levelName + '\'' +
                ", tags=" + tags +
                '}';
    }
}
