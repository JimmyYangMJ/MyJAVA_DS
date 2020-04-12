package com.net.tcp;


import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpClient implements Runnable{

	static Scanner cin = new Scanner(System.in);

	static BufferedReader brNet;

	static DataOutputStream dos;

	public static void main(String[] args) {
		try {
			/** 先开启 */
			Socket socket = new Socket(InetAddress.getByName("192.168.179.182"), 8000);

			//鍚屼竴涓�氶亾锛屾湇鍔＄鐨勮緭鍑烘祦灏辨槸瀹㈡埛绔殑杈撳叆娴侊紱鏈嶅姟绔殑杈撳叆娴佸氨鏄鎴风鐨勮緭鍑烘祦
			InputStream ips = socket.getInputStream();    /** 1. 寮�鍚�氶亾鐨勮緭鍏ユ祦 */
			brNet = new BufferedReader(new InputStreamReader(ips));

			OutputStream ops = socket.getOutputStream();  /** 2. 寮�鍚�氶亾鐨勮緭鍑烘祦 */
			dos = new DataOutputStream(ops);

			BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
			Thread thread = new Thread(new TcpClient());
			thread.start();

			while (true)
			{
				/* 写 */
//				String strWord = brKey.readLine();
				String strWord = cin.nextLine();
				if (strWord.equalsIgnoreCase("quit"))
				{
					break;
				}
				else
				{
					System.out.println("I want to send: " + strWord);
					dos.writeBytes(strWord + System.getProperty("line.separator"));

//					System.out.println("Server said: " + brNet.readLine());
				}

			}

			dos.close();
			brNet.close();
			brKey.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true){

			String temp = "";
			try {
				temp = brNet.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Server said: " + temp);
			String strWord = "";
			if (strWord.equalsIgnoreCase("quit"))
			{
				break;
			}
		}
		// 写

	}
}
