package com.erp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wang_ on 2016-10-25.
 */
public class SerialNumber implements Serializable {
    private static final long serialVersionUID = 7098709615078300596L;

    private Integer dbid;

    private String name;

    private Integer value;

    private Date create_date;

    private Date update_date;

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
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
        return "SerialNumber{" +
                "dbid=" + dbid +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}
