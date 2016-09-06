package com.dlut.type.information;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @package: com.dlut.type.information
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月06日 下午12:04
 * @description:
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object _proxy) {
        proxied = _proxy;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy begin");
        Object result = method.invoke(proxied, args);
        System.out.println("proxy end");
        return result;
    }
}
