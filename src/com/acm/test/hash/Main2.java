package com.acm.test.hash;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 臭味相投
 * 算法： 散列 /并查集
 */
public class Main2 {
	static Scanner cin = new Scanner(System.in);
	
	// set 表示集合
	static int[] set;
	
	public static void main(String[] args) {
		int N = cin.nextInt();
		int M = cin.nextInt();
		// 记录每个人所处的集合 index = 1
		int[] people = new int[N+1];
		set = new int[M];
		
		Arrays.fill(set, -1);
		for (int i = 1; i <= N; i++) {
			people[i] = cin.nextInt();
			set[people[i]]++;  // 所在集合的人数 +1
		}
		// 遍历所有人所在集合的人数（除了自己之外）
		for(int i = 1; i <= N; i++) {
			if(set[people[i]] <= 0) {
				System.out.println("BeiJu");
			}else {
				System.out.println(set[people[i]]);
			}
			
		}

	}

}
