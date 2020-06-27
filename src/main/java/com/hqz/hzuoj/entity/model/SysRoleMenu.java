package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (SysRoleMenu)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = 735405844073016969L;

    @ApiModelProperty("${column.comment}")
    private Integer id;

    @ApiModelProperty("${column.comment}")
    private Integer roleId;

    @ApiModelProperty("${column.comment}")
    private Integer menuId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

}
