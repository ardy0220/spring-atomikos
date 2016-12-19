package com.erp.rmi.dao.impl;

import com.erp.rmi.dao.IRmiService;

/**
 * Created by wang_ on 2016-11-17.
 */
public class RmiServiceImpl implements IRmiService {

    @Override
    public int plus(int a, int b) {
        return a + b;
    }
}
