package com.erp.dao.impl;

import com.erp.dao.ISerialNumberDao;
import com.erp.entity.SerialNumber;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wang_ on 2016-07-25.
 */
@Repository
public class SerialNumberDaoImpl implements ISerialNumberDao {
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 获得SerialNumber，如果没有获取到，则插入一条新的，否则更新序列号
     *
     * @param name
     * @return
     */
    @Override
    public long getSerialNumber(String name) {
        long serialNumberResult = -1L;
        SerialNumber serialNumber = sqlSessionTemplate.selectOne("SerialNumber.getSerialNumber", name);
        if (serialNumber != null) {
            serialNumberResult = serialNumber.getValue();
        }
        if (serialNumberResult == -1L) {
            sqlSessionTemplate.insert("SerialNumber.insertSerialNumber", name);
            serialNumberResult = 1L;
        } else {
            sqlSessionTemplate.update("SerialNumber.updateSerialNumber", name);
            serialNumberResult++;
        }
        return serialNumberResult;
    }

}
