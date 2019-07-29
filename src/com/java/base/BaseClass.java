package com.java.base;

import java.util.Scanner;

public class BaseClass {
	public static void Function01(int i) {   //函数
		System.out.println("调用函数01 "); //输出
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Word"); //输出

/*****调用函数*****/
		Function01(10);  //调用函数
/**************************************/
		Scanner input = new Scanner(System.in);  //only one: input
		System.out.println("你的输出:"+input.nextLine());  //输出
/**************************************/
		int price;
		price = input.nextInt();
		System.out.println("price = "+price);  //输出
/**************************************/
		int count = 20;
		double prices = 0;
		prices =input.nextDouble();
//		char ch = 'a'; //char ch; Unicode码表中
		boolean flag = true;
/*****包裹类型*****/
//		Character ch1;
		System.out.println(Character.toLowerCase('I')); //转换为小写字母
		/*****Math函数*****/
		System.out.println(Math.pow(2, 3)); //2的3次方
		System.out.println(Math.random()*50);  //随机数函数

		Integer x = 5;
		System.out.println(x.toString());
		System.out.println(Integer.toString(12));
/*****String字符串*****/
		String ss; // 字符串型 String是一个类  //String ss2 = "a string";
		ss=input.next();     //输入字符串
		//ss = input.nextLine(); //读一整行
		System.out.println("字符串ss = "+ss+12+25); //输出字符串 //12和25会转换为字符串
		//比较两个字符串
		if(ss == "bye") { //比较是否是同一个字符串
			System.out.println("同一字符串");
		}
		if(ss.equals("bey")) { //比较两个字符串是否一样
			System.out.println("相等字符串");
		}
/*****定义String*****/
		String s = new String("a string");  //字符串 s 是一个管理者
		System.out.println("字符串s = "+s); //输出字符串
/*****String操作*****/
		String s1 = "abc";
		String s2 = "abd";
		System.out.println(s1.compareTo(s2));
		//s1.charAt(2); s1.substring(2); s1.substring(0, 2);
		//都是生成一个新的字符串，原先的字符串的内容不变
/*****定义数组*****/
		int []number = new int [count];
		int []scores = {65,98,65,98};
		int [][]a = new int [3][5];  System.out.println(a[2][1]);
		int [][]b = { {1,2,3} , {2,6} }; System.out.println(b[1][1]);
		char []c = new char[20];  System.out.println(c[0]);
/*****二维数组*****/
		char [][] cc = new char[5][10];
		String[] ss1 = new String[10];

		cc[0] = input.nextLine().toCharArray();
		System.out.println(cc[0]);

		ss1[0] = input.nextLine();
		System.out.println(ss1[0]);
/*****char*****/
		char[] number1 = new char[7];
		for(int i = 0; i< 6; i++ ) {
			number1[i] = input.next().charAt(0);
		}
/*****循环*****/
		//for 循环_01
		for(int k:scores) {   //k不断变化 ，  for each (数组内) 循环  不能修改数组
			if(k == price) {
				flag = false;
			}
		}
		System.out.println("flag结果："+flag);
		//while 循环； do-while循环； for 循环
/*****循环*****/
		System.out.println(prices);

		System.out.println(number1.length+""+scores.length);
		System.out.println(count+"+"+price+"="+(int)(count+price));
		input.close();
		char cs = input.next().charAt(0);

	}

}
