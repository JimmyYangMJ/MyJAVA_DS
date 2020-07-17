package com.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * 事件处理具体实现（消费者）
 * @author ymj
 * @Date： 2020/7/8 11:26
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    /**
     *
     * @param longEvent 发布到 环形缓冲区 （ringBuffer ）的事件
     * @param l 正在处理的事件
     * @param b 以指示这是否是来自环形缓冲区的批处理中的最后一个事件
     * @throws Exception
     */
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("消费事件 ：" + longEvent.getValue() + " 计数: " + l + "最后一个" + b);

    }
}