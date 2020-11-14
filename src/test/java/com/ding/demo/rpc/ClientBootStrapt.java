package com.ding.demo.rpc;

import com.ding.demo.rpc.client.ClientHandler;
import com.ding.demo.rpc.client.NettyClient;

public class ClientBootStrapt {

    public static void main(String[] args) {
        NettyClient nettyClient = new NettyClient();
        HelloService helloService = (HelloService) nettyClient.getBean(HelloService.class, "helloService#hello");
        helloService.hello("aaa;");
    }
}
