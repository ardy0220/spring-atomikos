package com.erp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ��Ӧ��
 * Created by wang_ on 2016-06-29.
 */
public class Gys implements Serializable {
    private static final long serialVersionUID = -3945791285313760541L;

    // ��Ӧ��DBID
    private Integer gysId;

    // ��Ӧ�̱���
    private String gysbm;

    // ��Ӧ������
    private String gysmc;

    // ��Ӧ������
    private String gysms;

    // �Ƿ�ɾ��
    private boolean delete;

    // ������
    private Integer create_staffId;

    // ����ʱ��
    private java.util.Date create_date;

    // ������
    private Integer update_staffId;

    // ����ʱ��
    private java.util.Date update_date;

    public Integer getGysId() {
        return gysId;
    }

    public void setGysId(Integer gysId) {
        this.gysId = gysId;
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

    public String getGysms() {
        return gysms;
    }

    public void setGysms(String gysms) {
        this.gysms = gysms;
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
        return this.getGysbm().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Gys) {
            Gys gys = (Gys) obj;
            if (this.gysbm.equals(gys.getGysbm())) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Gys{" +
                "gysId=" + gysId +
                ", gysbm='" + gysbm + '\'' +
                ", gysmc='" + gysmc + '\'' +
                ", gysms='" + gysms + '\'' +
                ", delete=" + delete +
                ", create_staffId=" + create_staffId +
                ", create_date=" + create_date +
                ", update_staffId=" + update_staffId +
                ", update_date=" + update_date +
                '}';
    }
}
