package com.erp.service;

import com.erp.entity.Group;
import com.erp.exception.ServiceException;
import com.erp.mybatis.mapper.IGroupDao;
import com.erp.util.JsonDateValueProcessor;
import com.erp.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wang_ on 2016-09-20.
 */
@Service
public class GroupService {
    private static Logger logger = Logger.getLogger(GroupService.class);

    @Autowired
    private IGroupDao groupDao;

    /**
     * 查询
     *
     * @return
     * @throws ServiceException
     */
    public JSONArray queryGroups() throws ServiceException {
        JSONArray array = new JSONArray();
        try {
            List<Group> groupList = groupDao.queryGroups();
            if (groupList != null && groupList.size() > 0) {
                JsonConfig config = new JsonConfig();
                config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

                for (Group group : groupList) {
                    JSONObject object = JSONObject.fromObject(group, config);
                    array.add(object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询组数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return array;
    }

    /**
     *
     * @param groupCode
     * @param groupId
     * @return
     * @throws ServiceException
     */
    public Group queryGroupByGroupId(String groupCode, String groupId) throws ServiceException {
        Group group = null;
        try {
            Group groupParam = new Group();
            groupParam.setGroupId(StringUtil.isEmpty(groupId)?null:Integer.valueOf(groupId));
            groupParam.setGroupCode(groupCode);
            group = groupDao.queryGroupByGroupId(groupParam);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询组数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }

        return group;
    }

    /**
     * 增加或修改
     *
     * @param group
     * @throws ServiceException
     */
    public void insertOrUpdateGroup(Group group) throws ServiceException {
        try {
            if (group.getGroupId() == null) {
                groupDao.insertGroup(group);
            } else {
                groupDao.updateGroup(group);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("增加或更新组数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 删除
     *
     * @param groupId
     * @param update_staffId
     * @throws ServiceException
     */
    public void deleteGroup(String[] groupId, String update_staffId) throws ServiceException {
        try {
            Map paramMap = new HashMap();
            paramMap.put("update_staffId", update_staffId);
            paramMap.put("groupIdList", Arrays.asList(groupId));
            groupDao.deleteGroup(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除组数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }
}
