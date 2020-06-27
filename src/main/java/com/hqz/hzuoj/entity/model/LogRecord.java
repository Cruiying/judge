package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (LogRecord)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public class LogRecord implements Serializable {
    private static final long serialVersionUID = -21122234721711481L;

    @ApiModelProperty("${column.comment}")
    private Integer id;

    @ApiModelProperty("${column.comment}")
    private String record;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

}
