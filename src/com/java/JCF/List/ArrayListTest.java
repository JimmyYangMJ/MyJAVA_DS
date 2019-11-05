package com.java.JCF.List;

import java.lang.reflect.Array;
import java.util.*;

//Vector 几乎和ArrayList一样，除了Vector本身是同步的

/**
 * ArrayList<Integer> al = new ArrayList<>(); <br>
 * 使用下标索引 比迭代器Iterator更快  <br>
 * 下标从0开始
 */
public class ArrayListTest {

	public static void main(String[] a) {  
	    ArrayList<Integer> al = new ArrayList<Integer>();
		/** 第一个位置没有赋值，不能给第二个位置赋值 */
		// al.add(1, 3);  (错误)
        al.add(3);
        al.add(7);
        al.add(2); // 在数组末尾添加元素
	    al.add(new Integer(6));


        System.out.print("The third element is  ");
	    System.out.println(al.get(2));
	    al.remove(2);  //删除第3个元素，后面元素往前挪动
	    al.add(3, 9);  //将9插入到第4个元素，后面元素往后挪动

	    System.out.println("======遍历方法=============");
	    
	    ArrayList<Integer> as = new ArrayList<Integer>(100000);
	    for (int i=0; i<100000; i++)
	    {
	    	as.add(i);
	    }
	    traverseByIterator(as);
	    traverseByIndex(as);
	    traverseByFor(as);    
	}

	/**
	 * 迭代器索引 性能较慢
	 * @param al ArrayList<Integer>
	 */
	public static void traverseByIterator(ArrayList<Integer> al)
	{
		long startTime = System.nanoTime();
		System.out.println("============迭代器遍历=============="); 
	    Iterator<Integer> iter1 = al.iterator();  
	    while(iter1.hasNext()){  
	        iter1.next();  
	    }
		long endTime = System.nanoTime();
	    long duration = endTime - startTime;
	    System.out.println(duration + "纳秒");
	}

	/**
	 * 下标索引
	 * @param al ArrayList<Integer>
	 */
	public static void traverseByIndex(ArrayList<Integer> al)
	{
		long startTime = System.nanoTime();
		System.out.println("============随机索引值遍历=============="); 
	    for(int i=0;i<al.size();i++)
	    {
	    	al.get(i);
	    }
		long endTime = System.nanoTime();
	    long duration = endTime - startTime;
	    System.out.println(duration + "纳秒");
	}

	/**
	 * for each 循环遍历
	 * @param al ArrayList<Integer>
	 */
	public static void traverseByFor(ArrayList<Integer> al)
	{
		long startTime = System.nanoTime();
		System.out.println("============for循环遍历=============="); 
	    for(Integer item : al)
	    {
	    	;
	    }
		long endTime = System.nanoTime();
	    long duration = endTime - startTime;
	    System.out.println(duration + "纳秒");
	}
}
