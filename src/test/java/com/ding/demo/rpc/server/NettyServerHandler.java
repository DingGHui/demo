package com.ding.demo.rpc.server;

import com.ding.demo.rpc.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.junit.platform.commons.util.StringUtils;

public class NettyServerHandler extends SimpleChannelInboundHandler<String> {




    @Override
    protected synchronized void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        if (StringUtils.isNotBlank(msg) && msg.startsWith("helloService")) {
            String result = new HelloServiceImpl().hello(msg);
            ctx.writeAndFlush(result);
        }
    }

}
