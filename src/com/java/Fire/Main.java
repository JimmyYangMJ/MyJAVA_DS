package com.java.Fire;

import java.io.*;

public class Main{
	
	public static void fireAttribute() {
		File file = new File("image/score.txt");
		// 没有import 使用java.io.File
        System.out.println("Does it exit? " + file.exists());
        System.out.println("file has " + file.length() + " bytes");
        System.out.println("Can it be read? "+file.canRead());
        System.out.println("Can it be written?" +file.canWrite());
        System.out.println("is it a directory?" + file.isDirectory());
        System.out.println("is it a file?"+file.isFile());
        System.out.println("is it absolute? "+file.isAbsolute());
        System.out.println("is it hidden? "+file.isHidden());
        System.out.println("Absolute path is "+file.getAbsolutePath());
        System.out.println("last modified on " + new java.util.Date(file.lastModified()));//返回最后修改的日期和时间
	}
	
	public static void main(String[] args){
		fireAttribute(); 
	}
}
