package com.net.nio.test1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NioServer implements Runnable{

	public static Scanner cin = new Scanner(System.in);

	public static Map<Integer, Object> ClientMap = null;

    public static void main(String[] args) throws IOException {
    	int port = 8001;
    	Selector selector = null;
    	ServerSocketChannel serverSocketChannel = null;

    	/** 通道初始化 */
    	try {
			selector = Selector.open(); // 产生多路选择器
			serverSocketChannel = ServerSocketChannel.open(); // 开启 socket通道（Channel）
			serverSocketChannel.configureBlocking(false); // 开启非阻塞模式
			serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024); // 驻守在 port端口
			System.out.println("accept 接受");
			System.out.println("服务器：" + serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT));// 绑定多路选择器+通道
			System.out.printf("服务器在%d端口守候\n", port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
    	
    	while(true) {
    		try {
    			System.out.println("轮询通道数：" + selector.select(2000));  // 开始轮询 通道，每隔1000ms轮询一次

    			Set<SelectionKey> selectedKeys = selector.selectedKeys();
    			Iterator<SelectionKey> it = selectedKeys.iterator();
    			SelectionKey key = null;
    			while (it.hasNext()) {
    				key = it.next();
    				it.remove();
    				System.out.println("服务器接收Key：" + key.toString());
    				try {
    					/** 开始读数据 */
    					handleInput(selector, key);
    				} catch (Exception e) {
    					if (key != null) {
    						key.cancel();
    						if (key.channel() != null)
    							key.channel().close();
    					}
    				}
    			}
    		} catch(Exception ex) {
    			ex.printStackTrace();    			
    		}
    		
    		try {
    			Thread.sleep(500);
    		} catch(Exception ex) {
    			ex.printStackTrace();    			
    		}
    	}
    }
    
    public static void handleInput(Selector selector, SelectionKey key) throws IOException {

		if (key.isValid()) {
			// 处理新接入的请求消息
			if (key.isAcceptable()) { // 连接刚刚建立
				// Accept the new connection
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				// Add the new connection to the selector
				System.out.println("reda 读取");
				sc.register(selector, SelectionKey.OP_READ);
				System.out.println("有一个新的连接");
			}
			if (key.isReadable()) { // 可以读数据
				// Read the data
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if (readBytes > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String request = new String(bytes, "UTF-8"); //接收到的输入
					System.out.println("client said: " + request);
					
					String response = request + " 666";
					doWrite(sc, response);
				} else if (readBytes < 0) {
					// 对端链路关闭
					key.cancel();
					sc.close();
				} else
					; // 读到0字节，忽略
			}
		}
	}

	public static void doWrite(SocketChannel socketChannel, String response) throws IOException {
		if (response != null && response.trim().length() > 0) {
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);

			writeBuffer.put(bytes);
			writeBuffer.flip();

			socketChannel.write(writeBuffer);
		}
	}

	@Override
	public void run() {

	}
}
