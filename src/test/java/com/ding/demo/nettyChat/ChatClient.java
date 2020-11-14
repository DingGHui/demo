package com.ding.demo.nettyChat;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

public class ChatClient {

    private int port;
    private String host;

    public ChatClient(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public static void main(String[] args) {
        new ChatClient(6666, "127.0.0.1").run();
    }

    private void run() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap serverBootstrap = new Bootstrap();
            serverBootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new SimpleChannelInboundHandler<String>() {
                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
                                    System.out.println(msg);
                                }
                            });
                        }
                    });
            ChannelFuture sync = serverBootstrap.connect(this.host, this.port).sync();
//            sync.channel().close().sync();
            Channel channel = sync.channel();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                channel.writeAndFlush(scanner.nextLine());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            group.shutdownGracefully();
        }finally {
            group.shutdownGracefully();
        }

    }
}
