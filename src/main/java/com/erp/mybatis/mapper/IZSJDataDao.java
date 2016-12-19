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
     * ��ȡ��������������
     * @return
     * @throws Exception
     */
    public List<WL> queryWlList();

    /**
     * ��������������
     * @param wl
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void insertWl(WL wl);

    /**
     * ��������������
     * @param wl
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateWl(WL wl);

    /**
     * ɾ����������
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void deleteWl(Map<String, Object> paramMap);

    /**
     * ��ȡ��Ӧ������������
     * @return
     * @throws Exception
     */
    public List<Gys> queryGysList();

    /**
     * ���ӹ�Ӧ��������
     * @param gys
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void insertGys(Gys gys);

    /**
     * �޸Ĺ�Ӧ��������
     * @param gys
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateGys(Gys gys);

    /**
     * ɾ����Ӧ������
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void deleteGys(Map<String, Object> paramMap);

}
