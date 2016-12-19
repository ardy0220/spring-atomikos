package com.erp.service;

import com.erp.dao.IRoleDao;
import com.erp.entity.Role;
import com.erp.entity.RolePermission;
import com.erp.exception.ServiceException;
import com.erp.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang_ on 2016-09-22.
 */
@Service
public class RoleService {
    private static Logger logger = Logger.getLogger(RoleService.class);

    @Autowired
    private IRoleDao roleDao;

    /**
     * 查询
     *
     * @return
     * @throws ServiceException
     */
    public JSONArray queryRole() throws ServiceException{
        JSONArray array = new JSONArray();
        try {
            List<Role> roleList = roleDao.queryRole();
            if (roleList != null && roleList.size() > 0) {
                for (Role role : roleList) {
                    JSONObject object = JSONObject.fromObject(role);
                    array.add(object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询权限数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return array;
    }

    /**
     * @param roleCode
     * @param roleId
     * @return
     * @throws ServiceException
     */
    public Role queryRoleByRoleId(String roleCode, String roleId) throws ServiceException {
        Role role=null;
        try {
            Role roleParam = new Role();
            roleParam.setRoleId(StringUtil.isEmpty(roleId)?null:Integer.valueOf(roleId));
            roleParam.setRoleCode(roleCode);
            role = roleDao.queryRoleByRoleId(roleParam);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询权限数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return role;
    }

    /**
     * 增加或修改
     *
     * @param role
     * @param flag
     * @throws ServiceException
     */
    public void insertOrUpdateRole(Role role, boolean flag) throws ServiceException {
        try {
            if (flag) role.setIs_init_permission("0");
            roleDao.insertOrUpdateRole(role, flag);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("增加或更新角色数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 删除
     *
     * @param roleId
     * @throws ServiceException
     */
    public void deleteRole(String[] roleId) throws ServiceException {
        try {
            roleDao.deleteRole(roleId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除角色数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 查询角色对应的权限
     * @param roleId
     * @throws ServiceException
     */
    public JSONArray queryRolePermission(String roleId) throws ServiceException {
        JSONArray array = new JSONArray();
        try {
            List<RolePermission> rolePermissionList = roleDao.queryRolePermission(roleId);
            if (rolePermissionList != null && rolePermissionList.size() > 0) {
                for (RolePermission rolePermission : rolePermissionList) {
                    JSONObject object = JSONObject.fromObject(rolePermission);
                    array.add(object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询角色权限数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return array;
    }

    /**
     * 增加角色对应的权限
     *
     * @param rolePermissionList
     * @throws ServiceException
     */
    public void insertRolePermission(List<RolePermission> rolePermissionList) throws ServiceException {
        try {
            roleDao.insertRolePermission(rolePermissionList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("增加角色权限数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 删除权限
     *
     * @param roleId
     * @param dbid
     * @param flag
     * @throws ServiceException
     */
    public void deleteRolePermission(String roleId, String[] dbid, boolean flag) throws ServiceException {
        try {
            roleDao.deleteRolePermission(roleId, dbid, flag);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除角色权限数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

}
