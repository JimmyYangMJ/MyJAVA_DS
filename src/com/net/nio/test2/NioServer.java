package com.net.nio.test2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

public class NioServer implements Runnable{

	public static Scanner cin = new Scanner(System.in);

	public static Map<Integer, SelectionKey> ClientMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
    	int port = 8001;
    	Selector selector = null;
    	ServerSocketChannel serverSocketChannel = null;

    	/** 向客户端发送消息 -线程*/
    	new Thread(new NioServer()).start();

    	/** 通道初始化 */
    	try {
			selector = Selector.open(); // 产生多路选择器
			serverSocketChannel = ServerSocketChannel.open(); // 开启 socket通道（Channel）
			serverSocketChannel.configureBlocking(false); // 开启非阻塞模式
			serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024); // 驻守在 port端口
			System.out.println("===accept 接受===");
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); // 绑定多路选择器+通道
			System.out.printf("===服务器在%d端口守候===\n", port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

    	while(true) {
    		try {
				selector.select(1000); // 开始轮询 通道，2000ms轮询一次

    			Set<SelectionKey> selectedKeys = selector.selectedKeys();
    			Iterator<SelectionKey> it = selectedKeys.iterator();
    			SelectionKey key = null;
    			while (it.hasNext()) {
    				key = it.next();
    				it.remove();
    				try {
    					/** 开始处理通道 */
    					handleInput(selector, key);
    					System.out.println("===处理完成===");
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

	/**
	 * 处理通道连接
 	 * @param selector 选择器
	 * @param key 选择通道对应key
	 * @throws IOException
	 */
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
				System.out.println("==有一个新的连接==" + key);
			}
			/** 接受消息 */
			if (key.isReadable()) { // 可以读数据
				// Read the data
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if (readBytes > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					/** request 接受到的消息 */
					String request = new String(bytes, "UTF-8"); //接收到的输入
					System.out.printf("client %s said: %s\n" , key,request);

					/**  格式：
					 * [id]：[message]
					 */
					String[] requests = request.split(":",2);
					int id = Integer.parseInt(requests[0]);
					//System.out.printf("client (id = %d)said: %s\n" , id, requests[1]);

					/** 记录客户 */
					if(ClientMap.containsValue(key) == false) {
						ClientMap.put(id, key);
						System.out.printf("客户 %d 初次注册\n", id);
					}else {
						System.out.printf("客户 %d 已经注册\n", id);
					}

					String response = "<accept>";
					doWrite(sc, response); //  + System.getProperty("line.separator")
				} else if (readBytes < 0) {
					// 对端链路关闭
					key.cancel();
					sc.close();
				} else
					; // 读到0字节，忽略
			}
		}
	}

	/**
	 *  写数据
	 * @param socketChannel 数据通道
	 * @param response 数据内容
	 * @throws IOException
	 */
	public static void doWrite(SocketChannel socketChannel, String response) throws IOException {
		if (response != null && response.trim().length() > 0) {
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);

			writeBuffer.put(bytes);
			writeBuffer.flip();

			try {
				System.out.println("状态：" + socketChannel.isConnected());
				socketChannel.write(writeBuffer);
				System.out.println("已经发送");
			} catch (ClosedChannelException e) {
				System.out.println("对方离线");
			}
		}
	}

	/**
	 * 发送消息给 指定 客户端
	 *  Todo 发送心跳包
	 */
	@Override
	public void run() {
    	while (true) {

    		System.out.print("输入客户端id：");
			int a = Integer.parseInt(cin.nextLine());
			if (ClientMap.containsKey(a) == true) {
				System.out.println("发送消息给：" + a);

				try {
					String temp = cin.nextLine();
					SocketChannel sc = (SocketChannel) ClientMap.get(a).channel();
					doWrite(sc, temp + System.getProperty("line.separator"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("没有此用户");
			}


		}

	}

	/**
	 * 指定客户端发送消息
	 * @param id 客户端 id
	 * @param message 消息
	 */
	public static void messageSend(int id, String message){

		if (ClientMap.containsKey(id) == true) {
			System.out.println("发送消息给：" + id);

			try {
				SocketChannel sc = (SocketChannel) ClientMap.get(id).channel();
				doWrite(sc, message); //  + System.getProperty("line.separator")
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("没有此用户");
		}

	}



	/**
	 * 关闭通道连接
	 * @param _clientSocket
	 */
	public void ShutDownClient(SocketChannel _clientSocket)
	{
		if(_clientSocket.isOpen())
		{
			try
			{
				//将连接的输入输出都关闭，而不是直接Close连接
				_clientSocket.shutdownInput();
				_clientSocket.shutdownOutput();
				ClientMap.remove(_clientSocket);
				System.out.println("客户端无响应：" + _clientSocket.socket().getPort());
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
