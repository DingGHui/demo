package com.ding.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ding
 * @date 2020/8/28
 */
public class AndrProxy implements InvocationHandler {
    /**
     * 这个就是我们要代理的真实对象
     */
    private Object subject;

    /**
     * 构造方法，给我们要代理的真实对象赋初值
     *
     * @param subject
     */
    public AndrProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(" ==== 前置 ===");
        System.out.println("method:" + method);
        Object invoke = method.invoke(subject, args);
        System.out.println("=== 后置 ===");
        return invoke;
    }
}
