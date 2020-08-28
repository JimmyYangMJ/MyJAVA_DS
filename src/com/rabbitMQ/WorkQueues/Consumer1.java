package com.rabbitMQ.WorkQueues;

import com.rabbitMQ.helloworld.ConnectionUtil;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author ymj
 * @Date： 2020/7/30 10:58
 * @description: 消费者1
 */
public class Consumer1 {

    private static final String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("消费者1接收到消息：" + msg);
                try {
                    Thread.sleep(50);//模拟消费耗时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
