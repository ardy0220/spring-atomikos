package com.erp.service;

import com.erp.mybatis.mapper.IJldwDao;
import com.erp.entity.Jldw;
import com.erp.exception.ServiceException;
import com.erp.util.JsonDateValueProcessor;
import com.erp.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wang_ on 2016-09-02.
 */
@Service
public class JldwService {
    private static final Logger logger = Logger.getLogger(JldwService.class);

    @Autowired
    private IJldwDao jldwDao;

    /**
     * 查询
     *
     * @return
     * @throws ServiceException
     */
    public JSONArray queryJldw() throws ServiceException {
        JSONArray array = new JSONArray();
        try {
            List<Jldw> jldwList = jldwDao.queryJldw();
            if (jldwList != null && jldwList.size() > 0) {
                JsonConfig config = new JsonConfig();
                config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

                for (Jldw jldw : jldwList) {
                    JSONObject object = JSONObject.fromObject(jldw, config);
                    array.add(object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询计量单位数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return array;
    }

    /**
     * 插入、更新数据
     *
     * @param jldwmc
     * @param jldwId
     * @throws ServiceException
     */
    public Jldw queryJldwByJldwId(String jldwmc, String jldwId) throws ServiceException {
        Jldw jldw = null;
        try {
            Jldw jldwParam = new Jldw();
            jldwParam.setJldwId(StringUtil.isEmpty(jldwId)?null:Integer.valueOf(jldwId));
            jldwParam.setJldwmc(jldwmc);
            jldw = jldwDao.queryJldwByJldwId(jldwParam);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询计量单位数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return jldw;
    }

    /**
     * 插入、更新数据
     *
     * @param jldw
     * @throws ServiceException
     */
    public void insertOrUpdateJldw(Jldw jldw) throws ServiceException {
        try {
            if (jldw.getJldwId() == null) {
                jldwDao.insertJldw(jldw);
            } else {
                jldwDao.updateJldw(jldw);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入或更新计量单位数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 删除数据
     *
     * @param ids
     * @param update_staffId
     * @throws ServiceException
     */
    public void deleteJldw(String[] ids, String update_staffId) throws ServiceException {
        try {
            Map paramMap = new HashMap();
            paramMap.put("update_staffId", update_staffId);
            paramMap.put("jldwIdList", Arrays.asList(ids));
            jldwDao.deleteJldw(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除计量单位数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }
}
