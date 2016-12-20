package com.erp.dao.impl;

import com.erp.dao.IRoleDao;
import com.erp.entity.Role;
import com.erp.entity.RolePermission;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wang_ on 2016-09-22.
 */
@Repository
public class RoleDaoImpl implements IRoleDao {
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory mssqlSessionFactory) {
        this.sqlSessionTemplate = new SqlSessionTemplate(mssqlSessionFactory);
    }

    /**
     * 查询
     *
     * @return
     */
    @Override
    public List<Role> queryRole() {
        return sqlSessionTemplate.selectList("Role.queryRole");
    }

    /**
     * @param roleParam
     * @return
     */
    @Override
    public Role queryRoleByRoleId(Role roleParam) {
        return sqlSessionTemplate.selectOne("Role.queryRoleByRoleId", roleParam);
    }

    /**
     * 增加或修改
     *
     * @param role
     * @param flag
     */
    @Override
    public void insertOrUpdateRole(Role role, boolean flag) {
        if (role.getRoleId() == null) {
            sqlSessionTemplate.insert("Role.insertRole", role);
        } else {
            sqlSessionTemplate.update("Role.updateRole", role);
            if (flag) {
                int[] roleIds = {role.getRoleId()};
                sqlSessionTemplate.update("Role.deleteRolePermissionByRoleId", Arrays.asList(roleIds));
            }
        }
    }

    /**
     * 删除
     *
     * @param roleId
     */
    @Override
    public void deleteRole(String[] roleId) {
        sqlSessionTemplate.update("Role.deleteRole", Arrays.asList(roleId));
        sqlSessionTemplate.update("Role.deleteRolePermissionByRoleId", Arrays.asList(roleId));
    }

    /**
     * 查询角色对应的权限
     *
     * @param roleId
     */
    @Override
    public List<RolePermission> queryRolePermission(String roleId) {
        return sqlSessionTemplate.selectList("RolePermission.queryRolePermission", roleId);
    }

    /**
     * 增加角色对应的权限
     *
     * @param rolePermissionList
     */
    @Override
    public void insertRolePermission(List<RolePermission> rolePermissionList) {
        sqlSessionTemplate.insert("RolePermission.insertRolePermission", rolePermissionList);
        sqlSessionTemplate.update("RolePermission.updateRoleByRoleId1", rolePermissionList.get(0).getRoleId());
    }

    /**
     * 删除权限
     *
     * @param roleId
     * @param dbid
     * @param flag
     */
    @Override
    public void deleteRolePermission(String roleId, String[] dbid, boolean flag) {
        sqlSessionTemplate.update("RolePermission.deleteRolePermissionByDbid", Arrays.asList(dbid));
        if (flag) {
            sqlSessionTemplate.update("RolePermission.updateRoleByRoleId0", roleId);
        }
    }

}
