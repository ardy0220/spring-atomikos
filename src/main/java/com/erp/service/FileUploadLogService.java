package com.erp.service;

import com.erp.mybatis.mapper.IProductDao;
import com.erp.entity.FileUploadLog;
import com.erp.exception.ServiceException;
import com.erp.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wang_ on 2016-09-06.
 */
@Service
public class FileUploadLogService {
    private static Logger logger = Logger.getLogger(FileUploadLogService.class);

    @Autowired
    private IProductDao productDao;

    /**
     * ��ѯ����Ʒ���ϴ���ͼƬ
     *
     * @param productId ��ƷID
     * @param queryAll
     * @return
     * @throws ServiceException
     */
    public JSONArray queryFileUploadLog(String productId, boolean queryAll) throws ServiceException {
        JSONArray array = new JSONArray();
        try {
            Map paramMap = new HashMap();
            paramMap.put("queryAll", queryAll ? "0" : "1");
            paramMap.put("productId", productId);
            List<FileUploadLog> fileUploadLogList = productDao.queryFileUploadLog(paramMap);
            if (fileUploadLogList != null && fileUploadLogList.size() > 0) {
                JsonConfig config = new JsonConfig();
                config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

                for (FileUploadLog fileUploadLog : fileUploadLogList) {
                    JSONObject object = JSONObject.fromObject(fileUploadLog, config);
                    array.add(object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("��ѯ��ƷͼƬʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return array;
    }

    /**
     * ����
     *
     * @param fileUploadLog
     * @return
     * @throws ServiceException
     */
    public long insertFileUploadLog(FileUploadLog fileUploadLog) throws ServiceException {
        long dbid = 0L;
        try {
            dbid = productDao.insertFileUploadLog(fileUploadLog);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("������ƷͼƬʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }

        return dbid;
    }

    /**
     * ����
     *
     * @param productId
     * @param name
     * @param url
     * @param thumbnailUrl
     * @param staffId
     * @return
     * @throws ServiceException
     */
    public long insertFileUploadLog(String productId, String name, String url,
                                           String thumbnailUrl, String staffId) throws ServiceException {
        FileUploadLog fileUploadLog = new FileUploadLog();
        fileUploadLog.setProductId(Integer.valueOf(productId));
        fileUploadLog.setName(name);
        fileUploadLog.setUrl(url);
        fileUploadLog.setThumbnailurl(thumbnailUrl);
        fileUploadLog.setCreate_staffId(Integer.valueOf(staffId));
        fileUploadLog.setUpdate_staffId(Integer.valueOf(staffId));
        return insertFileUploadLog(fileUploadLog);
    }

    /**
     * ����deleteUrl�ֶ�
     *
     * @param dbid
     * @param deleteUrl
     * @param update_staffId
     * @throws ServiceException
     */
    public void updateFileUploadLog(long dbid, String deleteUrl, String update_staffId) throws ServiceException {
        try {
            Map paramMap = new HashMap();
            paramMap.put("deleteurl", deleteUrl);
            paramMap.put("update_staffId", update_staffId);
            paramMap.put("dbid", dbid);
            productDao.updateFileUploadLog(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("������ƷͼƬʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * �ָ���ɾ����������
     *
     * @param dbid           ����
     * @param is_pic_valid
     * @param update_staffId
     * @param del_flag
     * @throws ServiceException
     */
    public void resumeOrDeleteFileUploadLog(String dbid, String is_pic_valid, String update_staffId, boolean del_flag) throws ServiceException {
        try {
            Map paramMap = new HashMap();
            paramMap.put("is_pic_valid", is_pic_valid);
            paramMap.put("is_del", del_flag ? "1" : "0");
            paramMap.put("update_staffId", update_staffId);
            paramMap.put("dbid", dbid);
            productDao.resumeOrDeleteFileUploadLog(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("�ָ���ɾ����ƷͼƬʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

}
