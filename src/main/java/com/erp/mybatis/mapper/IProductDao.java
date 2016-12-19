package com.erp.mybatis.mapper;

import com.erp.entity.FileUploadLog;
import com.erp.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by wang_ on 2016-08-26.
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public interface IProductDao {

    /**
     * ��ѯ��Ʒ�б�
     * @return
     * @throws Exception
     */
    public List<Product> queryProduct();

    /**
     * ������Ʒ
     * @param product
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void insertProduct(Product product);

    /**
     * ������Ʒ
     * @param product
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateProduct(Product product);

    /**
     * �ϼܻ��¼�
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateProductValid(Map<String, Object> paramMap);

    /**
     * ɾ����Ʒ
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void deleteProduct(Map<String, Object> paramMap);

    /**
     * ��ѯ����Ʒ���ϴ���ͼƬ
     * @param paramMap
     * @return
     */
    public List<FileUploadLog> queryFileUploadLog(Map<String, Object> paramMap);

    /**
     * ����
     * @param fileUploadLog
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public long insertFileUploadLog(FileUploadLog fileUploadLog);

    /**
     * ����deleteUrl�ֶ�
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateFileUploadLog(Map<String, Object> paramMap);

    /**
     * �ָ���ɾ����������
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void resumeOrDeleteFileUploadLog(Map<String, Object> paramMap);

}
