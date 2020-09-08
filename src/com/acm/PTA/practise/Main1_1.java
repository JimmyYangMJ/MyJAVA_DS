package com.acm.PTA.practise;

import java.util.Scanner;

/**
 * @author ymj
 * @Date： 2020/9/3 9:43
 * @description: 连续因子
 */
public class Main1_1 {
    static Scanner cin = new Scanner(System.in);

    /**
     * 通过 first 指针
     * @param args
     */
    public static void main(String[] args) {
        int num = cin.nextInt();
        int first = 0, len = 0, temp = 0, maxn = (int) (Math.sqrt(num) + 1);
        for (int i = 2; i <= num/2+1; i++) {
            int j;
            temp = 1;
            for (j = i; j <= maxn; j++) {
                temp *= j;
                if (num % temp != 0) break;
            }
            if (j - i > len) {
                len = j - i;
                first = i;
            }
        }
        if (first == 0) {
            System.out.println("1");
            System.out.println(num);
        } else {
            System.out.println(len);
            for (int i = 0; i < len; i++) {
                System.out.print(first + i);
                if (i != len - 1)
                    System.out.print("*");
            }
        }
    }
}
