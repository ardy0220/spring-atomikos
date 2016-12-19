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
     * 获取填报数据明细(如果dbid为空则返回全部明细数据)
     *
     * @param dbid
     * @return
     */
    @Override
    public List<YW> queryReportDatas(String dbid) {
        return sqlSessionTemplate.selectList("Yw.queryReportDatas", dbid);
    }

    /**
     * 增加或更新填报数据
     * 该方法适用于行增加，新增加的应该为插入插入，而修改的为更新业务
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
     * 删除填报数据
     *
     * @param ids
     */
    @Override
    public void deleteReportData(String[] ids) {
        sqlSessionTemplate.update("Yw.deleteReportData", Arrays.asList(ids));
    }

}
