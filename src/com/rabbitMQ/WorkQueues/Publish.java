package com.rabbitMQ.WorkQueues;

import com.rabbitMQ.helloworld.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author ymj
 * @Date： 2020/7/30 10:56
 * @description: send 生产者
 */
public class Publish {
    private static final String QUEUE_NAME = "work_queue";
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 循环发布任务
        for (int i = 1; i <= 20; i++) {
            // 消息内容
            String message = "task .. " + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("生产者发送消息：" + message);
            Thread.sleep(500);
        }
        channel.close();
        connection.close();
    }
}
