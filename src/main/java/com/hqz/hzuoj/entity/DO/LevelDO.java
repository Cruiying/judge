package com.hqz.hzuoj.entity.DO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LevelDO implements Serializable {

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
}
