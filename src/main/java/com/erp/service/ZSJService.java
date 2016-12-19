package com.erp.service;

import com.erp.mybatis.mapper.IZSJDataDao;
import com.erp.entity.Gys;
import com.erp.entity.WL;
import com.erp.exception.ServiceException;
import com.erp.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wang_ on 2016-06-29.
 */
@Service
public class ZSJService {
    private static Logger logger = Logger.getLogger(ZSJService.class);

    @Autowired
    private IZSJDataDao zsjDataDao;

    /**
     * 获得物料下拉框数据
     *
     * @return
     */
    public JSONArray initWlComboData() throws ServiceException{
        JSONArray wl_array = new JSONArray();
        try {
            List<WL> wlList = zsjDataDao.queryWlList();
            if (wlList.size() > 0) {
                JsonConfig config = new JsonConfig();
                config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

                for (WL wl : wlList) {
                    JSONObject wl_object = JSONObject.fromObject(wl, config);
                    wl_array.add(wl_object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取物料下拉框数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }

        return wl_array;
    }

    /**
     * 获得供应商下拉框数据
     *
     * @return
     */
    public JSONArray initGysComboData() throws ServiceException{
        JSONArray gys_array = new JSONArray();
        try {
            List<Gys> gysList = zsjDataDao.queryGysList();
            if (gysList.size() > 0) {
                JsonConfig config = new JsonConfig();
                config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

//              JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] { "yyyy-MM-dd" }));
                for (Gys gys : gysList) {
                    JSONObject gys_object = JSONObject.fromObject(gys, config);
                    gys_array.add(gys_object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取供应商下拉框数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }

        return gys_array;
    }

    /**
     * 插入、更新物料数据
     *
     * @param wl
     * @throws ServiceException
     */
    public void insertOrUpdateWl(WL wl) throws ServiceException {
        try {
            if (wl.getWlId() == null) {
                zsjDataDao.insertWl(wl);
            } else {
                zsjDataDao.updateWl(wl);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入或更新物料数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 删除物料数据
     *
     * @param ids
     * @param update_staffId
     * @throws ServiceException
     */
    public void deleteWl(String[] ids, String update_staffId) throws ServiceException {
        try {
            Map paramMap = new HashMap();
            paramMap.put("update_staffId", update_staffId);
            paramMap.put("wlIdList", Arrays.asList(ids));
            zsjDataDao.deleteWl(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除物料数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 增加、更新供应商主数据
     *
     * @param gys
     * @throws ServiceException
     */
    public void insertOrUpdateGys(Gys gys) throws ServiceException {
        try {
            if (gys.getGysId() == null) {
                zsjDataDao.insertGys(gys);
            } else {
                zsjDataDao.updateGys(gys);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入或更新供应商数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 删除供应商数据
     *
     * @param ids
     * @param update_staffId
     * @throws ServiceException
     */
    public void deleteGys(String[] ids, String update_staffId) throws ServiceException {
        try {
            Map paramMap = new HashMap();
            paramMap.put("update_staffId", update_staffId);
            paramMap.put("gysIdList", Arrays.asList(ids));
            zsjDataDao.deleteGys(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除供应商数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

}
