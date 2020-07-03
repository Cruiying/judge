package com.hqz.hzuoj.entity.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class JudgeResultDTO implements Serializable {

    /**
     * 运行结束状态
     */
    @ApiModelProperty("结束状态")
    private Integer exitCode;

    /**
     * 使用时间
     */
    @ApiModelProperty("使用时间")
    private Integer usedTime;

    /**
     * 使用内存
     */
    @ApiModelProperty("使用内存")
    private Integer usedMemory;


    public Integer getExitCode() {
        return exitCode;
    }

    public void setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
    }

    public Integer getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Integer usedTime) {
        this.usedTime = usedTime;
    }

    public Integer getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(Integer usedMemory) {
        this.usedMemory = usedMemory;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "exitCode=" + exitCode +
                ", usedTime=" + usedTime +
                ", usedMemory=" + usedMemory +
                '}';
    }
}
