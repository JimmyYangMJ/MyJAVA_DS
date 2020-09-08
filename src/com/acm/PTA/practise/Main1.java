package com.acm.PTA.practise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ymj
 * @Date： 2020/9/3 9:30
 * @description: 连续因子
 *
 * 一个正整数 N 的因子中可能存在若干连续的数字。例如 630 可以分解为 3×5×6×7，
 * 其中 5、6、7 就是 3 个连续的数字。给定任一正整数 N，要求
 * 输入样例：
 * 630
 * 输出样例：
 * 3
 * 5*6*7
 * todo
 */
public class Main1 {
    static Scanner cin = new Scanner(System.in);
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        int a = cin.nextInt();
        if(a == 2){
            System.out.println("1");
            System.out.println("2");
            return;
        }
        int sum = 1;
        int count = 0;
        int max = 0;
        String maxString = "";
        for (int i = 2; i < a; i ++) {
            sum *= i;
            queue.offer(i);
            if (a % sum == 0){
                count++;
            }else {
                sum /= queue.poll();
            }
            if (count > max) {
                max = count;
                for (int temp : queue) {
                    maxString += temp + "*";
                }
            }
        }
        System.out.println(max);
        String[] split = maxString.split("\\*");
        for (int i = split.length- max; i < split.length ; i++) {
            System.out.print(split[i]);
            if (i + 1 < split.length)
                System.out.print("*");
        }
    }

}

