package com.java.POJ;

import java.util.Scanner;

/**
 * POJ 2739
 * 连续质数和
 */
public class SumOfConsecutivePrimeNumbers {

	public static final int MAX = 10000;
	public static int[] prime = new int[MAX];
	public static Scanner cin = new Scanner(System.in);
	
	public static int count  = 0;
	
	public static int[] primeSet(int[] temp) {
		for(int i = 2; i < MAX; i++) {
			if(isPrime(i) == true) { // 为素数
				temp[count++] = i;
			}
		}
		return temp;
		
	}
	public static boolean isPrime(Integer x) {
		if(x == 1 || x == 4) {
			return false;
		} 
			
        for (int i = 2; i * i <= x; i++)
            if (x % i == 0)
                return false;
        
        return true;


	}
	
	public static void main(String[] args) {
		primeSet(prime);

//		for(int i = 0; i <count; i++) {
//			System.out.print(prime[i] + " ");
//		}
		while(true) {
			int k = cin.nextInt();
			int sum = 0;
			if(k == 0) {
				break;
			}
			int thismax = 0;

			int j = 0;
			for( j = 0; j < count; j++) {
				int i = 0;
				for(i = j; i < count; i++) {
					thismax += prime[i];
					if(thismax > k)
						break;
					else if(thismax == k) {
						sum++;
						break;
					}	
				}	
				thismax = 0;
			}
			System.out.println(sum);
			
		}
	}

}
