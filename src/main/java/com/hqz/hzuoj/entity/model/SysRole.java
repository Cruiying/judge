package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = -11257860239675010L;

    @ApiModelProperty("${column.comment}")
    private Integer roleId;
    /**
    * 角色名称
    */
    @ApiModelProperty("角色名称")
    private String roleName;
    /**
    * 备注
    */
    @ApiModelProperty("备注")
    private String remark;
    /**
    * 创建者ID
    */
    @ApiModelProperty("创建者ID")
    private Integer createUserId;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createTime;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
