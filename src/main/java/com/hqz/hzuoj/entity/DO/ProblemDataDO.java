package com.hqz.hzuoj.entity.DO;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (ProblemData)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class ProblemDataDO implements Serializable {

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

    @Override
    public String toString() {
        return "ProblemDataDO{" +
                "maxRuntimeMemory=" + maxRuntimeMemory +
                ", maxRuntimeTime=" + maxRuntimeTime +
                '}';
    }
}
