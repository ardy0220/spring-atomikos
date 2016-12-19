package com.erp.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * 模块
 * Created by wang_ on 2016-07-02.
 */
public class Module implements Serializable, Comparable<Module> {
    private static final long serialVersionUID = -5756605954520290982L;

    // 模块DBID
    private Integer moduleId;

    // 模块名称
    private String moduleName;

    // 模块地址
    private String href;

    // 父节点
    private Integer parentId;

    // 父节点类型（p:一层目录；m:二层或二层以下目录）
    private String parentType;

    // 是否显示
    private String display;

    // 排序
    private Integer disOrder;

    // 节点类型：“file”为叶子结点；“folder”为一、二级节点
    private String icon;

    // 子模块
    private Set<Module> children = new TreeSet<Module>();

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Integer getDisOrder() {
        return disOrder;
    }

    public void setDisOrder(Integer disOrder) {
        this.disOrder = disOrder;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Set<Module> getChildren() {
        return children;
    }

    public void setChildren(Set<Module> children) {
        this.children = children;
    }

    public void addChild(Module module) {
        this.children.add(module);
    }

    public boolean hasChildren() {
        return this.children.size() > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Module module = (Module) o;

        if (moduleId != null ? !moduleId.equals(module.moduleId) : module.moduleId != null) return false;
        return moduleName != null ? moduleName.equals(module.moduleName) : module.moduleName == null;

    }

    @Override
    public int hashCode() {
        int result = moduleId != null ? moduleId.hashCode() : 0;
        result = 31 * result + (moduleName != null ? moduleName.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Module m) {
        int result = this.disOrder - m.getDisOrder();
        return result == 0 ? this.moduleId - m.getModuleId() : result;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleId=" + moduleId +
                ", moduleName='" + moduleName + '\'' +
                ", href='" + href + '\'' +
                ", parentId=" + parentId +
                ", display=" + display +
                ", disOrder=" + disOrder +
                ", icon='" + icon + '\'' +
                ", children=" + children +
                '}';
    }

}
