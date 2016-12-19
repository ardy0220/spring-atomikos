package com.erp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wang_ on 2016-09-01.
 */
public class Jldw implements Serializable {
    private static final long serialVersionUID = 6565869482960724547L;

    // 计量单位ID，主键
    private Integer jldwId;

    // 计量单位名称
    private String jldwmc;

    // 计量单位描述
    private String jldwms;

    // 是否有效
    private String is_del;

    // 创建人
    private Integer create_staffId;

    // 创建时间
    private Date create_date;

    // 更新人
    private Integer update_staffId;

    // 更新时间
    private Date update_date;

    public Integer getJldwId() {
        return jldwId;
    }

    public void setJldwId(Integer jldwId) {
        this.jldwId = jldwId;
    }

    public String getJldwmc() {
        return jldwmc;
    }

    public void setJldwmc(String jldwmc) {
        this.jldwmc = jldwmc;
    }

    public String getJldwms() {
        return jldwms;
    }

    public void setJldwms(String jldwms) {
        this.jldwms = jldwms;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jldw jldw = (Jldw) o;

        return jldwId != null ? jldwId.equals(jldw.jldwId) : jldw.jldwId == null;

    }

    @Override
    public int hashCode() {
        return jldwId != null ? jldwId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Jldw{" +
                "jldwId=" + jldwId +
                ", jldwmc='" + jldwmc + '\'' +
                ", jldwms='" + jldwms + '\'' +
                ", is_del='" + is_del + '\'' +
                ", create_staffId=" + create_staffId +
                ", create_date=" + create_date +
                ", update_staffId=" + update_staffId +
                ", update_date=" + update_date +
                '}';
    }

}
