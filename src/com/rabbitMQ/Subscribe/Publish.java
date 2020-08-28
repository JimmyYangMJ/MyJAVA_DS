package com.rabbitMQ.Subscribe;

import com.rabbitMQ.helloworld.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author ymj
 * @Date： 2020/7/30 16:17
 * @description: 发送者
 */
public class Publish {
    private static final String EXCHANGE_NAME = "fanout_exchange";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 声明exchange，指定类型为fanout
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        String message = "hello world";
        // 不直接发送给队列，而是发送给交换机
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println("生产者发送消息：" + message);
        channel.close();
        connection.close();
    }
}
