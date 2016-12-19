package com.erp.bean;

import com.erp.service.SerialNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * –Ú¡–∫≈
 * Created by wang_ on 2016-07-26.
 */
@Component
public class SequenceBean {

    @Autowired
    private SerialNumberService serialNumberService;

    public synchronized long getNextSequence(String name) throws Exception {
        return serialNumberService.initSerialNumber(name);
    }

}
