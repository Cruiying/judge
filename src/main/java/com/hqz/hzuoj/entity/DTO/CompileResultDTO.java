package com.hqz.hzuoj.entity.DTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CompileResultDTO implements Serializable {
    /**
     * 编译是否成功
     */
    @ApiModelProperty("编译是否成功")
    private Boolean compileSuccess;

    /**
     * 编译信息
     */
    @ApiModelProperty("编译信息")
    private String compileInfo;

    public Boolean getCompileSuccess() {
        return compileSuccess;
    }

    public void setCompileSuccess(Boolean compileSuccess) {
        this.compileSuccess = compileSuccess;
    }

    public String getCompileInfo() {
        return compileInfo;
    }

    public void setCompileInfo(String compileInfo) {
        this.compileInfo = compileInfo;
    }

    @Override
    public String toString() {
        return "CompileResultDTO{" +
                "compileSuccess=" + compileSuccess +
                ", compileInfo='" + compileInfo + '\'' +
                '}';
    }
}
