package com.ding.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author ding
 * @date 2020/11/12
 */
public class NioClient {

	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);

		if(!socketChannel.connect(new InetSocketAddress("127.0.0.1",6666))){
			while (!socketChannel.finishConnect()){
				System.out.println("==== 尚未连接 ====");
			}
		}

		String str = "ceshi";

		ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());

		socketChannel.write(buffer);
		System.in.read();
	}
}
