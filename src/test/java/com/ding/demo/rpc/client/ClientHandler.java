package com.ding.demo.rpc.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class ClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private String param;
    private ChannelHandlerContext context;
    private String result;

    public void setParam(String param){
        System.out.println("========== 设置参数 ======" + param);
        this.param = param;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
    }

    @Override
    public  synchronized  void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("===== 收到服务器结果 ======" + msg.toString());
        result = msg.toString();
        notify();
    }

    @Override
    public   void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("[异常] : " + cause.getMessage());
        ctx.close();
    }

    @Override
    public synchronized Object call() throws Exception {

        try {
            System.out.println("===== 开始调用远程,param: =====" + param);
            context.writeAndFlush(param);
            wait();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            System.out.println("一场发生了");
        }
    }
}
