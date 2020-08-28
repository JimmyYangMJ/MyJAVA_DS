package com.redis;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.apache.commons.lang.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RExecutorService;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClientConfig;
import org.redisson.client.RedisConnection;
import org.redisson.client.codec.StringCodec;
import org.redisson.client.protocol.RedisCommands;
import org.redisson.config.Config;

import java.util.Map;

/**
 * @author ymj
 * @Date： 2020/7/31 16:11
 * @description: redission
 */
public class redission {
    public static void main(String[] args) {

        System.out.println(new redission().getMemoryInfo());
    }

    public  void test2() {
    }

    /**
     * 单节点配置
     */
    public static void test(){
        //        Config config = new Config();
//        config.setCodec(new org.redisson.client.codec.StringCodec());
//        config.useSingleServer()
//                .setAddress("http://127.0.0.1:6379")
//                .setPassword("123456");
//
//        RedissonClient redisson = Redisson.create(config);

        //创建配置
        Config config = new Config();
        config.setCodec(new org.redisson.client.codec.StringCodec());
        config.useSingleServer()
                .setAddress("http://10.1.4.145:6379");
        //初始化内存缓存
        RedissonClient redisson = Redisson.create(config);

        System.out.println(redisson.getBucket("k2").get().toString());
//        RBucket<String> keyObject = redisson.getBucket("k2");
//        RBucket  keyObject = redisson.getBucket("k2");
//        keyObject.set("v2");
//        System.out.println(keyObject.get());

//        RMap<String, String> map = redisson.getMap("myMap");

        redisson.shutdown();
    }

    /**
     * 执行 redis 命令
     * @return
     */
    public Map<String,String> getMemoryInfo(){
        RedisConnection conn = getMRedisClient().connect();
        // info replication
        Map<String,String> memoryInfo = conn.sync(StringCodec.INSTANCE, RedisCommands.INFO_REPLICATION);
        conn.closeAsync();
        return  memoryInfo;
    }
    private org.redisson.client.RedisClient mRedisClient;
    public org.redisson.client.RedisClient getMRedisClient(){
        if(mRedisClient == null) {
            EventLoopGroup group = new NioEventLoopGroup();
            RedisClientConfig config = new RedisClientConfig();
            config.setAddress("http://10.1.4.141:6379");
//            config.setDatabase(0)
//                    .setClientName("myClient")
//                    .setGroup(group);
            mRedisClient = org.redisson.client.RedisClient.create(config);
        }
        return mRedisClient;
    }

    /**
     * 哨兵模式配置
     * @return
     */
    public static Config ConfigSentinel(){
        Config config = new Config();
        config.setCodec(new org.redisson.client.codec.StringCodec());
        config.useSentinelServers()
                .setMasterName("mymaster")
                .addSentinelAddress("redis://10.1.4.141:26379")
                .addSentinelAddress("redis://10.1.4.141:26381")
                .addSentinelAddress("redis://10.1.4.141:26380");
        return config;
    }
}
