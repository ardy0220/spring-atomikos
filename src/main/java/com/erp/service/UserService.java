package com.erp.service;

import com.erp.mybatis.mapper.IUserDao;
import com.erp.entity.StaffInfo;
import com.erp.exception.ServiceException;
import com.erp.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wang_ on 2016-07-27.
 */
@Service
public class UserService {
    private static Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private IUserDao userDao;

    /**
     * ��ѯ�û���Ϣ�����dbidΪ�գ����ѯȫ���û�
     *
     * @param dbid
     * @return
     * @throws ServiceException
     */
    public JSONArray queryUserData(String dbid) throws ServiceException {
        JSONArray user_array = new JSONArray();
        try {
            List<StaffInfo> staffInfoList = userDao.queryUserData(dbid);
            if (staffInfoList.size() > 0) {
                JsonConfig config = new JsonConfig();
                config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss"));

                for (StaffInfo staffInfo : staffInfoList) {
                    JSONObject user_object = JSONObject.fromObject(staffInfo, config);
                    user_array.add(user_object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("��ѯ�û���Ϣʧ��:" + e.getMessage(), e);
            throw new ServiceException(e);
        }

        return user_array;
    }

    /**
     * �����û�
     *
     * @param staffInfo
     * @throws ServiceException
     */
    public void insertUserData(StaffInfo staffInfo) throws ServiceException {
        try {
            userDao.insertUserData(staffInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("�����û�ʧ��:" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * �����û�
     *
     * @param staffInfo
     * @throws ServiceException
     */
    public void updateUserData(StaffInfo staffInfo) throws ServiceException {
        try {
            userDao.updateUserData(staffInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("�����û�ʧ��:" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * ɾ���û�
     *
     * @param ids
     * @throws ServiceException
     */
    public void deleteUserData(String[] ids) throws ServiceException {
        try {
            userDao.deleteUserData(ids);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ɾ���û�ʧ��:" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }
}
