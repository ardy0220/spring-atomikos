package com.erp.mybatis.mapper;

import com.erp.entity.StaffInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * �û���½�ӿ�
 * Created by wang_ on 2016-06-28.
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public interface IUserDao {

    /**
     * ���Staff
     * @param staffInfo
     * @return
     * @throws Exception
     */
    public StaffInfo queryStaffByCode (StaffInfo staffInfo);

    /**
     * ����STAFF
     * @param staffCode
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateStaffByCode (String staffCode);

    /**
     * ��ѯ�û���Ϣ�����dbidΪ�գ����ѯȫ���û�
     * @param dbid
     * @return
     * @throws Exception
     */
    public List<StaffInfo> queryUserData(String dbid);

    /**
     * �����û�
     * @param staffInfo
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void insertUserData(StaffInfo staffInfo);

    /**
     * �����û�
     * @param staffInfo
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateUserData(StaffInfo staffInfo);

    /**
     * ɾ���û�
     * @param ids
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void deleteUserData(String[] ids);

}
