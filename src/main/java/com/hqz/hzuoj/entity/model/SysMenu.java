package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (SysMenu)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 834111755172697522L;

    @ApiModelProperty("${column.comment}")
    private Integer menuId;
    /**
    * 父亲菜单
    */
    @ApiModelProperty("父亲菜单")
    private Integer parentId;
    /**
    * 菜单名称
    */
    @ApiModelProperty("菜单名称")
    private Object name;
    /**
    * 路径
    */
    @ApiModelProperty("路径")
    private String url;
    /**
    * 权限列表
    */
    @ApiModelProperty("权限列表")
    private String perms;
    /**
    * 类型
    */
    @ApiModelProperty("类型")
    private Integer type;
    /**
    * 图标
    */
    @ApiModelProperty("图标")
    private Object icon;
    /**
    * 排序
    */
    @ApiModelProperty("排序")
    private Integer orderNum;


    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getIcon() {
        return icon;
    }

    public void setIcon(Object icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

}
