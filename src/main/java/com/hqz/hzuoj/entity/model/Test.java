package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Test implements Serializable {

    @ApiModelProperty("自测id")
    private Integer testId;

    @ApiModelProperty("自测代码")
    private String code;

    @ApiModelProperty("自测输出")
    private String output;

    @ApiModelProperty("自测输入")
    private String input;

    @ApiModelProperty("自测代码运行输出")
    private String runtimeOutput;

    @ApiModelProperty("编译信息")
    private String compileInfo;

    @ApiModelProperty("语言id")
    private Integer languageId;

    @ApiModelProperty("结果id")
    private Integer judgeResultId;

    @ApiModelProperty("运行时间")
    private Integer runtimeTime;

    @ApiModelProperty("运行内存")
    private Integer runtimeMemory;

    @ApiModelProperty("时间限制")
    private Integer timeLimit;

    @ApiModelProperty("内存限制")
    private Integer memoryLimit;

    @ApiModelProperty("获得分数")
    private Integer score;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getRuntimeOutput() {
        return runtimeOutput;
    }

    public void setRuntimeOutput(String runtimeOutput) {
        this.runtimeOutput = runtimeOutput;
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

    public Integer getJudgeResultId() {
        return judgeResultId;
    }

    public void setJudgeResultId(Integer judgeResultId) {
        this.judgeResultId = judgeResultId;
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

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(Integer memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", code='" + code + '\'' +
                ", output='" + output + '\'' +
                ", input='" + input + '\'' +
                ", runtimeOutput='" + runtimeOutput + '\'' +
                ", compileInfo='" + compileInfo + '\'' +
                ", languageId=" + languageId +
                ", judgeResultId=" + judgeResultId +
                ", runtimeTime=" + runtimeTime +
                ", runtimeMemory=" + runtimeMemory +
                ", timeLimit=" + timeLimit +
                ", memoryLimit=" + memoryLimit +
                ", score=" + score +
                '}';
    }
}
