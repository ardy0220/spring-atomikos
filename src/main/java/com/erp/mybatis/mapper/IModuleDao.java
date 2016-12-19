package com.erp.mybatis.mapper;

import com.erp.entity.Module;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wang_ on 2016-07-02.
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public interface IModuleDao {

    /**
     * ��ѯ����ģ��
     * @param flag true:��ѯʱ������ɾ��������
     * @return
     * @throws Exception
     */
    public List<Module> queryModules(boolean flag);

    /**
     * ����ģ��
     * @param module
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void insertModule(Module module);

    /**
     * ����ģ��
     * @param module
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateModule(Module module);

    /**
     * ����ģ��
     * @param id
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void resumeModule(String id);

    /**
     * ɾ���ڵ�
     * @param ids
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void deleteModule(List<String> ids);
}
