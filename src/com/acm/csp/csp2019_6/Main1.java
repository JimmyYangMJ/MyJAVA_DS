package com.acm.csp.csp2019_6;// INFO BEGIN
//
// User = 201910005304(杨明杰) 
// Group = JAVA 
// Problem = 小明种苹果 
// Language = JAVA 
// SubmitTime = 2019-09-15 13:53:37 
//
// INFO END

import java.util.Scanner;

public class Main1
{
	static Scanner cin = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int n, m;
		int answer = 0;
		n = cin.nextInt();
		m = cin.nextInt();
		int[] N = new int[n];
		int[] M = new int[m];
		for (int i = 0; i < n; i++){
			int temp = 0;
			temp = cin.nextInt();
			N[i] = temp;
			answer += temp;
			int sum = 0;
			for(int j = 0; j < m; j++){
				temp = cin.nextInt();
				answer += temp;
				sum += temp;
			}
			M[i] = sum;
		}
		
		int min = 1;
		int index = 0;
		for(int i = 0; i < n; i++){
			if(M[i] < min){
				index = i;
				min = M[i];
			}
		}
		min = min *(-1);
		index++;
		System.out.print(answer +" " + index + " " + min);
	}
}