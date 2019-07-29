package com.java.base.extendsTest;

public class People implements Person {
		private int a=0;
		@Override
		public void eat() {
			System.out.println("======"+a);
			//System.out.println(Person.aa);
		}

}