package com.java.String;

public class StringBufferReferenceTest {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("123");
		StringBuffer sb2 = sb1;
		
		sb1.append("12345678901234567890123456789012");
		System.out.println(sb2);  //sb1 �� sb2����ָ��ͬһ���ڴ��

		StringBuffer s = new StringBuffer();
		System.out.println(s.capacity());
		s.append("dfa sdf  gs      a");
		s.trimToSize();
		System.out.println(s.capacity());
	}

}
