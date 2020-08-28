package com.rabbitMQ.helloworld;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author ymj
 * @Date： 2020/7/29 13:34
 * @description: 消费者消费信息
 */
public class Consumer {

    private static final String QUEUE_NAME = "basic_queue";

    public static void main(String[] args) throws Exception {
        // 消息消费者与mq服务建立连接
        Connection connection = ConnectionUtil.getConnection();
        //建立通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            // 获取消息，并且处理，这个方法类似事件监听，如果有消息的时候，会被自动调用
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                // body 即消息体
                String msg = new String(body);
                System.out.println("消费者1接收到消息：" + msg);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
