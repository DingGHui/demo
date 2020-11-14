package com.ding.demo.rpc;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "你好," + name;
    }
}
