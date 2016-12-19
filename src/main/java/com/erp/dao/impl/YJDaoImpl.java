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
     * 查询所有月结数据
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
     * 查询最后一条数据月结余额
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
     * 插入月结数据
     *
     * @param yj
     * @param yjye_cy
     */
    @Override
    public void insertYJData(YJ yj, double yjye_cy) {
        /**
         * 插入月结数据
         */
        sqlSessionTemplate.insert("Yj.insertYJData", yj);

        /**
         * 根据当前月结月份，查找大于当前月结月份的数据，更新所有数据的月结余额。
         */
        Map paramMap = new HashMap();
        paramMap.put("yjyf", yj.getYjyf());
        paramMap.put("yjye_cy", yjye_cy);
        sqlSessionTemplate.update("Yj.updateYJDataAfterCurrent", paramMap);
    }

    /**
     * 更新月结数据
     *
     * @param yj
     * @param yjye_cy
     */
    @Override
    public void updateYJData(YJ yj, double yjye_cy) {
        sqlSessionTemplate.update("Yj.updateYJData", yj);

        /**
         * 根据当前月结月份，查找大于当前月结月份的数据，更新所有数据的月结余额。
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
         * 逻辑删除该数据 根据dbid主键删除月结数据
         */
        sqlSessionTemplate.update("Yj.deleteYJData", del_yj.getDbid());

        /**
         * 根据当前月结月份，查找大于当前月结月份的数据，更新所有数据的月结余额。
         */
        Map paramMap = new HashMap();
        paramMap.put("yjyf", del_yj.getYjyf());
        paramMap.put("yjye_cy", del_yjye_cy);
        sqlSessionTemplate.update("Yj.updateYJDataAfterCurrent", paramMap);

        /**
         * 插入月结数据
         */
        sqlSessionTemplate.insert("Yj.insertYJData", yj);

        /**
         * 根据当前月结月份，查找大于当前月结月份的数据，更新所有数据的月结余额。
         */
        paramMap.put("yjyf", yj.getYjyf());
        paramMap.put("yjye_cy", insert_yjye_cy);
        sqlSessionTemplate.update("Yj.updateYJDataAfterCurrent", paramMap);
    }

    /**
     * 根据dbid主键删除月结数据
     *
     * @param del_yj
     * @param yjye_cy
     */
    @Override
    public void deleteYJData(YJ del_yj, double yjye_cy) {
        /**
         * 逻辑删除该数据 根据dbid主键删除月结数据
         */
        sqlSessionTemplate.update("Yj.deleteYJData", del_yj.getDbid());

        /**
         * 根据当前月结月份，查找大于当前月结月份的数据，更新所有数据的月结余额。
         */
        Map paramMap = new HashMap();
        paramMap.put("yjyf", del_yj.getYjyf());
        paramMap.put("yjye_cy", yjye_cy);
        sqlSessionTemplate.update("Yj.updateYJDataAfterCurrent", paramMap);
    }

}
