package com.ding.demo.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ding
 * @date 2020/11/16
 */
public class PP extends Proxy {
	/**
	 * Constructs a new {@code Proxy} instance from a subclass
	 * (typically, a dynamic proxy class) with the specified value
	 * for its invocation handler.
	 *
	 * @param h the invocation handler for this proxy instance
	 * @throws NullPointerException if the given invocation handler, {@code h},
	 *                              is {@code null}.
	 */
	protected PP(InvocationHandler h) {
		super(h);
	}
}
