package com.ding.demo.rpc;

import com.ding.demo.rpc.client.NettyClient;
import com.ding.demo.rpc.provider.HelloService;

public class ClientBootStrap {

    public static void main(String[] args) {
        NettyClient nettyClient = new NettyClient();
        HelloService helloService = (HelloService) nettyClient.getBean(HelloService.class, "helloService#hello");
        String hello = helloService.hello("aaa;");
        System.out.println("===== 结果是: " + hello + "=============");
    }
}
