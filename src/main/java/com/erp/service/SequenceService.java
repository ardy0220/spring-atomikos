package com.erp.service;

import com.erp.bean.SequenceBean;
import com.erp.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wang_ on 2016-07-26.
 */
@Service
public class SequenceService {
    private static Logger logger = Logger.getLogger(SequenceService.class);

    @Autowired
    private SequenceBean sequenceBean;

    /**
     *
     * @param name
     * @param len
     * @return
     * @throws Exception
     */
    public String initSequence(String name, int len) throws Exception {
        long sn = sequenceBean.getNextSequence(name);

        if (sn < 1) {
            logger.error("序列号生成错误:生成的序列号小于1...");
            throw new ServiceException("序列号生成错误:生成的序列号小于1...");
        }
        String result = sn + "";
        if (len <= 0) {
            return result;
        }

        while (result.length() < len) {
            result = "0" + result;
        }

        return result;
    }
}
