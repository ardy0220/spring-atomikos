package com.erp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 填报
 * Created by wang_ on 2016-06-30.
 */
public class YW implements Serializable {
    private static final long serialVersionUID = 1395951501316240617L;

    // 主键
    private Integer dbid;

    // 物料编码
    private String wlbm;

    // 物料名称
    private String wlmc;

    // 供应商编码
    private String gysbm;

    // 供应商名称
    private String gysmc;

    // 单价
    private double price;

    // 购买数量
    private Integer number;

    // 购买人
    private Integer staffId;

    // 购买人名称
    private String staffName;

    // 购买时间
    private Date shoppingTime;

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

    public String getGysbm() {
        return gysbm;
    }

    public void setGysbm(String gysbm) {
        this.gysbm = gysbm;
    }

    public String getGysmc() {
        return gysmc;
    }

    public void setGysmc(String gysmc) {
        this.gysmc = gysmc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Date getShoppingTime() {
        return shoppingTime;
    }

    public void setShoppingTime(Date shoppingTime) {
        this.shoppingTime = shoppingTime;
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
        return "YW{" +
                "dbid=" + dbid +
                ", wlbm='" + wlbm + '\'' +
                ", wlmc='" + wlmc + '\'' +
                ", gysbm='" + gysbm + '\'' +
                ", gysmc='" + gysmc + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", staffId=" + staffId +
                ", staffName=" + staffName +
                ", shoppingTime=" + shoppingTime +
                ", delete=" + delete +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}
