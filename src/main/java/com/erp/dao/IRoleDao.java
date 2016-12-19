package com.erp.dao;

import com.erp.entity.Role;
import com.erp.entity.RolePermission;

import java.util.List;

/**
 * Created by wang_ on 2016-09-22.
 */
public interface IRoleDao {

    /**
     * 查询
     * @return
     */
    public List<Role> queryRole();

    /**
     *
     * @param role
     * @return
     */
    public Role queryRoleByRoleId(Role role);

    /**
     * 增加或修改
     * @param role
     * @param flag 修改时是否修改了组编码？ 修改了为true
     */
    public void insertOrUpdateRole(Role role, boolean flag);

    /**
     * 删除
     * @param roleId
     */
    public void deleteRole(String[] roleId);

    /**
     * 查询角色对应的权限
     * @param roleId
     */
    public List<RolePermission> queryRolePermission(String roleId);

    /**
     * 增加角色对应的权限
     * @param rolePermissionList
     */
    public void insertRolePermission(List<RolePermission> rolePermissionList);

    /**
     * 删除权限
     * @param roleId
     * @param dbid
     * @param flag 删除的权限是否为最后几条，若为true：删除后，该角色下无对应权限
     */
    public void deleteRolePermission(String roleId, String[] dbid, boolean flag);

}
