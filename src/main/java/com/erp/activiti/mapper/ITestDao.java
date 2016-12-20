package com.erp.activiti.mapper;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * ITestDao
 *
 * @author wang_
 * @date 2016-12-19
 */
@Repository
public interface ITestDao {

    /**
     * Ôö¼Ó
     * @param name
     * @throws Exception
     */
    public void insertData(String name);
}
