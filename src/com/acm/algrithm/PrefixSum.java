package com.acm.algrithm;

import java.util.Scanner;

/**
 * 前缀和问题
 * 将数组存储为前k项的和
 */
public class PrefixSum {

    public static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        int L, W;
        L = cin.nextInt();
        W = cin.nextInt();
        int[][] c = new int[L+1][W+1];

        for(int i = 1; i <= L; i++){
            for(int j = 1; j <= W; j++) {
                c[i][j] = cin.nextInt();
                /** 求前缀和*/
                c[i][j] = c[i][j] + c[i][j-1] + c[i-1][j] - c[i-1][j-1];
            }
        }
        /**
         * 二维的前缀和 （抽象为某一点到左上角的面积）
         * 应用： 通过前缀和，可以通过面积的加减，计算某一区间的面积
         */
        for(int i = 1; i <= L; i++){
            for(int j = 1; j <= W; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        /**
         * 例题： 上交大OJ 1002：二哥种花生
         * RMQ (Range Minimum/Maximum Query) 问题
         */
    }
}
