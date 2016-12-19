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
     * 查询商品列表
     * @return
     * @throws Exception
     */
    public List<Product> queryProduct();

    /**
     * 插入商品
     * @param product
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void insertProduct(Product product);

    /**
     * 更新商品
     * @param product
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateProduct(Product product);

    /**
     * 上架或下架
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateProductValid(Map<String, Object> paramMap);

    /**
     * 删除商品
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void deleteProduct(Map<String, Object> paramMap);

    /**
     * 查询该商品下上传的图片
     * @param paramMap
     * @return
     */
    public List<FileUploadLog> queryFileUploadLog(Map<String, Object> paramMap);

    /**
     * 增加
     * @param fileUploadLog
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public long insertFileUploadLog(FileUploadLog fileUploadLog);

    /**
     * 更新deleteUrl字段
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateFileUploadLog(Map<String, Object> paramMap);

    /**
     * 恢复、删除该条数据
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void resumeOrDeleteFileUploadLog(Map<String, Object> paramMap);

}
