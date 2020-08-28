package com.java.Thread.arrayBlockingQueue;

import lombok.SneakyThrows;

/**
 * @author ymj
 * @Date£º 2020/7/23 13:09
 * @description:
 */
public class TestThread implements Runnable {
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            System.out.println("thread1");
            Thread.sleep(2000);
        }
    }
}
