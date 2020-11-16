package com.ding.demo.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ding
 * @date 2020/11/16
 */
public class TestJdkProxy {

	public static void main(String[] args) {
		Person o = (Person) Proxy.newProxyInstance(
				Thread.currentThread().getContextClassLoader(),
				new Class[] { Person.class }, new InvocationHandler() {
					@Override public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println("=======");
						Object invoke = method.invoke(new Male(), args);
						return null;
					}
				});
		o.sayHello();
	}
}
