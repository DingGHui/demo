package com.ding.demo.bioDemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ding
 * @date 2020/11/11
 */
public class BIOServerDemo {
	/**
	 * bio 阻塞的点: 等待连接 serverSocket.accept() 和 inputStream.read()
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		ServerSocket serverSocket = new ServerSocket(6666);
		System.out.println("服务器启动...." + Thread.currentThread().getName());
		while (true) {
			System.out.println("等待连接...." + Thread.currentThread().getName());
			Socket socket = serverSocket.accept(); //等待连接出现阻塞
			System.out.println("获取到新连接");
			cachedThreadPool.submit(new Runnable() {
				@Override public void run() {
					handle(socket);
				}
			});
		}
	}

	public static void handle(Socket socket) {
		System.out.println("处理请求内容: "+ Thread.currentThread().getName());
		byte[] bytes = new byte[1024];
		while (true) {
			System.out.println("等待内容1...");
			try {
				InputStream inputStream = socket.getInputStream();
				System.out.println("等待内容2...");
				int read = inputStream.read(bytes); // read 出现阻塞
				System.out.println("等待内容3...");
				if (read == -1) {
					socket.close();
				} else {
					System.out.println("读取内容: " + new String(bytes) + ", read: " + read + "," + Thread.currentThread().getName());
				}
			} catch (IOException e) {
				System.out.println("读取inputStream exception");
				e.printStackTrace();
			}
		}
	}
}
