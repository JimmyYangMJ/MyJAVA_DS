package com.disruptor;

import com.lmax.disruptor.EventFactory;

/**、
 * 需要让Disruptor为我们创建事件，我们同时还需要声明一个EventFactory来实例化Event对象
 * @author ymj
 * @Date： 2020/7/8 11:21
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    /**
     * 工厂模式
     * @return 事件
     *
     */
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}