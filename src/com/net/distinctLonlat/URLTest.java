package com.net.distinctLonlat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLConnection;

/**
 * 查询经纬度坐标
 */
public class URLTest {


    static String URL = "http://restapi.amap.com/v3/config/district?key=b0435ec549bd4c391aebe4d36e211689&";
    static String keywords = "keywords=";
    static String pa = "&subdistrict=1&extensions=all";


   static String[] stringStreet = {
           "马鞍山市",
           "花山区",
           "雨山区",
           "博望区",
           "当涂县",
           "含山县",
           "和县"
   };

   public static void main(String[] args) {



         try {
             for (String temp : stringStreet) {
                 String urlName = URL + keywords;
                 urlName += temp;
                 urlName += pa;

                 java.net.URL url = new java.net.URL(urlName);
                 URLConnection connection = url.openConnection();
                 connection.connect();

                 BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

                 // 输出收到的内容
                 StringBuffer stringBuffer = new StringBuffer();
                 String line = "";
                 while((line = br.readLine()) != null) {
                     stringBuffer.append(line);
                 }
                 /** 遍历字符串 */
                 String result = stringBuffer.toString();
                 System.out.println(result);
                 System.out.println("*******************************************");
                 br.close();
             }


//            for (String temp : stringStreet) {
//                //System.out.println(temp);
//                int index = result.indexOf(temp);
//                if (index == -1) {
//                    System.out.println("null");
//                }else {
//                    int start = index + temp.length() + 11;
//                    int end = start + 20;
//                    String l = result.substring(start, end);
//                    String[] lntlat = l.split("\"|,");
//                    System.out.println(lntlat[1] + "\t" + lntlat[2]);
//                }
//            }



         } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
         } catch (MalformedURLException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
   }
}
