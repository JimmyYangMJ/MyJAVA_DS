package com.java.base;

import java.util.Date; //时间函数
//import java.util.Date;
import java.util.regex.Pattern;  //正则表达式
import java.io.*; //使用 BufferedReader 在控制台读取字符

public class Text02 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		    
/****创建格式化字符串****/
		//String 类的静态方法 format() 能用来创建可复用的格式化字符串，
		//而不仅仅是用于一次打印输出。
		double floatVar = 1.5;
		int intVar = 6;
		String stringVar = "Hello";
		String fs; 
		fs = String.format("浮点型变量的值为 " + "%f, "
				+ "整型变量的值为 " + 
				" %d, 字符串变量的值为 " + " %s", 
				floatVar, intVar, stringVar);
		System.out.println(fs);
/****Java StringBuffer 和 StringBuilder 类****/
	    StringBuffer sBuffer = new StringBuffer("网页");
	    sBuffer.append("www");
	    sBuffer.append(".baidu");
	    sBuffer.append(".com");
	    System.out.println(sBuffer);  
	    //StringBuilder 的方法不是线程安全的（不能同步访问） 但速度更快
//	    public StringBuffer reverse()
//	    public StringBuffer append(String s)
	    sBuffer.reverse();
	    System.out.println(sBuffer);
/****Java 日期****/
		// 初始化 Date 对象
	    Date date = new Date();
	    // 使用 toString() 函数显示日期时间
	    System.out.println(date.toString());
	    System.out.println(date.toString().substring(0,3)+ " "+date.toString().substring(8,10)+ "号"+date.toString().substring(11,16)  );
	    System.out.printf("全部日期和时间信息：%tc%n",date);           
	    System.out.printf("年-月-日格式：%tF%n",date);    //f的使用       
	    System.out.printf("月/日/年格式：%tD%n",date);   //d的使用
	    System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);//r的使用     
	    System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);  //t的使用 
	    String a ;
	    a = String.format("%tT%n",date);
	    System.out.println(a);
	    System.out.printf("HH:MM格式（24时制）：%tR",date);  //R的使用
/*** 正则表达式 ***/
	    String content = "I am noob " + "from runoob.com.";
	    String pattern = ".*runoob.*";
	    boolean isMatch = Pattern.matches(pattern, content);
	    System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
/*** 使用 BufferedReader 在控制台读取字符 ***/
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.print(c+" ");
        } while (c != 'q');
        
	}

}
