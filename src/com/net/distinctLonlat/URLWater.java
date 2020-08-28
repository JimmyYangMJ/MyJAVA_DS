package com.net.distinctLonlat;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;


public class URLWater {



    static final String URL = "http://10.1.30.207:50045/monitor/pollutedsign/searchPage?userId=1&startTime=2020-06-28+00%3A00%3A00&endTime=2020-07-28+23%3A59%3A59&collId=&stationName=";


    static List<String> list = new LinkedList();
    /**
     * 读文件
     */
    public static void ReadFile1() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream("C:/Users/dell/Desktop/data.txt"); // 节点类
            isr = new InputStreamReader(fis, "UTF-8"); // 转化类
            br = new BufferedReader(isr); // 装饰类

            String line;
            while ((line = br.readLine()) != null) {  // 每次读取一行
//                System.out.println(line);
                list.add(line);
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
   public static void main(String[] args) {

       //ReadFile1();
       list.add("杨家浜");
       System.out.println(list.size());
       int count = 0;
         try {
             for (String temp: list) {
                 String urlName = URL + temp + "&pollutedTypeIds=&groupIds=&page=1&rows=10";

                 java.net.URL url = new java.net.URL(urlName);
                 URLConnection connection = url.openConnection();
//            connection.addRequestProperty("Cookie", "JSESSIONID=071D56FE7890F1349164A3228BACC3EF");
                 connection.connect();

                 BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

                 // 输出收到的内容
                 StringBuffer stringBuffer = new StringBuffer();
                 String line = "";
                 while((line = br.readLine()) != null) {
                     stringBuffer.append(line);
                 }
                 System.out.println(stringBuffer.toString());
                 if (stringBuffer.toString().equals("{\"total\":0,\"rows\":[]}")) {
                     count ++;
                     System.out.print("*");
                     if (count % 100 == 0) {
                         System.out.println();
                     }
                 }

                 br.close();
             }
             System.out.println(count);
         } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
         } catch (MalformedURLException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
   }
}
