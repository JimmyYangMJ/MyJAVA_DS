package com.java.base;

import java.util.Date; //ʱ�亯��
//import java.util.Date;
import java.util.regex.Pattern;  //������ʽ
import java.io.*; //ʹ�� BufferedReader �ڿ���̨��ȡ�ַ�

public class Text02 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		    
/****������ʽ���ַ���****/
		//String ��ľ�̬���� format() �����������ɸ��õĸ�ʽ���ַ�����
		//��������������һ�δ�ӡ�����
		double floatVar = 1.5;
		int intVar = 6;
		String stringVar = "Hello";
		String fs; 
		fs = String.format("�����ͱ�����ֵΪ " + "%f, "
				+ "���ͱ�����ֵΪ " + 
				" %d, �ַ���������ֵΪ " + " %s", 
				floatVar, intVar, stringVar);
		System.out.println(fs);
/****Java StringBuffer �� StringBuilder ��****/
	    StringBuffer sBuffer = new StringBuffer("��ҳ");
	    sBuffer.append("www");
	    sBuffer.append(".baidu");
	    sBuffer.append(".com");
	    System.out.println(sBuffer);  
	    //StringBuilder �ķ��������̰߳�ȫ�ģ�����ͬ�����ʣ� ���ٶȸ���
//	    public StringBuffer reverse()
//	    public StringBuffer append(String s)
	    sBuffer.reverse();
	    System.out.println(sBuffer);
/****Java ����****/
		// ��ʼ�� Date ����
	    Date date = new Date();
	    // ʹ�� toString() ������ʾ����ʱ��
	    System.out.println(date.toString());
	    System.out.println(date.toString().substring(0,3)+ " "+date.toString().substring(8,10)+ "��"+date.toString().substring(11,16)  );
	    System.out.printf("ȫ�����ں�ʱ����Ϣ��%tc%n",date);           
	    System.out.printf("��-��-�ո�ʽ��%tF%n",date);    //f��ʹ��       
	    System.out.printf("��/��/���ʽ��%tD%n",date);   //d��ʹ��
	    System.out.printf("HH:MM:SS PM��ʽ��12ʱ�ƣ���%tr%n",date);//r��ʹ��     
	    System.out.printf("HH:MM:SS��ʽ��24ʱ�ƣ���%tT%n",date);  //t��ʹ�� 
	    String a ;
	    a = String.format("%tT%n",date);
	    System.out.println(a);
	    System.out.printf("HH:MM��ʽ��24ʱ�ƣ���%tR",date);  //R��ʹ��
/*** ������ʽ ***/
	    String content = "I am noob " + "from runoob.com.";
	    String pattern = ".*runoob.*";
	    boolean isMatch = Pattern.matches(pattern, content);
	    System.out.println("�ַ������Ƿ������ 'runoob' ���ַ���? " + isMatch);
/*** ʹ�� BufferedReader �ڿ���̨��ȡ�ַ� ***/
        char c;
        // ʹ�� System.in ���� BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("�����ַ�, ���� 'q' ���˳���");
        // ��ȡ�ַ�
        do {
            c = (char) br.read();
            System.out.print(c+" ");
        } while (c != 'q');
        
	}

}
