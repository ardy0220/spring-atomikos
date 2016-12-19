package com.erp.entity;

import java.io.Serializable;

/**
 * Created by wang_ on 2016-09-22.
 */
public class RolePermission implements Serializable {
    private static final long serialVersionUID = -3478641913613249352L;

    private Integer dbid;

    private Integer roleId;

    private Integer permissionId;

    private String permissionCode;

    private String permissionName;

    private String permissionDesc;

    private String is_del;

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    public String getIs_del() {
        return is_del;
    }

    public void setIs_del(String is_del) {
        this.is_del = is_del;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "dbid=" + dbid +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                ", permissionCode='" + permissionCode + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", permissionDesc='" + permissionDesc + '\'' +
                ", is_del='" + is_del + '\'' +
                '}';
    }
}
