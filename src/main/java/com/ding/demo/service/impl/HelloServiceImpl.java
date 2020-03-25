package com.ding.demo.service.impl;

import com.ding.demo.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    private  ThreadLocal<String> threadLocal = new ThreadLocal<String>();
    @Override
    public String sayHello() {
        System.out.println("service : "+threadLocal.get());
        return threadLocal.get();
    }
}
