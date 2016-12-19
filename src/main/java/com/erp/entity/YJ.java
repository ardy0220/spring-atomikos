package com.erp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 月结
 * Created by wang_ on 2016-08-04.
 */
public class YJ implements Serializable{
    private static final long serialVersionUID = -1046890881501500572L;

    // 主键
    private Integer dbid;

    // 月结月份
    private String yjyf;

    // 月结支出
    private double yjzc;

    // 月结划转
    private double yjhz;

    // 月结余额
    private double yjye;

    // 填报人
    private Integer staffId;

    // 填报人姓名
    private String staffName;

    // 月结类型：1为初始化数据，0为增加的数据
    private String yjlx;

    // 是否删除
    private boolean delete;

    // 创建时间
    private Date create_date;

    // 更新时间
    private Date update_date;

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getYjyf() {
        return yjyf;
    }

    public void setYjyf(String yjyf) {
        this.yjyf = yjyf;
    }

    public double getYjzc() {
        return yjzc;
    }

    public void setYjzc(double yjzc) {
        this.yjzc = yjzc;
    }

    public double getYjhz() {
        return yjhz;
    }

    public void setYjhz(double yjhz) {
        this.yjhz = yjhz;
    }

    public double getYjye() {
        return yjye;
    }

    public void setYjye(double yjye) {
        this.yjye = yjye;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getYjlx() {
        return yjlx;
    }

    public void setYjlx(String yjlx) {
        this.yjlx = yjlx;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
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

    @Override
    public String toString() {
        return "YJ{" +
                "dbid=" + dbid +
                ", yjyf='" + yjyf + '\'' +
                ", yjzc=" + yjzc +
                ", yjhz=" + yjhz +
                ", yjye=" + yjye +
                ", staffId=" + staffId +
                ", staffName=" + staffName +
                ", yjlx=" + yjlx +
                ", delete=" + delete +
                ", createDate=" + create_date +
                ", updateDate=" + update_date +
                '}';
    }
}
