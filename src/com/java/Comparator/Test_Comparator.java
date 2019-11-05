package com.java.Comparator;

import java.util.Arrays;

import java.util.Comparator;

class MyComparator2 implements Comparator<String>{
	@Override
    public int compare(String  o1, String  o2) {
        return o1.compareTo(o2); 
    }
}
/*
 * 使用泛型
 */
class MyComparator1 < T extends Comparable<T> > implements Comparator<T>{
	@Override
    public int compare(T  o1, T  o2) {
        return o1.compareTo(o2); 
    }
}
public class Test_Comparator {
	
	public static void sortComparator() {
		String[] s = {"aaa", "eee", "ddd"};

		Comparator<String> cmp = new MyComparator2(); 
		// Comparator<String> cmp = new MyComparator2(); // 会有警告
		Arrays.sort(s, cmp);
		for(String n:s) {
			System.out.println(n);
		}
	}
	public static void main(String[] args){
		
		sortComparator();
	}
}