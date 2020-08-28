package com.ding.demo;

import org.mockito.internal.matchers.And;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ding
 * @date 2020/8/28
 */
public class Test {

    public static void main(String[] args) {
//        Andr andr = new Andr();
//        InvocationHandler andrProxy = new AndrProxy(andr);
//        Phone o = (Phone)Proxy.newProxyInstance(andr.getClass().getClassLoader()
//                , andr.getClass().getInterfaces(), andrProxy);
//        o.call();
//
//        System.out.println("=================================");
//        o.Ring();
        Car andr = new Car();
        InvocationHandler andrProxy = new AndrProxy(andr);
        Car o =(Car) Proxy.newProxyInstance(andr.getClass().getClassLoader()
                , andr.getClass().getInterfaces(), andrProxy);
        o.ring();
    }
}
