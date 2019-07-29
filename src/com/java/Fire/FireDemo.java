package com.java.Fire;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FireDemo {

	/** 文件根目录*/
	static final String ROOT_DIRECTORY = "D:/IDEA-workspace/MyJAVA_DS/myfile";
	/**
	 * 创建文件夹
	 */
	public static void MKdir() {
		String path = ROOT_DIRECTORY;
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();  //创建文件夹 ； mkdir 创建单级目录  mkdirs 连续创建多级目录
			if(file.exists()) {
				System.out.println("文件夹创建成功");
			}else {
				System.out.println("文件夹创建失败");
			}
			//d.delete();  //删除文件夹
		}else {
			System.out.println("文件夹已经存在");
		}
	}
	
	/**
	 * 在根目录下 创建文件
	 */
	public static void MKfire() {
		//创建文件
	    File f = new File(ROOT_DIRECTORY + "/abc.txt");
	    if(!f.exists()){
	      try
	      {
	        f.createNewFile(); //创建abc.txt
	      }
	      catch(IOException e){ //可能会因为权限不足或磁盘已满报错
	    	  e.printStackTrace();
	      }
	    }
	}
	 
	/**
	 * 写入文件
	 */
	public static void WriteFire() {
		//字节流形式
		FileOutputStream fos = null;  //文件输出流
		OutputStreamWriter osw = null; //
		BufferedWriter bw = null;
		try {
			fos = new FileOutputStream
					(ROOT_DIRECTORY + "/abc.txt"); // 节点类
			osw = new OutputStreamWriter(fos, "UTF-8"); // 转化类
			bw = new BufferedWriter(osw); // 装饰类  让操作更快
			bw.write("java程序设计  \n 666");
			bw.newLine();
			bw.write("学生：杨明杰");
			bw.newLine();
			/**
			 * 【{（节点类）-转化类}-装饰类】
			 * 缓存 - 转化 - 输出
			 */
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				bw.close(); // 关闭最后一个类，会将所有的底层流都关闭
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void WriteFire2() {
		//try-resource 语句，自动关闭资源
		//JDK 7及以上才可以使用
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:/temp/abc.txt")))) {
			bw.write("我们是");
			bw.newLine();
			bw.write("Ecnuers.^^");
			bw.newLine();
		} catch (Exception ex) {
			ex.printStackTrace();
			//不需要 bw.close();
		}
	}
	
	/**
	 * 读文件
	 */
	public static void ReadFile1() {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(ROOT_DIRECTORY + "/abc.txt"); // 节点类
			isr = new InputStreamReader(fis, "UTF-8"); // 转化类
			br = new BufferedReader(isr); // 装饰类
			
			String line;
			while ((line = br.readLine()) != null) {  // 每次读取一行
				System.out.println(line);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				br.close(); // 关闭最后一个类，会将所有的底层流都关闭
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void ReadFile2() {
		String line;
		//try-resource 语句，自动关闭资源
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("c:/temp/abc.txt")))) {
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MKdir();
		MKfire();
		WriteFire();
		ReadFile1();
	}

}
