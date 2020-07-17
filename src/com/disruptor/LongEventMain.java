package com.disruptor;

/**
 * @author ymj
 * @Date： 2020/7/8 13:08
 */

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 使用LongEventProducer
 * Created by xmr on 2017/6/7.
 */
public class LongEventMain {
    public static void main(String[] args) {
// Executor that will be used to construct new threads for consumers
        /** 线程池 */
        Executor executor = Executors.newCachedThreadPool();
// The factory for the event
        /** 事件工厂 */
        EventFactory eventFactory = new LongEventFactory();
// RingBuffer 大小，必须是 2 的 N 次方
        /** 循环队列大小 */
        int ringBufferSize = 1024 * 1024;
        //int ringBufferSize = 8;
// Construct the Disruptor
        /**
         * 工厂， 仓库大小， 线程池（执行者）
         */
        Disruptor<LongEvent> disruptor = new Disruptor<>(eventFactory, ringBufferSize, executor);
        /** 事件处理者（消费者，消费LongEvent） */
        EventHandler<LongEvent> eventHandler = new LongEventHandler();
        /** 允许消费者消费 */
        disruptor.handleEventsWith(eventHandler);//连接handler
        /** 可以消费了*/
        disruptor.start();//启动disruptor，启动所有线程
//从disruptor中获得ringBuffer用于发布

        /** 创建指定仓库（循环队列 ） */
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        /** 消费者： 在指定循环队列上消费了 */
        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; l < 15; l++) {
            // 生产了一个随机数 （没有包装哦）
            int k = 1 + (int)( Math.random()*(100 ));
            // 包装起来
            producer.onData(k);
            // 消费者消费
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===" + disruptor.getRingBuffer().getCursor() + "===" + disruptor.getRingBuffer().getBufferSize());
        }
        disruptor.shutdown();
    }
}