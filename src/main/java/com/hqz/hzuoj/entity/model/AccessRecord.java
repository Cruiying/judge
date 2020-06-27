package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (AccessRecord)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:30
 */
public class AccessRecord implements Serializable {
    private static final long serialVersionUID = -44909617032388010L;
    /**
    * 主键
    */
    @ApiModelProperty("主键")
    private Long id;
    /**
    * 访问时间
    */
    @ApiModelProperty("访问时间")
    private Date time;
    /**
    * 访问ip
    */
    @ApiModelProperty("访问ip")
    private String ip;
    /**
    * 访问url
    */
    @ApiModelProperty("访问url")
    private String url;
    /**
    * 访问用户
    */
    @ApiModelProperty("访问用户")
    private String user;
    /**
    * 访问api
    */
    @ApiModelProperty("访问api")
    private String api;
    /**
    * 访问数据
    */
    @ApiModelProperty("访问数据")
    private String data;
    /**
    * 访问时长
    */
    @ApiModelProperty("访问时长")
    private Long length;
    /**
    * 访问类型
    */
    @ApiModelProperty("访问类型")
    private String type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
