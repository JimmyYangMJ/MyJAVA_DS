package com.java.POJ;

import java.util.Scanner;

public class KnapSack_01 {

	public static Scanner cin = new Scanner(System.in);
	/** ������ֵ*/
	public static int[][] dp ; 
	
	private static int max(int a, int b) {
		return a > b? a: b;
	} 
	
	public static int KnapSack(int n, int c, int w[], int v[]) {
		
		//���,���е�0�к͵�0��ȫΪ0 , ��ʾû��װ����
	    for(int i = 0; i <= n; i++)  // ��Ʒ�� 
	        dp[i][0]=0;
	    for(int j = 0; j <= c; j++)  // ���� 
	        dp[0][j]=0;
	    
		for(int i = 1; i <=n; i++) { // װ��Ʒ��
			
			for(int j = 1; j <= c; j++) { // ����
				if(j < w[i]) {  // ����װ���� ��Ʒi
					dp[i][j] = dp[i-1][j]; // ������һ�εĽ��
				}else {  /** ��ǰ����װ����*/
					/** װ�˵�ǰ��Ʒǰ��������ֵ  + ��ǰ��Ʒ��ֵ*/
					int last = dp[i-1][j-w[i]] + v[i];
					/** �Ƚ� ����װ��ǰ��Ʒ  & + װ��ǰ��Ʒ��ֵ��*/
					dp[i][j] = max(dp[i-1][j], last);
				}
			}
		}
		return dp[n][c];
	}
	
	public static void main(String[] args) {
		
		/** n����Ʒ*/
		int n = cin.nextInt(); 
		/** �������� */
		int c= cin.nextInt();
		
		int[] weight = new int[n+1];
		int[] value = new int[n+1];
		dp = new int[n+1][c+1];
		/** ���������ͼ�ֵ��ʼ��*/
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
