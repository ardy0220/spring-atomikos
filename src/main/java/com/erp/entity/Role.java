package com.erp.entity;

import java.io.Serializable;

/**
 * Created by wang_ on 2016-09-22.
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -531914044867456896L;

    private Integer roleId;

    private String roleCode;

    private String roleName;

    private String roleDesc;

    private Integer groupId;

    private String groupName;

    private String modules;

    private String is_del;

    private String is_init_permission;

    private Integer permissionCount;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }

    public String getIs_del() {
        return is_del;
    }

    public void setIs_del(String is_del) {
        this.is_del = is_del;
    }

    public String getIs_init_permission() {
        return is_init_permission;
    }

    public void setIs_init_permission(String is_init_permission) {
        this.is_init_permission = is_init_permission;
    }

    public Integer getPermissionCount() {
        return permissionCount;
    }

    public void setPermissionCount(Integer permissionCount) {
        this.permissionCount = permissionCount;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", modules='" + modules + '\'' +
                ", is_del='" + is_del + '\'' +
                ", is_init_permission='" + is_init_permission + '\'' +
                ", permissionCount=" + permissionCount +
                '}';
    }
}
