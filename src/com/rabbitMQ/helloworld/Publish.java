package com.rabbitMQ.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author ymj
 * @Date： 2020/7/29 13:25
 * @description: 简单模式
 */
public class Publish {

    private static final String QUEUE_NAME = "basic_queue";

    public static void main(String[] args) throws Exception {
        // 消息发送端与mq服务创建连接
        Connection connection = ConnectionUtil.getConnection();
        // 建立通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "hello world";
        // 发布消息
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("生产者已发送：" + message);
        // 通道关闭， 连接关闭
        channel.close();
        connection.close();
    }

}
