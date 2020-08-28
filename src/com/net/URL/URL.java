package com.net.URL;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;


public class URL {



    static final String URL = "http://10.1.30.207:50045/monitor/pollutedsign/searchPage?userId=1&startTime=2020-06-28+00%3A00%3A00&endTime=2020-07-28+23%3A59%3A59&collId=&stationName=";




   public static void main(String[] args) {


         try {
             String urlTypeName = URLEncoder.encode("杨家浜","ISO-8859-1");
             String urlName = URL + urlTypeName + "&pollutedTypeIds=&groupIds=186%2C188%2C187%2C189&page=1&rows=10";

             java.net.URL url = new java.net.URL(urlName);
             URLConnection connection = url.openConnection();
             connection.connect();

             BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "ISO-8859-1"));

             // 输出收到的内容
             StringBuffer stringBuffer = new StringBuffer();
             String line = "";
             while((line = br.readLine()) != null) {
                 stringBuffer.append(line);
             }
             System.out.println(stringBuffer.toString());
             br.close();
         } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
         } catch (MalformedURLException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
   }
}
