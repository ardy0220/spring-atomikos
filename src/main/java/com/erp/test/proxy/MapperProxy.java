package com.erp.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * MapperProxy
 *
 * @author wang_
 * @date 2016-12-5
 */
public class MapperProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(args[0]);
        List<Object> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        return list;
    }
}
