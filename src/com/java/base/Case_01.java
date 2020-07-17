package com.java.base;

import java.util.Random;

public strictfp class Case_01 {
	
	//strictfp 严格浮点数运算，不依赖于机器
	public static void main(String[] arg) {
		
		
		Random generator = new Random();
		System.out.println(generator.nextDouble());
		System.out.println(generator.nextInt(10));
		System.out.println(Math.random());
		System.out.println(1000_0000);
		System.out.println(Integer.toUnsignedString(23113));
		if(Double.isNaN(0.0/0.0)) {
			System.out.println('\u263A' + "6666");
		}
		System.out.println(Double.POSITIVE_INFINITY);
		System.out.println(System.out);
		System.out.println(Math.max(5, 6));
		System.out.println(StrictMath.max(6, 7)); 
		System.out.println((char)(75));
		System.out.println(Math.toIntExact(456321L));  // 无法从long 转为int 会报异常
		
		System.out.printf("%,+.2f", -30D);  // 正数会显示+号
		
		int i = 0;
		outer:
			while(i == 0) {
				while(true) {
					if(i == 0) {
						i = 1;
						break outer;
					}
						
				}
				//System.out.println("5687"); 
			}
		
	}
}
