package com.erp.service;

import com.erp.dao.IYJDao;
import com.erp.entity.YJ;
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
 * Created by wang_ on 2016-08-04.
 */
@Service
public class YJService {
    private static Logger logger = Logger.getLogger(YJService.class);

    @Autowired
    private IYJDao yjDao;

    /**
     * 查询所有月结数据
     *
     * @return
     * @throws ServiceException
     */
    public JSONArray queryYJData() throws ServiceException {
        JSONArray yjArray = new JSONArray();
        try {
            List<YJ> yjList = yjDao.queryYJData(null);
            if (yjList != null && yjList.size() > 0) {
                JsonConfig config = new JsonConfig();
                config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss"));

                for (YJ yj : yjList) {
                    JSONObject object = JSONObject.fromObject(yj, config);
                    yjArray.add(object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询月结数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return yjArray;
    }

    /**
     * @param yjyf
     * @param dbid
     * @return
     * @throws ServiceException
     */
    public YJ queryYJDataByDbid(String yjyf, String dbid) throws ServiceException {
        YJ yj = null;
        try {
            yj = yjDao.queryYJDataByDbid(yjyf, dbid);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询月度结算数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return yj;
    }

    /**
     * 插入月结数据
     *
     * @param yj
     * @throws ServiceException
     */
    public void insertYJData(YJ yj) throws ServiceException {
        try {

            /**
             * 根据当前月结月份，查找小于当前月结月份的数据，找到月结月份最大的一条数据为A，
             * 获取A的yjye(月结余额), 加上当前数据的yjye即为插入的该条数据的yjye。
             *
             */
            double last_yjye = yjDao.queryLastDataBeforeCurrent(yj.getYjyf(), null);
            double current_yjye = yj.getYjye();
            yj.setYjye(last_yjye + current_yjye);

            /**
             * 根据当前月结月份，查找等于当前月结月份的数据为B，如果没有找到则返回0D,
             * 否则返回B的yjye(月结余额)，根据当前的月结余额-B的月结余额即为月结余额差异
             */
            YJ yj_before = yjDao.queryYJDataByDbid(yj.getYjyf(), null);
            double yjye_cy = yj_before == null ? current_yjye : current_yjye - yj_before.getYjye();

            yjDao.insertYJData(yj, yjye_cy);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入或初始化月结数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 更新月结数据
     *
     * @param yj
     * @throws ServiceException
     */
    public void updateYJData(YJ yj) throws ServiceException {
        try {

            /**
             * 根据当前月结月份，查找小于当前月结月份的数据，找到月结月份最大的一条数据为A，
             * 获取A的yjye(月结余额), 加上当前数据的yjye即为插入的该条数据的yjye。
             *
             */
            double last_yjye = yjDao.queryLastDataBeforeCurrent(yj.getYjyf(), null);

            /**
             * 更新月结数据
             */
            yj.setYjye(last_yjye + yj.getYjye());

            /**
             * 根据当前月结月份，查找等于当前月结月份的数据为B，如果没有找到则返回0D,
             * 否则返回B的yjye(月结余额)，根据当前的月结余额-B的月结余额即为月结余额差异
             */
            YJ yj_before = yjDao.queryYJDataByDbid(yj.getYjyf(), null);
            double yjye_cy = yj_before == null ? yj.getYjye() : (yj.getYjye() - yj_before.getYjye());

            yjDao.updateYJData(yj, yjye_cy);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新月结数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 更新月结数据
     * @param dbid
     * @param yj
     * @throws ServiceException
     */
    public void deleteOrInsert(String dbid, YJ yj) throws ServiceException {
        try {

            /**
             * 根据当前月结月份，查找等于当前月结月份的数据为B，如果没有找到则返回0D,
             * 否则返回B的yjye(月结余额)，根据当前的月结余额-B的月结余额即为月结余额差异
             */
            YJ del_yj_before = yjDao.queryYJDataByDbid(null, dbid);
            double del_yjye_cy = del_yj_before == null ? 0d : del_yj_before.getYjzc() - del_yj_before.getYjhz();

            /**
             * 根据当前月结月份，查找小于当前月结月份的数据，找到月结月份最大的一条数据为A，
             * 获取A的yjye(月结余额), 加上当前数据的yjye即为插入的该条数据的yjye。
             */
            double last_yjye = yjDao.queryLastDataBeforeCurrent(yj.getYjyf(), del_yj_before.getYjyf());
            double current_yjye = yj.getYjye();
            yj.setYjye(last_yjye + current_yjye);

            /**
             * 根据当前月结月份，查找等于当前月结月份的数据为B，如果没有找到则返回0D,
             * 否则返回B的yjye(月结余额)，根据当前的月结余额-B的月结余额即为月结余额差异
             */
            YJ yj_before = yjDao.queryYJDataByDbid(yj.getYjyf(), null);
            double yjye_cy = yj_before == null ? current_yjye : current_yjye - yj_before.getYjye();

            yjDao.deleteOrInsert(del_yj_before, del_yjye_cy, yj, yjye_cy);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新月结数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * 根据dbid主键删除月结数据
     *
     * @param dbid
     * @throws ServiceException
     */
    public void deleteYJData(String dbid) throws ServiceException {
        try {
            /**
             * 根据当前月结月份，查找等于当前月结月份的数据为B，如果没有找到则返回0D,
             * 否则返回B的yjye(月结余额)，根据当前的月结余额-B的月结余额即为月结余额差异
             */
            YJ yj_before = yjDao.queryYJDataByDbid(null, dbid);
            double yjye_cy = yj_before == null ? 0d : yj_before.getYjzc() - yj_before.getYjhz();

            yjDao.deleteYJData(yj_before, yjye_cy);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除月结数据失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

}
