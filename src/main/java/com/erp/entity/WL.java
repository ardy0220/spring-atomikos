package com.erp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 物料
 * Created by wang_ on 2016-06-29.
 */
public class WL implements Serializable {
    private static final long serialVersionUID = 184341843415844624L;

    // 物料DBID
    private Integer wlId;

    // 物料编码
    private String wlbm;

    // 物料名称
    private String wlmc;

    // 物料描述
    private String wlms;

    // 是否删除
    private boolean delete;

    // 创建人
    private Integer create_staffId;

    // 创建时间
    private java.util.Date create_date;

    // 更新人
    private Integer update_staffId;

    // 更新时间
    private java.util.Date update_date;

    public Integer getWlId() {
        return wlId;
    }

    public void setWlId(Integer wlId) {
        this.wlId = wlId;
    }

    public String getWlbm() {
        return wlbm;
    }

    public void setWlbm(String wlbm) {
        this.wlbm = wlbm;
    }

    public String getWlmc() {
        return wlmc;
    }

    public void setWlmc(String wlmc) {
        this.wlmc = wlmc;
    }

    public String getWlms() {
        return wlms;
    }

    public void setWlms(String wlms) {
        this.wlms = wlms;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
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

    @Override
    public int hashCode() {
        return this.wlbm.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof WL) {
            WL wl = (WL) obj;
            if (this.wlbm.equals(wl.getWlbm())) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "WL{" +
                "wlId=" + wlId +
                ", wlbm='" + wlbm + '\'' +
                ", wlmc='" + wlmc + '\'' +
                ", wlms='" + wlms + '\'' +
                ", delete=" + delete +
                ", create_staffId=" + create_staffId +
                ", create_date=" + create_date +
                ", update_staffId=" + update_staffId +
                ", update_date=" + update_date +
                '}';
    }
}
