package com.java.POJ;

import java.util.Scanner;

public class KnapSack_01 {

	public static Scanner cin = new Scanner(System.in);
	/** 背包价值*/
	public static int[][] dp ; 
	
	private static int max(int a, int b) {
		return a > b? a: b;
	} 
	
	public static int KnapSack(int n, int c, int w[], int v[]) {
		
		//填表,其中第0行和第0列全为0 , 表示没有装物体
	    for(int i = 0; i <= n; i++)  // 物品数 
	        dp[i][0]=0;
	    for(int j = 0; j <= c; j++)  // 容量 
	        dp[0][j]=0;
	    
		for(int i = 1; i <=n; i++) { // 装物品数
			
			for(int j = 1; j <= c; j++) { // 容量
				if(j < w[i]) {  // 容量装不下 物品i
					dp[i][j] = dp[i-1][j]; // 保存上一次的结果
				}else {  /** 当前容量装得下*/
					/** 装了当前物品前的容量价值  + 当前物品价值*/
					int last = dp[i-1][j-w[i]] + v[i];
					/** 比较 （不装当前物品  & + 装当前物品价值）*/
					dp[i][j] = max(dp[i-1][j], last);
				}
			}
		}
		return dp[n][c];
	}
	
	public static void main(String[] args) {
		
		/** n件物品*/
		int n = cin.nextInt(); 
		/** 背包容量 */
		int c= cin.nextInt();
		
		int[] weight = new int[n+1];
		int[] value = new int[n+1];
		dp = new int[n+1][c+1];
		/** 背包重量和价值初始化*/
		for(int i = 1; i <= n; i++) {
			weight[i] = cin.nextInt();
			value[i] = cin.nextInt();
		}
		int sum = KnapSack(n, c, weight, value);
		for (int[] temp : dp) {
			for (int temp2 : temp) {
				System.out.printf("%d\t", temp2);
			}
			System.out.println();
		}

		System.out.print(sum);
	}

}
