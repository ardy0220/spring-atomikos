package com.erp.mybatis.mapper;

import com.erp.entity.Gys;
import com.erp.entity.WL;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by wang_ on 2016-06-29.
 */
@Repository
@Transactional(readOnly = true,
        propagation = Propagation.SUPPORTS)
public interface IZSJDataDao {

    /**
     * 获取物料下拉框数据
     * @return
     * @throws Exception
     */
    public List<WL> queryWlList();

    /**
     * 增加物料主数据
     * @param wl
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void insertWl(WL wl);

    /**
     * 更新物料主数据
     * @param wl
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateWl(WL wl);

    /**
     * 删除物料数据
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void deleteWl(Map<String, Object> paramMap);

    /**
     * 获取供应商下拉框数据
     * @return
     * @throws Exception
     */
    public List<Gys> queryGysList();

    /**
     * 增加供应商主数据
     * @param gys
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void insertGys(Gys gys);

    /**
     * 修改供应商主数据
     * @param gys
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateGys(Gys gys);

    /**
     * 删除供应商数据
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void deleteGys(Map<String, Object> paramMap);

}
