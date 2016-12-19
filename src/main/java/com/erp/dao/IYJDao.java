package com.erp.dao;

import com.erp.entity.YJ;

import java.util.List;

/**
 * Created by wang_ on 2016-08-04.
 */
public interface IYJDao {

    /**
     * ��ѯ�����½�����
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
     * ��ѯ���һ�������½����
     *
     * @param yjyf
     * @param yjyf_before �༭�¶Ƚ�������ʱ������޸����ڣ����ֶ����޸�֮ǰ�����ڣ����������Ϊnull
     * @return
     */
    public double queryLastDataBeforeCurrent(String yjyf, String yjyf_before);

    /**
     * �����½�����
     * @param yj
     * @param yjye_cy
     */
    public void insertYJData(YJ yj, double yjye_cy);

    /**
     * �����½�����
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
     * ����dbid����ɾ���½�����
     * @param del_yj
     * @param yjye_cy
     */
    public void deleteYJData(YJ del_yj, double yjye_cy);

}
