package com.erp.service;

import com.erp.mybatis.mapper.IModuleDao;
import com.erp.entity.Module;
import com.erp.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by wang_ on 2016-07-02.
 */
@Service
public class ModuleService {
    private static Logger logger = Logger.getLogger(ModuleService.class);

    @Autowired
    private IModuleDao moduleDao;

    /**
     * ����ģ��
     *
     * @param module
     * @throws ServiceException
     */
    public void insertModule(Module module) throws ServiceException {
        try {
            moduleDao.insertModule(module);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("����ģ��ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * ����ģ��
     *
     * @param module
     * @throws ServiceException
     */
    public void updateModule(Module module) throws ServiceException {
        try {
            moduleDao.updateModule(module);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("����ģ��ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * ����ģ��
     *
     * @param id
     * @throws ServiceException
     */
    public void resumeModule(String id) throws ServiceException {
        try {
            moduleDao.resumeModule(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("�޸�ģ��ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * ɾ���ڵ�
     *
     * @param ids
     * @throws ServiceException
     */
    public void deleteModule(String[] ids) throws ServiceException {
        try {
            moduleDao.deleteModule(Arrays.asList(ids));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ɾ��ģ��ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

}
