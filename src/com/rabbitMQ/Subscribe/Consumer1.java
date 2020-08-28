package com.rabbitMQ.Subscribe;

import com.rabbitMQ.helloworld.ConnectionUtil;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author ymj
 * @Date： 2020/7/30 16:20
 * @description: 消费者
 */
public class Consumer1 {
    private static final String QUEUE_NAME = "fanout_queue_1";
    private static final String EXCHANGE_NAME = "fanout_exchange";

    private final static Logger logger = LoggerFactory.getLogger(Consumer1.class);

    public static void main(String[] args) throws Exception {
        logger.info("My info");
        logger.debug("MyDebug");
        logger.error("My Error");
        logger.warn("My warn");
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //消费者声明自己的队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 声明exchange，指定类型为direct
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        //消费者将队列与交换机进行绑定
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
        channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException
            {
                String msg = new String(body);
                System.out.println("消费者1获取到消息：" + msg);
            }
        });
    }
}
