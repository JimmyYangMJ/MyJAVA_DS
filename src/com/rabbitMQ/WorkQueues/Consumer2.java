package com.rabbitMQ.WorkQueues;

import com.rabbitMQ.helloworld.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author ymj
 * @Date： 2020/7/30 11:00
 * @description: 消费者 2
 */
public class Consumer2 {
    private static final String QUEUE_NAME = "work_queue";
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("消费者2接收到消息：" + msg);
                try {
                    Thread.sleep(50);//模拟消费耗时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //消息消费完给服务器返回确认状态，表示该消息已被消费 （手动模式开启时使用）
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 启用自动模式： autoAck = true
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
