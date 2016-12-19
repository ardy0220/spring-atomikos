package com.erp.dao;

import com.erp.entity.YW;

import java.util.List;

/**
 * Created by wang_ on 2016-06-30.
 */
public interface IReportDao {

    /**
     * ��ȡ�������ϸ(���dbidΪ���򷵻�ȫ����ϸ����)
     * @param dbid
     * @return
     */
    public List<YW> queryReportDatas(String dbid);

    /**
     * ���ӻ���������
     * @param insertList
     * @param updateList
     */
    public void insertOrUpdateReportData(List<YW> insertList, List<YW> updateList);

    /**
     * ɾ�������
     * @param ids
     */
    public void deleteReportData(String[] ids);

}
