package com.erp.test.proxy;

/**
 * MyMain
 *
 * @author wang_
 * @date 2016-12-5
 */
public class MyMain {
    public static void main(String[] args) {
        MySqlSession sqlSession = new MySqlSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        System.out.println(userDao.query(123));

    }
}
