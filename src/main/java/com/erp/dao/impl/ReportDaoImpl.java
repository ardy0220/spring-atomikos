package com.erp.dao.impl;

import com.erp.dao.IReportDao;
import com.erp.entity.YW;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wang_ on 2016-06-30.
 */
@Repository
public class ReportDaoImpl implements IReportDao {
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
    }


    /**
     * ��ȡ�������ϸ(���dbidΪ���򷵻�ȫ����ϸ����)
     *
     * @param dbid
     * @return
     */
    @Override
    public List<YW> queryReportDatas(String dbid) {
        return sqlSessionTemplate.selectList("Yw.queryReportDatas", dbid);
    }

    /**
     * ���ӻ���������
     * �÷��������������ӣ������ӵ�Ӧ��Ϊ������룬���޸ĵ�Ϊ����ҵ��
     *
     * @param insertList
     * @param updateList
     */
    @Override
    public void insertOrUpdateReportData(List<YW> insertList, List<YW> updateList) {
        sqlSessionTemplate.insert("Yw.insertReportData", insertList);
        sqlSessionTemplate.update("Yw.updateReportData", updateList);
    }

    /**
     * ɾ�������
     *
     * @param ids
     */
    @Override
    public void deleteReportData(String[] ids) {
        sqlSessionTemplate.update("Yw.deleteReportData", Arrays.asList(ids));
    }

}
