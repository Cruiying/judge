package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (DictionaryOption)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public class DictionaryOption implements Serializable {
    private static final long serialVersionUID = 694076427165072317L;

    @ApiModelProperty("ID")
    private Integer id;
    /**
    * 字典码
    */
    @ApiModelProperty("字典码")
    private Integer dictId;
    /**
    * 字典选项码
    */
    @ApiModelProperty("字典选项码")
    private String optionCode;
    /**
    * 字典选项名称
    */
    @ApiModelProperty("字典选项名称")
    private String optionName;
    /**
    * 备注
    */
    @ApiModelProperty("备注")
    private String remark;
    /**
    * 排序
    */
    @ApiModelProperty("排序")
    private Integer sortNo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getOptionCode() {
        return optionCode;
    }

    public void setOptionCode(String optionCode) {
        this.optionCode = optionCode;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

}
