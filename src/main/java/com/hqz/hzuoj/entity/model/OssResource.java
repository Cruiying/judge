package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (OssResource)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class OssResource implements Serializable {
    private static final long serialVersionUID = 433661702026329432L;

    @ApiModelProperty("${column.comment}")
    private Integer id;
    /**
    * 上传文件名
    */
    @ApiModelProperty("上传文件名")
    private String name;
    /**
    * 长传文件返回路径
    */
    @ApiModelProperty("长传文件返回路径")
    private String url;
    /**
    * 上传用户
    */
    @ApiModelProperty("上传用户")
    private Integer userId;
    /**
    * 上传时间
    */
    @ApiModelProperty("上传时间")
    private Date uploadTime;
    /**
    * 上传类型
    */
    @ApiModelProperty("上传类型")
    private String uploadType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }

}
