package com.acm.csp.csp2019_6;// INFO BEGIN
//
// User = 201910005304(杨明杰) 
// Group = JAVA 
// Problem = 小明种苹果（续） 
// Language = JAVA 
// SubmitTime = 2019-09-15 14:43:56 
//
// INFO END

import java.util.Scanner;

public class Main2 {

	static Scanner cin = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n;
		// 所有苹果
		int sum = 0;
		n = cin.nextInt();
		// 当前的
		int[] N = new int[n];
		boolean[] b = new boolean[n];
		for (int i = 0; i < n; i++){
			int m = 0;
			m = cin.nextInt();
			for(int j = 0; j < m; j++){
				int temp = 0;
				temp = cin.nextInt();
				if(j == 0){
					N[i] = temp;
				}else{
					if(temp <= 0){
						N[i] = N[i] + temp;
					}else{
						if(N[i] != temp){ // 有果实掉落
							b[i] = true;
						}
						N[i] = temp;
					}
				}
			}

		}
		
		int count = 0;
		
		for(int j = 0; j < n; j++){
			sum += N[j];
			if(b[j] == true){
				count ++;
			}
		}
		int E = 0;
		int index = -1;;
		for(int j = 0; j < n; j++){
			if(b[j] == false){
				index = j;
				break;
			}
		}
		int k = 0;
		if(n < 3){
			E = 0;
		}else if(index < 0){
			E = n;
		}else{
			for(int i = 0; i < n; i++){
				index = (index)%(n);
				if(b[index] == true){
					k++;
				}else{
					k = 0;
					index++;
					continue;
				}
				if(k >= 3){
					E++;
				}
				index++;
			}			
		}

		
		System.out.print(sum + " " + count + " " + E);

	}

}
