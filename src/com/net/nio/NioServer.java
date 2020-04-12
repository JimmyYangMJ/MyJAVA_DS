package com.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

    public static void main(String[] args) throws IOException {
    	int port = 8001;
    	Selector selector = null;
    	ServerSocketChannel servChannel = null;

    	/** 通道初始化 */
    	try {
			selector = Selector.open(); // 产生多路选择器
			servChannel = ServerSocketChannel.open(); // 开启 socket通道
			servChannel.configureBlocking(false); // 开启非阻塞模式
			servChannel.socket().bind(new InetSocketAddress(port), 1024); // 驻守在 port端口
			servChannel.register(selector, SelectionKey.OP_ACCEPT); // 绑定多路选择器+通道
			System.out.printf("服务器在%d端口守候\n", port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
    	
    	while(true) {
    		try {
    			selector.select(1000); // 开始轮询 通道
    			Set<SelectionKey> selectedKeys = selector.selectedKeys();
    			Iterator<SelectionKey> it = selectedKeys.iterator();
    			SelectionKey key = null;
    			while (it.hasNext()) {
    				key = it.next();
    				it.remove();
    				try {
    					/** 开始读数据 */
    					handleInput(selector,key);
    				} catch (Exception e) {
    					if (key != null) {
    						key.cancel();
    						if (key.channel() != null)
    							key.channel().close();
    					}
    				}
    			}
    		} 
    		catch(Exception ex)
    		{
    			ex.printStackTrace();    			
    		}
    		
    		try
    		{
    			Thread.sleep(500);
    		}
    		catch(Exception ex)
    		{
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
				sc.register(selector, SelectionKey.OP_READ);
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

	public static void doWrite(SocketChannel channel, String response) throws IOException {
		if (response != null && response.trim().length() > 0) {
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer);
		}
	}
}
