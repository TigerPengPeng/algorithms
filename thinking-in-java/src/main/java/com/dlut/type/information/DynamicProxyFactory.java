package com.dlut.type.information;

import java.lang.reflect.Proxy;

/**
 * @package: com.dlut.type.information
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月06日 下午1:35
 * @description:
 */
public class DynamicProxyFactory {

    public static Object getProxyInstance(Object object) {
        Object proxyInstance = Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new DynamicProxyHandler(object)
        );
        return proxyInstance;
    }
}
