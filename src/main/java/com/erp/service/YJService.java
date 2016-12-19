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
     * ��ѯ�����½�����
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
            logger.error("��ѯ�½�����ʧ�ܣ�" + e.getMessage(), e);
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
            logger.error("��ѯ�¶Ƚ�������ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return yj;
    }

    /**
     * �����½�����
     *
     * @param yj
     * @throws ServiceException
     */
    public void insertYJData(YJ yj) throws ServiceException {
        try {

            /**
             * ���ݵ�ǰ�½��·ݣ�����С�ڵ�ǰ�½��·ݵ����ݣ��ҵ��½��·�����һ������ΪA��
             * ��ȡA��yjye(�½����), ���ϵ�ǰ���ݵ�yjye��Ϊ����ĸ������ݵ�yjye��
             *
             */
            double last_yjye = yjDao.queryLastDataBeforeCurrent(yj.getYjyf(), null);
            double current_yjye = yj.getYjye();
            yj.setYjye(last_yjye + current_yjye);

            /**
             * ���ݵ�ǰ�½��·ݣ����ҵ��ڵ�ǰ�½��·ݵ�����ΪB�����û���ҵ��򷵻�0D,
             * ���򷵻�B��yjye(�½����)�����ݵ�ǰ���½����-B���½���Ϊ�½�������
             */
            YJ yj_before = yjDao.queryYJDataByDbid(yj.getYjyf(), null);
            double yjye_cy = yj_before == null ? current_yjye : current_yjye - yj_before.getYjye();

            yjDao.insertYJData(yj, yjye_cy);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("������ʼ���½�����ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * �����½�����
     *
     * @param yj
     * @throws ServiceException
     */
    public void updateYJData(YJ yj) throws ServiceException {
        try {

            /**
             * ���ݵ�ǰ�½��·ݣ�����С�ڵ�ǰ�½��·ݵ����ݣ��ҵ��½��·�����һ������ΪA��
             * ��ȡA��yjye(�½����), ���ϵ�ǰ���ݵ�yjye��Ϊ����ĸ������ݵ�yjye��
             *
             */
            double last_yjye = yjDao.queryLastDataBeforeCurrent(yj.getYjyf(), null);

            /**
             * �����½�����
             */
            yj.setYjye(last_yjye + yj.getYjye());

            /**
             * ���ݵ�ǰ�½��·ݣ����ҵ��ڵ�ǰ�½��·ݵ�����ΪB�����û���ҵ��򷵻�0D,
             * ���򷵻�B��yjye(�½����)�����ݵ�ǰ���½����-B���½���Ϊ�½�������
             */
            YJ yj_before = yjDao.queryYJDataByDbid(yj.getYjyf(), null);
            double yjye_cy = yj_before == null ? yj.getYjye() : (yj.getYjye() - yj_before.getYjye());

            yjDao.updateYJData(yj, yjye_cy);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("�����½�����ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * �����½�����
     * @param dbid
     * @param yj
     * @throws ServiceException
     */
    public void deleteOrInsert(String dbid, YJ yj) throws ServiceException {
        try {

            /**
             * ���ݵ�ǰ�½��·ݣ����ҵ��ڵ�ǰ�½��·ݵ�����ΪB�����û���ҵ��򷵻�0D,
             * ���򷵻�B��yjye(�½����)�����ݵ�ǰ���½����-B���½���Ϊ�½�������
             */
            YJ del_yj_before = yjDao.queryYJDataByDbid(null, dbid);
            double del_yjye_cy = del_yj_before == null ? 0d : del_yj_before.getYjzc() - del_yj_before.getYjhz();

            /**
             * ���ݵ�ǰ�½��·ݣ�����С�ڵ�ǰ�½��·ݵ����ݣ��ҵ��½��·�����һ������ΪA��
             * ��ȡA��yjye(�½����), ���ϵ�ǰ���ݵ�yjye��Ϊ����ĸ������ݵ�yjye��
             */
            double last_yjye = yjDao.queryLastDataBeforeCurrent(yj.getYjyf(), del_yj_before.getYjyf());
            double current_yjye = yj.getYjye();
            yj.setYjye(last_yjye + current_yjye);

            /**
             * ���ݵ�ǰ�½��·ݣ����ҵ��ڵ�ǰ�½��·ݵ�����ΪB�����û���ҵ��򷵻�0D,
             * ���򷵻�B��yjye(�½����)�����ݵ�ǰ���½����-B���½���Ϊ�½�������
             */
            YJ yj_before = yjDao.queryYJDataByDbid(yj.getYjyf(), null);
            double yjye_cy = yj_before == null ? current_yjye : current_yjye - yj_before.getYjye();

            yjDao.deleteOrInsert(del_yj_before, del_yjye_cy, yj, yjye_cy);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("�����½�����ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * ����dbid����ɾ���½�����
     *
     * @param dbid
     * @throws ServiceException
     */
    public void deleteYJData(String dbid) throws ServiceException {
        try {
            /**
             * ���ݵ�ǰ�½��·ݣ����ҵ��ڵ�ǰ�½��·ݵ�����ΪB�����û���ҵ��򷵻�0D,
             * ���򷵻�B��yjye(�½����)�����ݵ�ǰ���½����-B���½���Ϊ�½�������
             */
            YJ yj_before = yjDao.queryYJDataByDbid(null, dbid);
            double yjye_cy = yj_before == null ? 0d : yj_before.getYjzc() - yj_before.getYjhz();

            yjDao.deleteYJData(yj_before, yjye_cy);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ɾ���½�����ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

}
