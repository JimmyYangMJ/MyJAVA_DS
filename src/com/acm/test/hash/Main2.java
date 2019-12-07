package com.acm.test.hash;

import java.util.Arrays;
import java.util.Scanner;
/**
 * ��ζ��Ͷ
 * �㷨�� ɢ�� /���鼯
 */
public class Main2 {
	static Scanner cin = new Scanner(System.in);
	
	// set ��ʾ����
	static int[] set;
	
	public static void main(String[] args) {
		int N = cin.nextInt();
		int M = cin.nextInt();
		// ��¼ÿ���������ļ��� index = 1
		int[] people = new int[N+1];
		set = new int[M];
		
		Arrays.fill(set, -1);
		for (int i = 1; i <= N; i++) {
			people[i] = cin.nextInt();
			set[people[i]]++;  // ���ڼ��ϵ����� +1
		}
		// �������������ڼ��ϵ������������Լ�֮�⣩
		for(int i = 1; i <= N; i++) {
			if(set[people[i]] <= 0) {
				System.out.println("BeiJu");
			}else {
				System.out.println(set[people[i]]);
			}
			
		}

	}

}
