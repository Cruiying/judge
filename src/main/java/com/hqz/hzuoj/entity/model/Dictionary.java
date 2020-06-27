package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (Dictionary)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public class Dictionary implements Serializable {
    private static final long serialVersionUID = -84507976346344101L;

    @ApiModelProperty("${column.comment}")
    private Integer id;
    /**
    * 字典吗
    */
    @ApiModelProperty("字典吗")
    private String dicCode;
    /**
    * 字典名称
    */
    @ApiModelProperty("字典名称")
    private String dicName;
    /**
    * 备注
    */
    @ApiModelProperty("备注")
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
