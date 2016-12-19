package com.erp.webservice.dao;

import com.erp.webservice.pojo.User;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by wang_ on 2016-11-16.
 */
@WebService
public interface IUserService {

    User getUserById(long id);

    List<User> getAllUsers();
}
