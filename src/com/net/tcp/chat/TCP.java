package com.net.tcp.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class TCP  {

    private void client() { // 连接套接字方法
        System.out.println("尝试连接\n"); // 输出提示信息
        try { // 捕捉异常
            Socket socket = new Socket("127.0.0.1", 8080); // 实例化Socket对象，连接端口8080服务器
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);//建立通信通道，强行输出数据
            System.out.println("完成连接");
            Scanner sc=new Scanner(socket.getInputStream());//获得服务机的输入流并转为Scanner对象
            System.out.println(sc.nextLine());//输出信息
            System.out.println("我（客户机）：");
            Scanner sc1=new Scanner(System.in);
            while(true){
                String data=sc1.nextLine();
                //System.out.println("我（客户机）："+data);
                writer.println(data);//将数据写入流
                writer.flush();//关闭流


                String data1=sc.nextLine();
                System.out.println("服务机："+data1);
                System.out.println("我（客户机）：");
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }

    public static void main(String[] args) { // 主方法
        TCP clien = new TCP(); // 创建本例对象

        clien.client(); // 调用连接方法
    }
}
