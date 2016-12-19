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
     * 插入模块
     *
     * @param module
     * @throws ServiceException
     */
    public void insertModule(Module module) throws ServiceException {
        try {
            moduleDao.insertModule(module);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入模块失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 更新模块
     *
     * @param module
     * @throws ServiceException
     */
    public void updateModule(Module module) throws ServiceException {
        try {
            moduleDao.updateModule(module);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新模块失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 更新模块
     *
     * @param id
     * @throws ServiceException
     */
    public void resumeModule(String id) throws ServiceException {
        try {
            moduleDao.resumeModule(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改模块失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 删除节点
     *
     * @param ids
     * @throws ServiceException
     */
    public void deleteModule(String[] ids) throws ServiceException {
        try {
            moduleDao.deleteModule(Arrays.asList(ids));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除模块失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

}
