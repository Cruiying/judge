package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (Language)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public class Language implements Serializable {
    private static final long serialVersionUID = 251783745136160874L;

    @ApiModelProperty("${column.comment}")
    private Integer languageId;
    /**
    * 语言名称
    */
    @ApiModelProperty("语言名称")
    private String name;
    /**
    * 编译命令
    */
    @ApiModelProperty("编译命令")
    private String compileCmd;
    /**
    * 运行命令
    */
    @ApiModelProperty("运行命令")
    private String runtimeCmd;
    /**
    * 前端展示
    */
    @ApiModelProperty("前端展示")
    private String model;
    /**
    * 后缀名
    */
    @ApiModelProperty("后缀名")
    private String suffix;
    /**
    * 相对于C/C++语言时间倍数
    */
    @ApiModelProperty("相对于C/C++语言时间倍数")
    private Integer mulTime;
    /**
    * 相对于C/C++语言内存倍数
    */
    @ApiModelProperty("相对于C/C++语言内存倍数")
    private Integer mulMemory;


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

    public String getCompileCmd() {
        return compileCmd;
    }

    public void setCompileCmd(String compileCmd) {
        this.compileCmd = compileCmd;
    }

    public String getRuntimeCmd() {
        return runtimeCmd;
    }

    public void setRuntimeCmd(String runtimeCmd) {
        this.runtimeCmd = runtimeCmd;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getMulTime() {
        return mulTime;
    }

    public void setMulTime(Integer mulTime) {
        this.mulTime = mulTime;
    }

    public Integer getMulMemory() {
        return mulMemory;
    }

    public void setMulMemory(Integer mulMemory) {
        this.mulMemory = mulMemory;
    }

}
