package com.java.Number;

public class IntegerTest {

	/** �����ı�ʾ*/
	public static void test(){
		short a1 = 32767;
		System.out.println(a1);
		//short a2 = 32768;  error Խ��

		int b1 = 2147483647;
		System.out.println(b1);
		//int b2 = 2147483648; error Խ��

		long c1 = 1000000000000L;
		System.out.println(c1);

		long c2 = 2147483647;  //��ʽ���˴�int���long�Ĳ���
		System.out.println(c2);

		long c3 = 2147483648L; //ȥ��L������
		System.out.println(c3);
	}

	public static void integer(){
		Integer i = 19;
	}

	public static void main(String[] args) {



	}
}
