package com.acm.csp.csp2019_6;// INFO BEGIN
//
// User = 201910005304(杨明杰) 
// Group = JAVA 
// Problem = 城市规划 
// Language = JAVA 
// SubmitTime = 2019-09-15 15:23:20 
//
// INFO END

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {

	static Scanner cin = new Scanner(System.in);
	
	static int[][] G;
	static int n;
	static int m, k;
	static int[] M;
	static final int MAX = 100007;
	
	static void build(){
		n = cin.nextInt();
		m = cin.nextInt();
		k = cin.nextInt();
		M = new int[m];
		for(int i = 0; i < m ;i++){
			M[i] = cin.nextInt();
		}
		G = new int[n+1][n+1];
		for(int i = 0; i <= n; i++){
			Arrays.fill(G[i], MAX);
		}
		for(int i = 0; i < n-1; i++){
			int a = cin.nextInt();
			int b = cin.nextInt();
			int sum = cin.nextInt();
			G[a][b] = sum;
			G[b][a] = sum;
		}
		
	}
	static void floyd() {
		
		for(int k = 1; k <= n; k++){
			for(int i = 1; i <= n; i++){
				for(int j = 1; j <= n; j++){
					if(G[i][k] + G[k][j] < G[i][j] && i!= k){
						 G[i][j] = G[i][k] + G[k][j];
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		build();
		floyd();
		
		int min = MAX;
		for(int i = 0; i < m ; i++){
			for(int j = 0; j < m;j++){
				if(G[ M[i] ][ M[j]] < min && i != j){
					min = G[ M[i] ][ M[j]];
				}
			}
		}
		System.out.print(min);

	}


}
