package com.acm.algrithm.DP;

import java.util.Scanner;

/**
 * 最长上升子序列
 * 题目：POJ 2533
 * 递推型动态规划
 */
public class LongestOrderedSubsequence {

    public static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        int n = cin.nextInt(); // 1 <= N <= 1000

        int[] a = new int[n];

        /** 最长上升子序列长度，初值为1*/
        int[] maxLen = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = cin.nextInt();
            maxLen[i] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(a[i] > a[j]){
                    maxLen[i] = Math.max(maxLen[i], maxLen[j]+1);
                }
            }
        }
        int max = maxLen[0];
        for(int temp:maxLen){
            if(temp > max){
                max = temp;
            }
        }
        System.out.print(max);

    }
}
