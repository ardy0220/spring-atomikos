package com.erp.test.proxy;

import java.lang.reflect.Proxy;

/**
 * MySqlSession
 *
 * @author wang_
 * @date 2016-12-5
 */
public class MySqlSession {

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> type) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new MapperProxy());
    }
}
