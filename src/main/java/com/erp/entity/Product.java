package com.erp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wang_ on 2016-08-26.
 */
public class Product implements Serializable, Comparable<Product> {
    private static final long serialVersionUID = -7203061780377086895L;

    // 商品ID
    private Integer productId;

    // 商品名称
    private String productName;

    // 商品描述
    private String productDesc;

    // 计量单位
    private Integer jldwId;

    // 计量单位名称
    private String jldwmc;

    // 单价
    private double price;

    // 缩略图URL
    private String thumbnailUrl;

    // 是否上架 1为上架；0为下架
    private String is_valid;

    // 是否删除
    private boolean delete;

    // 创建人
    private Integer create_staffId;

    // 创建人姓名
    private String create_staffName;

    // 创建时间
    private Date create_date;

    // 更新人
    private Integer update_staffId;

    // 更新人姓名
    private String update_staffName;

    // 更新时间
    private Date update_date;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(String is_valid) {
        this.is_valid = is_valid;
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

    public String getCreate_staffName() {
        return create_staffName;
    }

    public void setCreate_staffName(String create_staffName) {
        this.create_staffName = create_staffName;
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

    public String getUpdate_staffName() {
        return update_staffName;
    }

    public void setUpdate_staffName(String update_staffName) {
        this.update_staffName = update_staffName;
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

        Product product = (Product) o;

        if (productId != null ? !productId.equals(product.productId) : product.productId != null) return false;
        return productName != null ? productName.equals(product.productName) : product.productName == null;

    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", jldwid=" + jldwId +
                ", jldwmc=" + jldwmc +
                ", price=" + price +
                ", thumbnailUrl=" + thumbnailUrl +
                ", is_valid=" + is_valid +
                ", delete=" + delete +
                ", create_StaffId=" + create_staffId +
                ", create_staffName='" + create_staffName + '\'' +
                ", create_date=" + create_date +
                ", update_staffId=" + update_staffId +
                ", update_staffName='" + update_staffName + '\'' +
                ", update_date=" + update_date +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return (int) (this.productId - o.getProductId());
    }
}
