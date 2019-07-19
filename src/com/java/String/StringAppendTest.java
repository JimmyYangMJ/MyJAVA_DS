package com.java.String;

import java.util.Calendar;

public class StringAppendTest {

	public static void main(String[] args) {
		
		int n = 50000;
		Calendar t1 = Calendar.getInstance();
		String a = new String();
		for(int i=0;i<n;i++)
		{
			a = a + i + ",";
		}
		System.out.print("时间：");
		System.out.println(Calendar.getInstance().getTimeInMillis() - t1.getTimeInMillis());

		/** StringBuffer 同步（线程安全）性能好*/
		Calendar t2 = Calendar.getInstance();
		StringBuffer b = new StringBuffer("");
		for(int i=0;i<n;i++)
		{
			b.append(i);
			b.append(",");
		}
		System.out.print("时间：");
		System.out.println(Calendar.getInstance().getTimeInMillis() - t2.getTimeInMillis());

		/** StringBuild 不同步（性能比Buffer更好）*/
		Calendar t3 = Calendar.getInstance();
		StringBuilder c = new StringBuilder("");
		for(int i=0;i<n;i++)
		{
			b.append(i);
			b.append(",");
		}
		System.out.println(Calendar.getInstance().getTimeInMillis() - t3.getTimeInMillis());		
	}
}
