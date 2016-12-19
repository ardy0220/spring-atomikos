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
     * 查询所有模块
     * @param flag true:查询时包含已删除的数据
     * @return
     * @throws Exception
     */
    public List<Module> queryModules(boolean flag);

    /**
     * 插入模块
     * @param module
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void insertModule(Module module);

    /**
     * 更新模块
     * @param module
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateModule(Module module);

    /**
     * 更新模块
     * @param id
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void resumeModule(String id);

    /**
     * 删除节点
     * @param ids
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void deleteModule(List<String> ids);
}
