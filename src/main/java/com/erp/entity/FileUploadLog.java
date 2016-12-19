package com.erp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wang_ on 2016-09-06.
 */
public class FileUploadLog implements Serializable {
    private static final long serialVersionUID = 290560395649580873L;

    private Integer dbid;

    private Integer productId;

    private String name;

    private String url;

    private String thumbnailurl;

    private String deleteurl;

    private String is_pic_valid;

    private String is_del;

    private Integer create_staffId;

    private Date create_date;

    private Integer update_staffId;

    private Date update_date;

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailurl() {
        return thumbnailurl;
    }

    public void setThumbnailurl(String thumbnailurl) {
        this.thumbnailurl = thumbnailurl;
    }

    public String getDeleteurl() {
        return deleteurl;
    }

    public void setDeleteurl(String deleteurl) {
        this.deleteurl = deleteurl;
    }

    public String getIs_pic_valid() {
        return is_pic_valid;
    }

    public void setIs_pic_valid(String is_pic_valid) {
        this.is_pic_valid = is_pic_valid;
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
    public String toString() {
        return "FileUploadLog{" +
                "dbid=" + dbid +
                ", productId=" + productId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailurl='" + thumbnailurl + '\'' +
                ", deleteurl='" + deleteurl + '\'' +
                ", is_pic_valid='" + is_pic_valid + '\'' +
                ", is_del='" + is_del + '\'' +
                ", create_staffId=" + create_staffId +
                ", create_date=" + create_date +
                ", update_staffId=" + update_staffId +
                ", update_date=" + update_date +
                '}';
    }
}
