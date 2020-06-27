package com.hqz.hzuoj.entity.DTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserTokenDTO implements Serializable {
    /**
     * 用戶ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;

    /**
     * 用户登录token
     */
    @ApiModelProperty("用户登录token")
    private String token;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
