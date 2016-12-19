package com.erp.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by wang_ on 2016-09-20.
 */
public class Group implements Serializable {
    private static final long serialVersionUID = 3535343419547122325L;

    private Integer groupId;

    private String groupCode;

    private String groupName;

    private String groupDesc;

    private String module;

    private String modules;

    private String is_del;

    private Integer create_staffId;

    private Date create_date;

    private Integer update_staffId;

    private Date update_date;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
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

    public Integer getCreate_staffId() {
        return create_staffId;
    }

    public void setCreate_staffId(Integer create_staffId) {
        this.create_staffId = create_staffId;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Integer getUpdate_staffId() {
        return update_staffId;
    }

    public void setUpdate_staffId(Integer update_staffId) {
        this.update_staffId = update_staffId;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public int getModulesListSize() {
        return modules.split(",").length;
    }

    public List getModulesList() {
        return Arrays.asList(modules.split(","));
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupCode='" + groupCode + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupDesc='" + groupDesc + '\'' +
                ", module='" + module + '\'' +
                ", modules='" + modules + '\'' +
                ", is_del='" + is_del + '\'' +
                ", create_staffId=" + create_staffId +
                ", create_date=" + create_date +
                ", update_staffId=" + update_staffId +
                ", update_date=" + update_date +
                '}';
    }
}
