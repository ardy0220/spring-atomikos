package com.erp.dao.impl;

import com.erp.dao.IPermissionDao;
import com.erp.entity.Permission;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wang_ on 2016-09-21.
 */
@Repository
public class PermissionDaoImpl implements IPermissionDao {
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory mssqlSessionFactory) {
        this.sqlSessionTemplate = new SqlSessionTemplate(mssqlSessionFactory);
    }

    /**
     * 查询
     *
     * @param moduleId
     * @return
     */
    @Override
    public List<Permission> queryPermissionByModuleId(String moduleId) {
        return sqlSessionTemplate.selectList("Permission.queryPermissionByModuleId", moduleId);
    }

    /**
     * @param permissionParam
     * @return
     */
    @Override
    public Permission queryPermissionById(Permission permissionParam) {
        return sqlSessionTemplate.selectOne("Permission.queryPermissionById", permissionParam);
    }

    /**
     * 插入、更新
     *
     * @param permission
     */
    @Override
    public void insertOrUpdatePermission(Permission permission) {
        if (permission.getPermissionId() == null) {
            sqlSessionTemplate.insert("Permission.insertPermission", permission);
        } else {
            sqlSessionTemplate.update("Permission.updatePermission", permission);
        }
    }

    /**
     * 删除
     *
     * @param permissionId
     */
    @Override
    public void deletePermission(String[] permissionId) {
        // 删除
        sqlSessionTemplate.update("Permission.deletePermission", Arrays.asList(permissionId));
        // 删除角色下分配的该权限
        sqlSessionTemplate.update("RolePermission.deleteRolePermissionByPermissionId", Arrays.asList(permissionId));
    }

}
