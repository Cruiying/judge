package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (ProblemData)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class ProblemData implements Serializable {
    private static final long serialVersionUID = -89850951177817956L;

    @ApiModelProperty("${column.comment}")
    private Integer problemDataId;
    /**
    * 题目ID
    */
    @ApiModelProperty("题目ID")
    private Integer problemId;
    /**
    * 输入文件路径
    */
    @ApiModelProperty("输入文件路径")
    private String inputPath;
    /**
    * 输出文件路径
    */
    @ApiModelProperty("输出文件路径")
    private String outputPath;
    /**
    * 最大运行内存限制
    */
    @ApiModelProperty("最大运行内存限制")
    private Integer maxRuntimeMemory;
    /**
    * 最大运行时间限制
    */
    @ApiModelProperty("最大运行时间限制")
    private Integer maxRuntimeTime;


    public Integer getProblemDataId() {
        return problemDataId;
    }

    public void setProblemDataId(Integer problemDataId) {
        this.problemDataId = problemDataId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public Integer getMaxRuntimeMemory() {
        return maxRuntimeMemory;
    }

    public void setMaxRuntimeMemory(Integer maxRuntimeMemory) {
        this.maxRuntimeMemory = maxRuntimeMemory;
    }

    public Integer getMaxRuntimeTime() {
        return maxRuntimeTime;
    }

    public void setMaxRuntimeTime(Integer maxRuntimeTime) {
        this.maxRuntimeTime = maxRuntimeTime;
    }

}
