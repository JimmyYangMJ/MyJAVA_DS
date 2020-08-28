package com.java.Thread.arrayBlockingQueue;

import com.designPattern.CreationModel.singleton.Test;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author ymj
 * @Date： 2020/7/23 13:08
 * @description:
 */
public class BlockingQueue {

    static public Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        TestThread testThread = new TestThread();
        Thread thread = new Thread(testThread);
        thread.start();
        while (true) {
            int i = cin.nextInt();
            if (i == 1) {
                arrayBlockingQueue.offer(thread);
                System.out.println(arrayBlockingQueue.size());
            } else if (i == 2){
                arrayBlockingQueue.poll();
                System.out.println("*" + arrayBlockingQueue.size());
            }
            i = 0;
        }
    }

}
