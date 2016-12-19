package com.erp.entity;

import java.io.Serializable;

/**
 * ����
 * Created by wang_ on 2016-07-15.
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 4130593380006794717L;

    // ������ĿID
    private Integer projectId;

    // ������Ŀ����
    private String projectCode;

    // ������Ŀ����
    private String projectName;

    // ��Ŀ����
    private String projectDesc;

    // ״̬����0��Ϊ��Ч����1��Ϊ��Ч
    private String status;

    // ��Ŀ·��
    private String url;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (!projectId.equals(project.projectId)) return false;
        return projectCode.equals(project.projectCode);

    }

    @Override
    public int hashCode() {
        int result = projectId.hashCode();
        result = 31 * result + projectCode.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectCode='" + projectCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectDesc='" + projectDesc + '\'' +
                ", status='" + status + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
