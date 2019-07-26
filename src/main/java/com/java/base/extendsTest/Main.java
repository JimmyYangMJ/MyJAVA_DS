package com.java.base.extendsTest;

public class Main {

	public static void main(String[] args) {
		
		  People p = new People();
		  xiaoming x=new xiaoming();


		System.out.println(p instanceof Person);
		System.out.println(p instanceof xiaoming);
		System.out.println(x instanceof Person);
		System.out.println(x instanceof People);
	}

}
