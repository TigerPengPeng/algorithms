package com.dlut.type.information.test;

import com.dlut.type.information.DynamicProxyFactory;
import com.dlut.type.information.Implements;
import com.dlut.type.information.Interface;

/**
 * @package: com.dlut.type.information
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月06日 下午12:08
 * @description:
 */
public class DynamicProxyHandlerTest {

    private Interface object = new Implements();

    public void noProxy() throws Throwable {
        object.operate("no  proxy");
    }

    public void withProxy() throws Throwable {
        Interface proxy = (Interface) DynamicProxyFactory.getProxyInstance(object);
        proxy.operate("with proxy");
    }

    public static void main(String[] args) throws Throwable {
        DynamicProxyHandlerTest proxyHandler = new DynamicProxyHandlerTest();
        proxyHandler.noProxy();
        proxyHandler.withProxy();
    }

}