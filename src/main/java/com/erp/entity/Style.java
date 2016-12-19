package com.erp.entity;

import java.io.Serializable;

/**
 * Created by wang_ on 2016-08-18.
 */
public class Style implements Serializable{
    private static final long serialVersionUID = 3420439642284504347L;

    private Integer styleId;

    private String style;

    private String styleDesc;

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyleDesc() {
        return styleDesc;
    }

    public void setStyleDesc(String styleDesc) {
        this.styleDesc = styleDesc;
    }

    @Override
    public String toString() {
        return "Style{" +
                "styleId=" + styleId +
                ", style='" + style + '\'' +
                ", styleDesc='" + styleDesc + '\'' +
                '}';
    }
}
