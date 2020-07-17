package com.disruptor;

/**
 * 定义事件 Event
 * @author ymj
 * @Date： 2020/7/8 11:18
 */
public class LongEvent {
    private long value;
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}