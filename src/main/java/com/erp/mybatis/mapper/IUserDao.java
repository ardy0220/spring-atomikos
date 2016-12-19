package com.erp.mybatis.mapper;

import com.erp.entity.StaffInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户登陆接口
 * Created by wang_ on 2016-06-28.
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public interface IUserDao {

    /**
     * 获得Staff
     * @param staffInfo
     * @return
     * @throws Exception
     */
    public StaffInfo queryStaffByCode (StaffInfo staffInfo);

    /**
     * 更新STAFF
     * @param staffCode
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateStaffByCode (String staffCode);

    /**
     * 查询用户信息，如果dbid为空，则查询全部用户
     * @param dbid
     * @return
     * @throws Exception
     */
    public List<StaffInfo> queryUserData(String dbid);

    /**
     * 增加用户
     * @param staffInfo
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void insertUserData(StaffInfo staffInfo);

    /**
     * 更新用户
     * @param staffInfo
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateUserData(StaffInfo staffInfo);

    /**
     * 删除用户
     * @param ids
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void deleteUserData(String[] ids);

}
