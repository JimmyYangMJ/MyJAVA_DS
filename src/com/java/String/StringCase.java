package com.java.String;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class StringCase {
	
	
	public static void mySubString() {
		String a = "6589320";
		System.out.println(a.substring(3));  // 9320
		System.out.println(a.subSequence(2, 5));  // 893
		System.out.println(a.substring(2, 5));  // 893
	}
	
	/*
	 * String.spit
	 */
	public static void mySpit() {
		String aa = "as+we+asd+ew+dfg+ret";
		String []bb = aa.split("\\+", 3); // 以+为分割符， 限制三个数组
		for (String temp: bb) {
			System.out.printf("bb: %s\n", temp);
		}
		
	}

	/**
	 * 字符串连接
	 */
	public static void myJoin() {
		String name = String.join("+", "a", "asd","dfr");
		System.out.println(name);
		
		
		List<String> strings = new LinkedList<>();
	    strings.add("Java");strings.add("is");
	    strings.add("cool");
	    String message = String.join(" ", strings);
	    //message returned is: "Java is cool"
	
	    Set<String> strings2 = new LinkedHashSet<>();
	    strings2.add("Java"); strings2.add("is");
	    strings2.add("very"); strings2.add("cool");
	    String message2 = String.join("-", strings);
	    //message returned is: "Java-is-very-cool"
	    
	    StringBuilder builder = new StringBuilder();
	    builder.append(name);
	    System.out.println(builder);
	    
	}
	
	public static void main(String[] arg) {
		
		//mySubString();
		//mySpit();
		myJoin();
		int a = 6;
		String.format("%d",a);
		String num = String.valueOf(20);

	}
}
