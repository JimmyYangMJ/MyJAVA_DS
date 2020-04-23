package com.net.nio.test1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

public class NioClient {

	public static Scanner cin = new Scanner(System.in);

	public static int ID = 1;

	public static void main(String[] args) {

		//String host = "192.168.179.182";
		String host = "127.0.0.1";
		int port = 8001;

		System.out.println("输入客户端编号：" + (ID = cin.nextInt()));
		System.out.println(ID);

		Selector selector = null;
		SocketChannel socketChannel = null;

		try {
			selector = Selector.open(); // 开选择器
			socketChannel = SocketChannel.open(); // 开通道
			socketChannel.configureBlocking(false); // 设置非阻塞

			// 如果直接连接成功，则注册到多路复用器上，发送请求消息，读应答
			if (socketChannel.connect(new InetSocketAddress(host, port))) {
				System.out.println("服务器连接成功");
				System.out.println("reda 读取");
				System.out.println(socketChannel.register(selector, SelectionKey.OP_READ));
				/** 开始写数据 */
				doWrite(socketChannel);
			} else {
				System.out.println("connect 连接");
				socketChannel.register(selector, SelectionKey.OP_CONNECT); // 选择器和通道 注册绑定
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		while (true) {
			try {
				selector.select(1000);  // 遍历选择器（中的通道）
				Set<SelectionKey> selectedKeys = selector.selectedKeys(); //所有连接上的选择器 key
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) { // 顺序处理 选择器中 有反应的通道
					key = it.next();
					it.remove();
					try {
						// 处理每一个channel
						handleInput(selector, key);
					}
					catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null)
								key.channel().close();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		// 多路复用器关闭后，所有注册在上面的Channel资源都会被自动去注册并关闭
//		if (selector != null)
//			try {
//				selector.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//		}
	}

	/**
	 * 写数据
	 * @param sc
	 * @throws IOException
	 */
	public static void doWrite(SocketChannel sc) throws IOException {

		String temp = cin.nextLine();
		temp = Integer.toString(ID) + ":" + temp;

		byte[] str = temp.getBytes();
//		byte[] str = UUID.randomUUID().toString().getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(str.length);
		writeBuffer.put(str);
		writeBuffer.flip();

		sc.write(writeBuffer); // 向通道发送数据
	}

	/**
	 * 读数据：处理通道
	 * @param selector
	 * @param key
	 * @throws Exception
	 */
	public static void handleInput(Selector selector, SelectionKey key) throws Exception {
		/**  判断是否连接成功*/
		if (key.isValid()) {
			// 获取key 相对应 的 通道Channel
			SocketChannel sc = (SocketChannel) key.channel();
			if (key.isConnectable()) { // 判断 key 和 selector 是否已经注册
				if (sc.finishConnect()) {
					sc.register(selector, SelectionKey.OP_READ);
				}
			}

			// 可以读数据
			if (key.isReadable()) {
				System.out.println("可以读数据");
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if (readBytes > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("Server said : " + body);
				} else if (readBytes < 0) {
					// 对端链路关闭
					key.cancel();
					sc.close();
				} else
					; // 读到0字节，忽略
			}
			//Thread.sleep(3000);

			/** 发送数据 */
			doWrite(sc);
		}
	}
}