package com.erp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wang_ on 2016-06-28.
 */
public class StaffInfo implements Serializable {
    private static final long serialVersionUID = 4382170598350399690L;

    // 用户ID
    private Integer staffId;

    // 用户编码
    private String staffCode;

    // 用户姓名
    private String staffName;

    // 密码
    private String password;

    // 手机号
    private String telephone;

    // 是否删除
    private boolean delete;

    // 主题样式ID
    private Integer styleId;

    // 主题样式
    private String style;

    private Integer roleId;

    private String roleName;

    // 用户类型
    private String staffType;

    private String modules;

    // 创建时间
    private Date create_date;

    // 更新时间
    private Date update_date;

    // 最后登录时间
    private Date last_login_time;

    private Set<Permission> permissions = new HashSet<>();

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

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

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
    }

    public boolean is_Admin() {
        return "1".equals(this.staffType);
    }

    @Override
    public String toString() {
        return "StaffInfo{" +
                "staffId=" + staffId +
                ", staffCode='" + staffCode + '\'' +
                ", staffName='" + staffName + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", delete=" + delete +
                ", styleId=" + styleId +
                ", style='" + style + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", staffType='" + staffType + '\'' +
                ", modules='" + modules + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                ", last_login_time=" + last_login_time +
                ", permissions=" + permissions +
                '}';
    }

    @Override
    public int hashCode() {
        return this.staffCode.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof StaffInfo) {
            StaffInfo staffInfo = (StaffInfo) obj;
            if (this.staffId.equals(staffInfo.getStaffId())
                    && this.staffCode.equals(staffInfo.getStaffCode())) {
                return true;
            }
        }
        return false;
    }
}
