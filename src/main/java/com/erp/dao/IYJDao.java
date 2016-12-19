package com.erp.dao;

import com.erp.entity.YJ;

import java.util.List;

/**
 * Created by wang_ on 2016-08-04.
 */
public interface IYJDao {

    /**
     * 查询所有月结数据
     * @param yjyf
     * @return
     */
    public List<YJ> queryYJData(String yjyf);

    /**
     *
     * @param yjyf
     * @param dbid
     * @return
     */
    public YJ queryYJDataByDbid(String yjyf, String dbid);

    /**
     * 查询最后一条数据月结余额
     *
     * @param yjyf
     * @param yjyf_before 编辑月度结算数据时，如果修改日期，该字段是修改之前的日期，其他情况则为null
     * @return
     */
    public double queryLastDataBeforeCurrent(String yjyf, String yjyf_before);

    /**
     * 插入月结数据
     * @param yj
     * @param yjye_cy
     */
    public void insertYJData(YJ yj, double yjye_cy);

    /**
     * 更新月结数据
     * @param yj
     * @param yjye_cy
     */
    public void updateYJData(YJ yj, double yjye_cy);

    /**
     *
     * @param del_yj
     * @param del_yjye_cy
     * @param yj
     * @param insert_yjye_cy
     */
    public void deleteOrInsert(YJ del_yj, double del_yjye_cy, YJ yj, double insert_yjye_cy);

    /**
     * 根据dbid主键删除月结数据
     * @param del_yj
     * @param yjye_cy
     */
    public void deleteYJData(YJ del_yj, double yjye_cy);

}
