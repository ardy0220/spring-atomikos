package com.erp.service;

import com.erp.mybatis.mapper.IProductDao;
import com.erp.entity.Product;
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
 * Created by wang_ on 2016-08-26.
 */
@Service
public class ProductService {
    private static Logger logger = Logger.getLogger(ProductService.class);

    @Autowired
    private IProductDao productDao;

    /**
     * ��ѯ��Ʒ�б�
     *
     * @return
     * @throws ServiceException
     */
    public JSONArray queryProduct() throws ServiceException {
        JSONArray array = new JSONArray();
        try {
            List<Product> productList = productDao.queryProduct();
            if (productList != null && productList.size() > 0) {
                JsonConfig config = new JsonConfig();
                config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

                for (Product product : productList) {
                    JSONObject object = JSONObject.fromObject(product, config);
                    array.add(object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("��ȡ��Ʒ�б�ʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return array;
    }

    /**
     * ����������Ʒ
     *
     * @param product
     * @throws ServiceException
     */
    public void insertOrUpdateProduct(Product product) throws ServiceException {
        try {
            if (product.getProductId()==null) {
                productDao.insertProduct(product);
            } else {
                productDao.updateProduct(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("����������Ʒʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * �ϼܻ��¼�
     *
     * @param ids
     * @param staffId
     * @param flag    �¼ܱ�ʶ: trueִ���¼ܲ���
     * @throws ServiceException
     */
    public void updateProductValid(String[] ids, String staffId, boolean flag) throws ServiceException {
        try {
            Map paramMap = new HashMap();
            paramMap.put("is_valid", flag ? "0" : "1");
            paramMap.put("update_staffId", staffId);
            paramMap.put("productIdList", Arrays.asList(ids));
            productDao.updateProductValid(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("�ϼܻ��¼���Ʒʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    /**
     * ɾ����Ʒ
     *
     * @param ids
     * @param staffId
     * @throws ServiceException
     */
    public void deleteProduct(String[] ids, String staffId) throws ServiceException {
        try {
            Map paramMap = new HashMap();
            paramMap.put("update_staffId", staffId);
            paramMap.put("productIdList", Arrays.asList(ids));
            productDao.deleteProduct(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ɾ����Ʒʧ�ܣ�" + e.getMessage(), e);
            throw new ServiceException(e);
        }
    }
}
