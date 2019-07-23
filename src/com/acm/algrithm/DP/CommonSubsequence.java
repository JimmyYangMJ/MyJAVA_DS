package com.acm.algrithm.DP;

import java.util.Scanner;

/**
 * 最长公共子序列
 * 题目：POJ 1458
 * 动态规划
 */
public class CommonSubsequence {

    static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        while (cin.hasNext()){
            char[] s1, s2;
            s1 = cin.next().toCharArray();
            s2 = cin.next().toCharArray();
            /** 存储最大公共子序列*/
            int[][] maxLen = new int[s1.length+1][s2.length+1];

            /** 初始化，s1为0 或 s2为0 时最大公共子序列为0*/
            for(int i = 0; i <= s1.length; i++){
                maxLen[i][0] = 0;
            }
            for(int i = 0; i <= s2.length; i++){
                maxLen[0][i] = 0;
            }

            /** 填表*/
            for(int i = 1; i <= s1.length; i++){
                for(int j = 1; j <= s2.length; j++){
                    if(s1[i-1] == s2[j-1]){
                        maxLen[i][j] = (maxLen[i-1][j-1] + 1);
                    }else{
                        maxLen[i][j] = Math.max(maxLen[i][j-1], maxLen[i-1][j]);
                    }
                }
            }
            System.out.println(maxLen[s1.length][s2.length]);
        }


    }
}
