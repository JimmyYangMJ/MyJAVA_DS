package com.java.JCF.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
	
	/**
	 * 数组反转，用于反转包装类型 如Integer
	 */
	public static void arrayReverse() {
		int number = input.nextInt();
		Integer[] a = new Integer[number];
		for(int i = 0; i < number; i++) {
			a[i] = input.nextInt();
		}
		Collections.reverse(Arrays.asList(a));
		// Arrays.asList(a) 将数组转换为list
		for(int i = 0; i < number; i++) {
			System.out.print(a[i]);
			if(i+1 != number)
				System.out.print(" ");
		}
	}
	
	
	public static void arraycopy() {
		int[] a = {1,2,3,4};
		int[] aCopy = Arrays.copyOf(a, a.length);
		for(int temp:aCopy) {
			System.out.print(temp + " ");
		}
	}
	
	public static void main(String[] args) {
		//arrayReverse(); // 数组反转
		arraycopy(); // 数组复制
	}
}