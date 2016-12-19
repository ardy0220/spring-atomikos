package com.erp.dao;

import com.erp.entity.Role;
import com.erp.entity.RolePermission;

import java.util.List;

/**
 * Created by wang_ on 2016-09-22.
 */
public interface IRoleDao {

    /**
     * ��ѯ
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
     * ���ӻ��޸�
     * @param role
     * @param flag �޸�ʱ�Ƿ��޸�������룿 �޸���Ϊtrue
     */
    public void insertOrUpdateRole(Role role, boolean flag);

    /**
     * ɾ��
     * @param roleId
     */
    public void deleteRole(String[] roleId);

    /**
     * ��ѯ��ɫ��Ӧ��Ȩ��
     * @param roleId
     */
    public List<RolePermission> queryRolePermission(String roleId);

    /**
     * ���ӽ�ɫ��Ӧ��Ȩ��
     * @param rolePermissionList
     */
    public void insertRolePermission(List<RolePermission> rolePermissionList);

    /**
     * ɾ��Ȩ��
     * @param roleId
     * @param dbid
     * @param flag ɾ����Ȩ���Ƿ�Ϊ���������Ϊtrue��ɾ���󣬸ý�ɫ���޶�ӦȨ��
     */
    public void deleteRolePermission(String roleId, String[] dbid, boolean flag);

}
