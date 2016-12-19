package com.erp.service;

import com.erp.dao.IPermissionDao;
import com.erp.entity.Permission;
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
public class PermissionService {
    private static Logger logger = Logger.getLogger(PermissionService.class);

    @Autowired
    private IPermissionDao permissionDao;

    /**
     * 查询
     *
     * @param moduleId
     * @return
     * @throws ServiceException
     */
    public JSONArray queryPermissionByModuleId(String moduleId) throws ServiceException {
        JSONArray array = new JSONArray();
        try {
            List<Permission> permissionList = permissionDao.queryPermissionByModuleId(moduleId);
            if (permissionList != null && permissionList.size() > 0) {
                for (Permission permission : permissionList) {
                    JSONObject object = JSONObject.fromObject(permission);
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
     * @param permissionCode
     * @param permissionId
     * @return
     * @throws ServiceException
     */
    public Permission queryPermissionById(String permissionCode, String permissionId) throws ServiceException {
        Permission permission=null;
        try {
            Permission permissionParam = new Permission();
            permissionParam.setPermissionCode(permissionCode);
            permissionParam.setPermissionId(StringUtil.isEmpty(permissionId)?null:Integer.valueOf(permissionId));
            permission = permissionDao.queryPermissionById(permissionParam);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询权限数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return permission;
    }

    /**
     * 插入、更新
     *
     * @param permission
     * @throws ServiceException
     */
    public void insertOrUpdatePermission(Permission permission) throws ServiceException {
        try {
            permissionDao.insertOrUpdatePermission(permission);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入或更新权限数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 删除
     *
     * @param permissionId
     * @throws ServiceException
     */
    public void deletePermission(String[] permissionId) throws ServiceException {
        try {
            permissionDao.deletePermission(permissionId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除权限数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }
}
