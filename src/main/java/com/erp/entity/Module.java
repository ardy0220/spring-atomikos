package com.erp.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * ģ��
 * Created by wang_ on 2016-07-02.
 */
public class Module implements Serializable, Comparable<Module> {
    private static final long serialVersionUID = -5756605954520290982L;

    // ģ��DBID
    private Integer moduleId;

    // ģ������
    private String moduleName;

    // ģ���ַ
    private String href;

    // ���ڵ�
    private Integer parentId;

    // ���ڵ����ͣ�p:һ��Ŀ¼��m:������������Ŀ¼��
    private String parentType;

    // �Ƿ���ʾ
    private String display;

    // ����
    private Integer disOrder;

    // �ڵ����ͣ���file��ΪҶ�ӽ�㣻��folder��Ϊһ�������ڵ�
    private String icon;

    // ��ģ��
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
