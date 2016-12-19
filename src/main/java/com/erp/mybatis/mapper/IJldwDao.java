package com.erp.mybatis.mapper;

import com.erp.entity.Jldw;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by wang_ on 2016-09-01.
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public interface IJldwDao {

    /**
     * ��ѯ
     * @return
     * @throws Exception
     */
    public List<Jldw> queryJldw();

    /**
     * ��ѯ
     * @param jldw
     * @return
     * @throws Exception
     */
    public Jldw queryJldwByJldwId(Jldw jldw);

    /**
     * ���롢��������
     * @param jldw
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void insertJldw(Jldw jldw);

    /**
     * ���롢��������
     * @param jldw
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateJldw(Jldw jldw);

    /**
     * ɾ��
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void deleteJldw(Map<String, Object> paramMap);

}
