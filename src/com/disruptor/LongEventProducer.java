package com.disruptor;

import com.lmax.disruptor.RingBuffer;


/**
 * 生产者
 * @author ymj
 * @Date： 2020/7/8 11:30
 */
public class LongEventProducer {

    /** 循环队列 */
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * onData用来发布事件，每调用一次就发布一次事件
     * 它的参数会通过事件传递给消费者
     * @param bb
     */
    public void onData(int bb) {
        long sequence = ringBuffer.next(); // Grab the next sequence
        System.out.println("生产了一个 放在： " + sequence + "号仓库");
        try {
            LongEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor for the sequence
            event.setValue(bb); // Fill with data
            System.out.println("包装好了，可以使用");
        } finally {
            // 触发 onEvent事件 消费
            ringBuffer.publish(sequence);

        }
    }
}