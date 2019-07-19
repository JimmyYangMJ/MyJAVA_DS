package com.java.JCF.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class Coin {
	private HashMap<Integer, String> coinnames = new HashMap<Integer, String>();
			//Integer 是int 的包裹类型
	public Coin() {
		coinnames.put(1, "penny"); // 钱的英文名称
		coinnames.put(10, "dime");
		coinnames.put(25, "quarter");
		coinnames.put(50, "harf-dolar");
		
		System.out.println("容器内个数："+coinnames.keySet().size());//容器内个数
		System.out.println(coinnames);
		for( Integer k : coinnames.keySet() ) {
			String s = coinnames.get(k);
			System.out.println(s);
		}
	}
	public String getName(int amount) {
		if(coinnames.containsKey(amount))
			return coinnames.get(amount);
		else
			return "NO Found";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int amount = in.nextInt(); 
		Coin coin = new Coin();
		System.out.println("*******");
		String name = coin.getName(amount); 
		System.out.println(name);
		in.close();//
	}

}
