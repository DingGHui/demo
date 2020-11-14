package com.ding.demo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

public class NettyClient {

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    System.out.println("连接成功, ctx = "+ctx);
                                    ctx.writeAndFlush(Unpooled.copiedBuffer("我是客户端, 我来连接了", CharsetUtil.UTF_8));
                                }

                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    ByteBuf buf = (ByteBuf) msg;
                                    System.out.println("channelRead ,message = " + buf.toString(CharsetUtil.UTF_8));
                                }
                            });
                        }
                    });

            ChannelFuture sync = bootstrap.connect("127.0.0.1",6666).sync();
            sync.channel().close().sync();
        } catch (InterruptedException e) {
            System.out.println("[error]" + e.getMessage());
            e.printStackTrace();
            group.shutdownGracefully();
        }


    }
}
