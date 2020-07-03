package com.hqz.hzuoj.entity.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RunnerResultDTO implements Serializable {

    /**
     * 运行结果
     */
    @ApiModelProperty("运行结果")
    private String result;
    /**
     * 运行时间
     */
    @ApiModelProperty("运行时间")
    private Integer usedTime;

    /**
     * 运行内存
     */
    @ApiModelProperty("运行内存")
    private Integer usedMemory;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
        return "RuntimeResult{" +
                "result='" + result + '\'' +
                ", usedTime=" + usedTime +
                ", usedMemory=" + usedMemory +
                '}';
    }
}
