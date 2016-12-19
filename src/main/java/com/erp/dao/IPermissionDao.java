package com.erp.dao;

import com.erp.entity.Permission;

import java.util.List;

/**
 * Created by wang_ on 2016-09-21.
 */
public interface IPermissionDao {

    /**
     * ��ѯ
     * @param moduleId
     * @return
     */
    public List<Permission> queryPermissionByModuleId(String moduleId);

    /**
     *
     * @param permission
     * @return
     */
    public Permission queryPermissionById(Permission permission);

    /**
     * ���롢����
     * @param permission
     */
    public void insertOrUpdatePermission(Permission permission);

    /**
     * ɾ��
     * @param permissionId
     */
    public void deletePermission(String[] permissionId);

}
