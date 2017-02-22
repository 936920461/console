package com.console;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Main8 {

	public static void main(String[] args) throws IOException {
		Selector selector;
		// 获取通道
		ServerSocketChannel channel = ServerSocketChannel.open();
		// 设置为非阻塞
		channel.configureBlocking(false);
		if (!channel.socket().isBound()) {
			// 绑定端口
			channel.socket().bind(new InetSocketAddress(8088));
		}
		// 获取注册管理器
		selector = Selector.open();
		// 注册事件
		channel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("服务端启动成功！");
		while (true) {
			// 当注册的事件到达时，方法返回；否则,该方法会一直阻塞
			int count = selector.select();
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				// 查看事件数量
				System.out.println(count);
				SelectionKey key = iterator.next();
				// 删除已选中key，防止重复选择
				iterator.remove();
				// 客户端请求连接事件
				if (key.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					// 获得和客户端连接的通道
					SocketChannel sChannel = server.accept();
					if (sChannel != null) {
						// 设置成非阻塞
						sChannel.configureBlocking(false);
						// 在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
						sChannel.register(selector, SelectionKey.OP_READ);
					}
				} else if (key.isReadable()) {
					// 服务器可读取消息:得到事件发生的Socket通道
					SocketChannel rChannel = (SocketChannel) key.channel();
					if (rChannel != null) {
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						rChannel.read(buffer);
						byte[] data = buffer.array();
						String dataStr = new String(data);
						System.out.println(dataStr);
						rChannel.configureBlocking(false);
						// 在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置写的权限。
						rChannel.register(selector, SelectionKey.OP_WRITE);
						// 不想返回数据自己关闭
						// rChannel.close();
					}
				} else if (key.isWritable()) {
					SocketChannel wChannel = (SocketChannel) key.channel();
					if (wChannel != null) {
						String hello = "hello world...";
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						byte[] bytes = hello.getBytes();
						buffer.put(bytes);
						buffer.flip();
						wChannel.write(buffer);
						wChannel.shutdownInput();
						wChannel.close();
					}
				}
			}
		}
	}

}
