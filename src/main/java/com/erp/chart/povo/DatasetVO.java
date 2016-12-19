package com.erp.chart.povo;

import java.io.Serializable;

/**
 * DatasetVo
 *
 * @author wang_
 * @date 2016-11-23
 */
public class DatasetVO implements Serializable {

    private double price;

    private String wlmc;

    private String shopping_time;

    private String yjyf;

    private String yjmc;

    private double yjye;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWlmc() {
        return wlmc;
    }

    public void setWlmc(String wlmc) {
        this.wlmc = wlmc;
    }

    public String getShopping_time() {
        return shopping_time;
    }

    public void setShopping_time(String shopping_time) {
        this.shopping_time = shopping_time;
    }

    public String getYjyf() {
        return yjyf;
    }

    public void setYjyf(String yjyf) {
        this.yjyf = yjyf;
    }

    public String getYjmc() {
        return yjmc;
    }

    public void setYjmc(String yjmc) {
        this.yjmc = yjmc;
    }

    public double getYjye() {
        return yjye;
    }

    public void setYjye(double yjye) {
        this.yjye = yjye;
    }

    @Override
    public String toString() {
        return "DatasetVo{" +
                "price=" + price +
                ", wlmc='" + wlmc + '\'' +
                ", shopping_time=" + shopping_time +
                ", yjyf='" + yjyf + '\'' +
                ", yjmc='" + yjmc + '\'' +
                ", yjye=" + yjye +
                '}';
    }
}
