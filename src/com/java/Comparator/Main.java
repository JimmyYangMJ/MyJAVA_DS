package com.java.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class Information{
	private String name = null;
	private String birthday = null;
	private String tel = null;

	public String getName() {
		return name;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getTel() {
		return tel;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	
}
public class Main {

	static Scanner cin =new Scanner(System.in);
	public static void main(String[] args) {
		int num = cin.nextInt();

		Information[] Students = new Information[num]; //
		ArrayList<Information> list = new ArrayList<Information>();
		String temp ;
		for(int i = 0; i < num; i++) {
			temp = cin.next();
			Students[i] = new Information();
			Students[i].setName(temp);
			temp = cin.next();
			Students[i].setBirthday(temp);
			temp = cin.next();
			Students[i].setTel(temp);
			list.add(Students[i]);
		}
		Collections.sort(list,new Comparator<Information>() {  // 匿名内部类
            @Override
            public int compare(Information o1, Information o2) {
                return Integer.parseInt(o1.getBirthday())- Integer.parseInt(o2.getBirthday()); 
            }
        });
		for (Information student : list) {
        	System.out.printf("%s %s %s\n", student.getName(),student.getBirthday(),student.getTel());
        }
		
	}


}
