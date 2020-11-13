package com.ding.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ding
 * @date 2020/11/12
 */
public class NioServer {
	public static void main(String[] args) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		Selector selector = Selector.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(6666));
		serverSocketChannel.configureBlocking(false);

		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		while (true) {
			if (selector.select(1000) == 0) {
				System.out.println("服务器等待1s,无连接");
				continue;
			}

			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				if (selectionKey.isAcceptable()) {
					System.out.println("开始处理连接请求");
					SocketChannel socketChannel = serverSocketChannel.accept();
					socketChannel.configureBlocking(false);
					socketChannel.register(selector,SelectionKey.OP_READ,
							ByteBuffer.allocate(1024));
				}

				if(selectionKey.isReadable()){
					System.out.println("开始处理读取消息");
					SocketChannel channel = (SocketChannel) selectionKey
							.channel();
					ByteBuffer buffer = (ByteBuffer)selectionKey.attachment();
					channel.read(buffer);

					System.out.println("客户端" + new String(buffer.array()));
				}
				iterator.remove();

			}
		}

	}
}
