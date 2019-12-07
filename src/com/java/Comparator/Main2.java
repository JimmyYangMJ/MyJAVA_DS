package com.java.Comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 小白鼠排序问题
 * @author dell
 *
 */
public class Main2 {
	static Scanner cin = new Scanner(System.in);
	
	static class Animal implements Comparable<Animal>{
		int weight = 0;
		String nameString = null;
		public Animal(int weight, String name) {
			this.weight = weight;
			this.nameString = name;
		}
		public Animal() {
		}
		@Override
		public int compareTo(Animal o) {
			return o.weight-this.weight;
		}
	}
	
	public static void main(String[] args) {
		while (cin.hasNext()) {
			int n = 0;
			n = cin.nextInt();
			Animal[] animals = new Animal[n];
 			for (int i = 0; i < animals.length; i++) {
 				int w = cin.nextInt();
 				String name = cin.next();
				animals[i] = new Animal(w, name);
			}
 			/** 第一种方式 通过实现Comparable 接口， 重写compareTo 方法*/
 			Arrays.sort(animals);
 			/** 第二种方式 */
 			Arrays.sort(animals, new Comparator<Animal>() {
				@Override
				public int compare(Animal o1, Animal o2) {
					// TODO Auto-generated method stub
					return o2.weight - o1.weight;
				}
			});
			for (Animal animal : animals) {
				System.out.println(animal.nameString);
			}
		}


	}

}
