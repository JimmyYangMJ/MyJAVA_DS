package com.java.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;


public class Test_BigDecimal {

	public static void myBigDecimal(){
		Scanner cin =new Scanner(System.in);
		int n = cin.nextInt();
		for(int i = 0; i < n; i++) {

			String name = cin.next();	
			
			BigDecimal grade1 = new BigDecimal(cin.next());
			BigDecimal grade2 = new BigDecimal(cin.next());
			BigDecimal grade3 = new BigDecimal(cin.next());
			BigDecimal sum = grade1.add(grade2).subtract(grade3);
			System.out.print(name+" ");
			String g = String.format("%.2f",sum);
			System.out.println(g);
			/** 赋初值*/
			BigDecimal a = BigDecimal.valueOf(1.2);
			System.out.println(a);
		}
	}
	
	public static void myBigInteger() {
		BigInteger n = BigInteger.valueOf(456);
		System.out.print(n);
	}
	public static void main(String[] args) {
		
		//myBigDecimal();
		myBigInteger();
	}

}
