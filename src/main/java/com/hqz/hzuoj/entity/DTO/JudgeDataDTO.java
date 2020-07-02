package com.hqz.hzuoj.entity.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class JudgeDataDTO implements Serializable {

    @ApiModelProperty("运行命令")
    private String cmd;

    @ApiModelProperty("运行输入文件路径")
    private String inputPath;

    @ApiModelProperty("运行输出文件路径")
    private String outputPath;

    @ApiModelProperty("时间限制")
    private Integer timeLimit;

    @ApiModelProperty("内存限制")
    private Integer memoryLimit;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
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

    @Override
    public String toString() {
        return "JudgeDataDTO{" +
                "cmd='" + cmd + '\'' +
                ", inputPath='" + inputPath + '\'' +
                ", outputPath='" + outputPath + '\'' +
                ", timeLimit=" + timeLimit +
                ", memoryLimit=" + memoryLimit +
                '}';
    }
}
