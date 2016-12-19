package com.erp.service;

import com.erp.mybatis.mapper.IUserDao;
import com.erp.entity.StaffInfo;
import com.erp.exception.ServiceException;
import com.erp.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wang_ on 2016-07-02.
 */
@Service
public class LoginService {
    private static Logger logger = Logger.getLogger(LoginService.class);

    @Autowired
    private IUserDao loginDao;

    /**
     * ��½Service
     * @param staffCode
     * @return
     * @throws ServiceException
     */
    public StaffInfo queryStaffByCode(String staffId, String staffCode) throws ServiceException {
        if (StringUtil.isEmpty(staffCode)) return null;
        StaffInfo staffInfo=null;
        try {
            StaffInfo staffInfoParam = new StaffInfo();
            staffInfoParam.setStaffId(StringUtil.isEmpty(staffId)?null:Integer.valueOf(staffId));
            staffInfoParam.setStaffCode(staffCode);
            staffInfo = loginDao.queryStaffByCode(staffInfoParam);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("��ѯ��½�û���Ϣʧ��:" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return staffInfo;
    }

    /**
     * ��������¼ʱ��
     * @param staffCode
     */
    public void updateStaffByCode(String staffCode) throws ServiceException {
        if (StringUtil.isEmpty(staffCode)) return;
        try {
            loginDao.updateStaffByCode(staffCode);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("��������¼ʱ��ʧ��:" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }
}
