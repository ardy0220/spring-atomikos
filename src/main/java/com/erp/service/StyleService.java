package com.erp.service;

import com.erp.mybatis.mapper.IStyleDao;
import com.erp.entity.Style;
import com.erp.exception.ServiceException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang_ on 2016-08-18.
 */
@Service
public class StyleService {
    private static Logger logger = Logger.getLogger(StyleService.class);

    @Autowired
    private IStyleDao styleDao;

    /**
     * ��ȡ��ʽ�б�
     *
     * @return
     * @throws ServiceException
     */
    public JSONArray queryStyleData() throws ServiceException {
        JSONArray style_array = new JSONArray();
        try {
            List<Style> styleList = styleDao.queryStyleList();
            if (styleList.size() > 0) {
                for (Style style : styleList) {
                    JSONObject styleObj = JSONObject.fromObject(style);
                    style_array.add(styleObj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("��ȡ��ʽ�б�ʧ��:" + e.getMessage(), e);
            throw new ServiceException(e);
        }

        return style_array;
    }

    /**
     * ������ʽ
     *
     * @param style
     * @throws ServiceException
     */
    public void updateStyle(Style style) throws ServiceException {
        try {
            styleDao.updateStyle(style);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("������ʽʧ��:" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }
}
