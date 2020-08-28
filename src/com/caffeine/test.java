package com.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * 三种加载策略
 * 手动加载，同步加载，异步加载
 * @author ymj
 * @Date： 2020/7/31 13:30
 * @description:
 */

public class test {

    public static void main(String[] args) {

        String key = "test";
        // 创建 手动模式的缓存
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(5000)
                .build();
        // 检索一个entry，如果没有则为null
        System.out.println(cache.getIfPresent("test"));

        // 检索一个entry，如果entry为null，则通过key创建一个entry并加入缓存
        cache.get(key, k -> createExpensiveGraph(key));

        System.out.println(cache.getIfPresent("test"));
        // 从缓存中移除
        cache.invalidate(key);
        System.out.println(cache.getIfPresent("test"));
        // 直接加入缓存
        cache.put(key, "graph");
        System.out.println(cache.getIfPresent("test"));

    }

    public static String createExpensiveGraph(String key) {
        System.out.println("加入 caffeine 缓存");
        return key + "666";
    }
}
