package com.ding.demo.rpc.client;

import com.ding.demo.constant.DemoConstant;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NettyClient {

    private static ClientHandler clientHandler;
    private static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public Object getBean(final Class serviceClass, final String providerName) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{serviceClass}, ((proxy, method, args) -> {
                    System.out.println("===== proxy ====");
                    if (clientHandler == null) {
                        initClient();
                    }
                    clientHandler.setParam(providerName + args[0]);
                    return executorService.submit(clientHandler);
                }));
    }

    private void initClient() {
        NioEventLoopGroup gr = new NioEventLoopGroup();
        clientHandler = new ClientHandler();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(gr)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(clientHandler);
                        }
                    });
            ChannelFuture sync = bootstrap.connect(DemoConstant.hostName, DemoConstant.port).sync();
            sync.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            gr.shutdownGracefully();
        }


    }
}
