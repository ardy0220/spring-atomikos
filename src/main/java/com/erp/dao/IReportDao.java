package com.erp.dao;

import com.erp.entity.YW;

import java.util.List;

/**
 * Created by wang_ on 2016-06-30.
 */
public interface IReportDao {

    /**
     * 获取填报数据明细(如果dbid为空则返回全部明细数据)
     * @param dbid
     * @return
     */
    public List<YW> queryReportDatas(String dbid);

    /**
     * 增加或更新填报数据
     * @param insertList
     * @param updateList
     */
    public void insertOrUpdateReportData(List<YW> insertList, List<YW> updateList);

    /**
     * 删除填报数据
     * @param ids
     */
    public void deleteReportData(String[] ids);

}
