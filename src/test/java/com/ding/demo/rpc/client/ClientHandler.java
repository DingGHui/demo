package com.ding.demo.rpc.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.Callable;

public class ClientHandler extends SimpleChannelInboundHandler<String> implements Callable<String> {

    private String param;
    private ChannelHandlerContext ctx;
    private String result;

    public void setParam(String param){
        this.param = param;
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        result = msg;
        notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("[error] : " + cause.getMessage());
    }

    @Override
    public String call() throws Exception {
        this.ctx.writeAndFlush(param);
        wait();
        return result;
    }
}
