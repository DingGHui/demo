package com.ding.demo.rpc.provider.impl;

import com.ding.demo.rpc.provider.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        System.out.println("收到参数name:" + name);
        return "你好," + name;
    }
}
