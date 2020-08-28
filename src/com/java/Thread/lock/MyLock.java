package com.java.Thread.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author ymj
 * @Date： 2020/7/31 14:22
 * @description:
 */
public class MyLock {
    static StampedLock lock = new StampedLock();
    static int i = 5;
    public static void main(String[] args) {

        long stamp = lock.readLock();

        test test = new test();
        test.start();
        System.out.println(stamp);

        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i = 10;

        lock.unlockRead(stamp);
        System.out.println(i);

    }

    static class test extends Thread{
        @Override
        public void run() {
            System.out.println(i + "**");
        }
    }
}
