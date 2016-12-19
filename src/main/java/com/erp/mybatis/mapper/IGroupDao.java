package com.erp.mybatis.mapper;

import com.erp.entity.Group;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by wang_ on 2016-09-20.
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public interface IGroupDao {

    /**
     * ��ѯ
     * @return
     * @throws Exception
     */
    public List<Group> queryGroups();

    /**
     *
     * @param group
     * @return
     * @throws Exception
     */
    public Group queryGroupByGroupId(Group group);

    /**
     * ����
     * @param group
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void insertGroup(Group group);

    /**
     * �޸�
     * @param group
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateGroup(Group group);

    /**
     * ɾ��
     * @param paramMap
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void deleteGroup(Map<String, Object> paramMap);

}
