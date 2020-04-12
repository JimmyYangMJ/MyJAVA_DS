package com.net.udp;

import java.net.*;
public class UdpRecv {
	/** 接收方 早于 发起方 */
	public static void main(String[] args) throws Exception {
		/** 1. 通讯的数据管道 */
		DatagramSocket	ds=new DatagramSocket(8080);

		byte [] buf=new byte[1024];
		/** 2.集装箱： 封装数据 */
		DatagramPacket dp = new DatagramPacket(buf,1024);
		
		System.out.println("UdpRecv: 我在等待信息");

		ds.receive(dp);  /** 3.  接收封装好的数据 */

		System.out.println("UdpRecv: 我接收到信息");

		/** 分析数据 */
		String strRecv=new String(dp.getData(),0,dp.getLength()) +
		" from " + dp.getAddress().getHostAddress()+":"+dp.getPort(); 
		System.out.println(strRecv);
		// 接收完成 ***************************

		Thread.sleep(1000);
		System.out.println("UdpRecv: 我要发送信息");
		String str="已经接收到数据";
		DatagramPacket dp2=new DatagramPacket(str.getBytes(),str.length(),
				InetAddress.getByName("127.0.0.1"),dp.getPort());
		ds.send(dp2);
		System.out.println("UdpRecv: 我发送信息结束");
		ds.close(); /** 关闭管道 */
	}
}