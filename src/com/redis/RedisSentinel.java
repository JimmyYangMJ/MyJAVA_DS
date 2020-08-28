package com.redis;

import org.redisson.Redisson;
import org.redisson.api.RBatchReactive;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.connection.SentinelConnectionManager;

/**
 * @author ymj
 * @Date： 2020/8/19 10:55
 * @description: 哨兵
 */
public class RedisSentinel {

    public static void main(String[] args) {
        Config config = new Config();
        config.setCodec(new org.redisson.client.codec.StringCodec());
        config.useSentinelServers()
                .setMasterName("mymaster")
                .addSentinelAddress("redis://10.1.4.141:26379")
                .addSentinelAddress("redis://10.1.4.141:26381")
                .addSentinelAddress("redis://10.1.4.141:26380");
        RedissonClient redisson;
        //初始化内存缓存
        redisson = Redisson.create(config);
        System.out.println(redisson.getBucket("test").get().toString());

    }


}
