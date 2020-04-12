package com.net.tcp.chat;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class TCPServe { // 创建类


    void serve() {
        try {
            ServerSocket server = new ServerSocket(8000); // 实例化ServerSocket对象，设置端口为8080
            System.out.println("服务器套接字已经创建成功");
            //while (true) { // 如果套接字是连接状态
                System.out.println("等待客户机的连接.......");
                Socket socket = server.accept(); // 实例化Socket对象，使用accept方法等待客户机连接
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);//建立通信通道，强行输出数据
                writer.println("您已成功连接到远程服务器！"+"/"+"有什么可以帮你的吗？");//将信息写入流
                writer.flush();//关闭流
                Scanner sc=new  Scanner(System.in);
                Scanner sc1=new Scanner(socket.getInputStream());//从客户机里获得输入流并转化为Scanner对象
                while(true){
                    System.out.println("客户机：");
                    while (sc1.hasNext()){
                        String data = sc1.nextLine();
                        System.out.println(data);
                    }
                    System.out.println("======");

                    System.out.print("我(服务机)：");
                    String data1 = sc.nextLine();
                    //System.out.println("我(服务机)："+data1);
                    writer.println(data1);//将数据写入流
                    writer.flush();//关闭流
                }
            //}
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }
    public static void main(String[] args) { // 主方法
        TCPServe tcp = new TCPServe(); // 创建本类对象
        tcp.serve(); // 调用方法
    }
}
