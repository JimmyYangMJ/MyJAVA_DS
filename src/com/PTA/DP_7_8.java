package com.PTA;

import java.util.Scanner;
import java.util.Stack;

/**
 * 7-8 数字三角形 (20 分)
 * https://pintia.cn/problem-sets/1150412808244031488/problems/1150415053572403200
 *
 */
public class DP_7_8 {

	public static Scanner cin = new Scanner(System.in);

	public static int n;
	public static int[][] t;
	
	private static int max(int a, int b) {
		return a > b? a: b;
	} 
	
	public static void main(String[] args) {
		
		n = cin.nextInt();
		t = new int[n+1][];
		for(int i = 1; i <= n; i++) {
			t[i] = new int[i+1];
			for(int j = 1; j <= i; j++) {
				t[i][j] = cin.nextInt();
			}
		}

		for(int j = n-1; j > 0; j--) {
			for(int i = 1; i <= j; i++) {
				t[j][i] += max(t[j+1][i], t[j+1][i+1]);
			}
		}
		System.out.print(t[1][1]);
	}

}
