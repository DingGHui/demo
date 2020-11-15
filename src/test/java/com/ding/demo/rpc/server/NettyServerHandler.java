package com.ding.demo.rpc.server;

import com.ding.demo.rpc.provider.impl.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("====服务器接收的 msg : " + msg + "====");
        if (msg.toString().startsWith("helloService")) {
            String result = new HelloServiceImpl().hello(msg.toString());
            ctx.writeAndFlush(result);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("==== 异常 ==== " + cause.getMessage());
        ctx.close();
    }
}
