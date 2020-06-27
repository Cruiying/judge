package com.hqz.hzuoj.entity.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *用户登录表单提交数据
 */
@ApiModel("用户登录表单提交数据")
@Data
public class SysUserLoginFormVO implements Serializable {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("验证码")
    private String captcha;

    @ApiModelProperty("")
    private String uuid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "SysUserLoginFormVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", captcha='" + captcha + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
