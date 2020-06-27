package com.hqz.hzuoj.entity.DO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class TagDO implements Serializable {

    /**
     * 标签
     */
    @ApiModelProperty("标签")
    private String tagCode;
    /**
     * 标签名称
     */
    @ApiModelProperty("标签名称")
    private String tagName;


}
