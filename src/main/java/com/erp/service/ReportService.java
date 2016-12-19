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
     * ��ȡ�������ϸ(���dbidΪ���򷵻�ȫ����ϸ����)
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
            logger.error("��ѯ����ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return ywArray;
    }

    /**
     * ���ӻ���������
     * �÷��������������ӣ������ӵ�Ӧ��Ϊ������룬���޸ĵ�Ϊ����ҵ��
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
            logger.error("�������������ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * ɾ�������
     *
     * @param ids
     * @throws ServiceException
     */
    public void deleteReportData(String[] ids) throws ServiceException {
        try {
            reportDao.deleteReportData(ids);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ɾ�������ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

}
