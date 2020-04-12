package com.net.tcp;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpServer implements Runnable{

	static Scanner cin = new Scanner(System.in);
	static OutputStream ops;

	static InputStream ips;
	static DataOutputStream dos;

	public static void main(String [] args) {
		try {
			/** 先开启 */
			// 服务器码头，如果有多块网卡，需要绑定一个IP地址
			ServerSocket ss=new ServerSocket(8000); //驻守在8000端口

			Socket socket = ss.accept();  /** 阻塞，等到有客户端连接上来 */

			System.out.println("welcome to the java world");
			//同一个通道，服务端的输出流就是客户端的输入流；服务端的输入流就是客户端的输出流
			ips = socket.getInputStream();    /** 1. 开启通道的输入流 */
			BufferedReader brNet = new BufferedReader(new InputStreamReader(ips));

			ops = socket.getOutputStream();  /** 2. 开启通道的输出流 */
			dos = new DataOutputStream(ops);

			BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
			Thread thread = new Thread(new TcpServer());
			thread.start();
			while (true)
			{
				/* 读*/
				//System.out.print(brKey.ready());
				String temp = brNet.readLine();
				System.out.println("Server said: " + temp);
				String strWord = "";
				if (strWord.equalsIgnoreCase("quit"))
				{
					break;
				}
				else
				{
//					System.out.println("I want to send: " + strWord);
//					dos.writeBytes(strWord + System.getProperty("line.separator"));

//					System.out.println("Server said: " + brNet.readLine());
				}

			}

			dos.close();
			brNet.close();
			brKey.close();
			socket.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true){
			String strWord = cin.nextLine();
			try {
				dos.writeBytes(strWord + System.getProperty("line.separator"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 写

	}
}