package com.erp.service;

import com.erp.dao.ISerialNumberDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wang_ on 2016-07-26.
 */
@Service
public class SerialNumberService {
    private static Logger logger = Logger.getLogger(SerialNumberService.class);

    @Autowired
    private ISerialNumberDao serialNumberDao;

    /**
     *
     * @param name
     * @return
     */
    public long initSerialNumber(String name) {
        long serialNumber = -1L;
        try {
            serialNumber = serialNumberDao.getSerialNumber(name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取自增序列号失败:" + e.getMessage(), e);
        }
        return serialNumber;
    }
}
