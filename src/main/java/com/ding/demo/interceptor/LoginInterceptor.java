package com.ding.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static ThreadLocal s = new ThreadLocal();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("=== pre ====");
        System.out.println("i :" + Thread.currentThread());
        s.set("123");
        System.out.println(s.get());
        System.out.println("----------------------\n");
        return true;
    }
}
