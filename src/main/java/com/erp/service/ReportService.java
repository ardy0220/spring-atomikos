package com.erp.service;

import com.erp.dao.IReportDao;
import com.erp.entity.YW;
import com.erp.exception.ServiceException;
import com.erp.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wang_ on 2016-07-02.
 */
@Service
public class ReportService {
    private static Logger logger = Logger.getLogger(ReportService.class);

    @Autowired
    private IReportDao reportDao;

    /**
     * 获取填报数据明细(如果dbid为空则返回全部明细数据)
     * @param dbid
     * @throws ServiceException
     */
    public JSONArray queryReportDatas(String dbid) throws ServiceException {
        JSONArray ywArray = new JSONArray();
        try {
            List<YW> ywList = reportDao.queryReportDatas(dbid);
            if (ywList.size() > 0) {
                JsonConfig config = new JsonConfig();
                config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

                for (YW yw : ywList) {
                    JSONObject ywObject = JSONObject.fromObject(yw, config);
                    ywArray.add(ywObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return ywArray;
    }

    /**
     * 增加或更新填报数据
     * 该方法适用于行增加，新增加的应该为插入插入，而修改的为更新业务
     *
     * @param insertList
     * @param updateList
     * @throws ServiceException
     */
    public void insertOrUpdateReportData(List<YW> insertList, List<YW> updateList) throws ServiceException {
        try {
            reportDao.insertOrUpdateReportData(insertList, updateList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入或更新填报数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 删除填报数据
     *
     * @param ids
     * @throws ServiceException
     */
    public void deleteReportData(String[] ids) throws ServiceException {
        try {
            reportDao.deleteReportData(ids);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除填报数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

}
