package com.erp.dao.impl;

import com.erp.dao.IYJDao;
import com.erp.entity.YJ;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by wang_ on 2016-08-04.
 */
@Repository
public class YJDaoImpl implements IYJDao {
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * ��ѯ�����½�����
     *
     * @param yjyf
     * @return
     */
    @Override
    public List<YJ> queryYJData(String yjyf) {
        Map paramMap = new HashMap();
        paramMap.put("yjyf", yjyf);
        paramMap.put("dbid", null);
        return sqlSessionTemplate.selectList("Yj.queryYJData", paramMap);
    }

    /**
     * @param yjyf
     * @param dbid
     * @return
     */
    @Override
    public YJ queryYJDataByDbid(String yjyf, String dbid) {
        Map paramMap = new HashMap();
        paramMap.put("yjyf", yjyf);
        paramMap.put("dbid", dbid);
        return sqlSessionTemplate.selectOne("Yj.queryYJData", paramMap);
    }

    /**
     * ��ѯ���һ�������½����
     *
     * @param yjyf
     * @param yjyf_before
     * @return
     */
    @Override
    public double queryLastDataBeforeCurrent(String yjyf, String yjyf_before) {
        Map paramMap = new HashMap();
        paramMap.put("yjyf", yjyf);
        paramMap.put("yjyf_before", yjyf_before);
        YJ yj = sqlSessionTemplate.selectOne("Yj.queryLastDataBeforeCurrent", paramMap);
        return yj == null ? 0d : yj.getYjye();
    }

    /**
     * �����½�����
     *
     * @param yj
     * @param yjye_cy
     */
    @Override
    public void insertYJData(YJ yj, double yjye_cy) {
        /**
         * �����½�����
         */
        sqlSessionTemplate.insert("Yj.insertYJData", yj);

        /**
         * ���ݵ�ǰ�½��·ݣ����Ҵ��ڵ�ǰ�½��·ݵ����ݣ������������ݵ��½���
         */
        Map paramMap = new HashMap();
        paramMap.put("yjyf", yj.getYjyf());
        paramMap.put("yjye_cy", yjye_cy);
        sqlSessionTemplate.update("Yj.updateYJDataAfterCurrent", paramMap);
    }

    /**
     * �����½�����
     *
     * @param yj
     * @param yjye_cy
     */
    @Override
    public void updateYJData(YJ yj, double yjye_cy) {
        sqlSessionTemplate.update("Yj.updateYJData", yj);

        /**
         * ���ݵ�ǰ�½��·ݣ����Ҵ��ڵ�ǰ�½��·ݵ����ݣ������������ݵ��½���
         */
        Map paramMap = new HashMap();
        paramMap.put("yjyf", yj.getYjyf());
        paramMap.put("yjye_cy", yjye_cy);
        sqlSessionTemplate.update("Yj.updateYJDataAfterCurrent", paramMap);

    }

    /**
     * @param del_yj
     * @param del_yjye_cy
     * @param yj
     * @param insert_yjye_cy
     */
    @Override
    public void deleteOrInsert(YJ del_yj, double del_yjye_cy, YJ yj, double insert_yjye_cy) {
        /**
         * �߼�ɾ�������� ����dbid����ɾ���½�����
         */
        sqlSessionTemplate.update("Yj.deleteYJData", del_yj.getDbid());

        /**
         * ���ݵ�ǰ�½��·ݣ����Ҵ��ڵ�ǰ�½��·ݵ����ݣ������������ݵ��½���
         */
        Map paramMap = new HashMap();
        paramMap.put("yjyf", del_yj.getYjyf());
        paramMap.put("yjye_cy", del_yjye_cy);
        sqlSessionTemplate.update("Yj.updateYJDataAfterCurrent", paramMap);

        /**
         * �����½�����
         */
        sqlSessionTemplate.insert("Yj.insertYJData", yj);

        /**
         * ���ݵ�ǰ�½��·ݣ����Ҵ��ڵ�ǰ�½��·ݵ����ݣ������������ݵ��½���
         */
        paramMap.put("yjyf", yj.getYjyf());
        paramMap.put("yjye_cy", insert_yjye_cy);
        sqlSessionTemplate.update("Yj.updateYJDataAfterCurrent", paramMap);
    }

    /**
     * ����dbid����ɾ���½�����
     *
     * @param del_yj
     * @param yjye_cy
     */
    @Override
    public void deleteYJData(YJ del_yj, double yjye_cy) {
        /**
         * �߼�ɾ�������� ����dbid����ɾ���½�����
         */
        sqlSessionTemplate.update("Yj.deleteYJData", del_yj.getDbid());

        /**
         * ���ݵ�ǰ�½��·ݣ����Ҵ��ڵ�ǰ�½��·ݵ����ݣ������������ݵ��½���
         */
        Map paramMap = new HashMap();
        paramMap.put("yjyf", del_yj.getYjyf());
        paramMap.put("yjye_cy", yjye_cy);
        sqlSessionTemplate.update("Yj.updateYJDataAfterCurrent", paramMap);
    }

}
