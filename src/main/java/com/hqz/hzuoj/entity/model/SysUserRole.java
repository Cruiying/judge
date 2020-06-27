package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (SysUserRole)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 450286358870088918L;

    @ApiModelProperty("${column.comment}")
    private Integer id;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
    * 角色id
    */
    @ApiModelProperty("角色id")
    private Integer roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
