package com.net.nio.test3;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author ymj
 * @Date： 2020/4/28 20:06
 */
public class NioServerWrite implements Runnable{

    private static volatile String sendMessage = null;
    private static volatile int sendId = 0;

    public static void setSendMessage(String sendMessage) {
        NioServerWrite.sendMessage = sendMessage;
    }

    public static void setSendId(int sendId) {
        NioServerWrite.sendId = sendId;
    }

    @Override
    public void run() {
        new Test().start();

        while (true) {
            if (sendId > 0 && sendMessage != null){
                try {
                    if (NioServer.ClientMap.get(sendId) != null){
                        int answer = NioServer.messageSend(sendId,sendMessage);

                        if (answer == -1){
                            System.out.printf("客户端 %d 连接断开, 通道设为空\n", sendId);

                                NioServer.ClientMap.get(sendId).channel().close();

                            NioServer.ClientMap.put(sendId, null); // 通道设为空
                        }
                    } else {
                        System.out.println("用户：" + sendId + "不存在" );
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sendMessage = null;
                sendId = 0;
            }
        }
    }
}

class Test extends Thread{

    static Scanner cin = new Scanner(System.in);
    @Override
    public void run() {
        while (true){
            System.out.print("输入id：");
            int id = cin.nextInt();
            cin.nextLine();
            System.out.print("输入消息：");
            String  massage = cin.nextLine();
            NioServerWrite.setSendId(id);
            NioServerWrite.setSendMessage(massage);
        }
    }
}
