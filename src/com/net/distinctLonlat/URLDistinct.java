package com.net.distinctLonlat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 查找行政区域经纬度
 */
public class URLDistinct {


    static String URL = "http://restapi.amap.com/v3/config/district?key=b0435ec549bd4c391aebe4d36e211689&keywords=合肥&subdistrict=3&extensions=all";

   static String[] stringStreet = {
           "临湖社区"
   };

   public static void main(String[] args) {



         try {
            String urlName = URL;

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
            System.out.println("**********************");

            for (String temp : stringStreet) {
                //System.out.println(temp);
                String regular = temp + ".*?" + "\",\"level\"";
                Pattern r = Pattern.compile(regular);
                Matcher m = r.matcher(result);
                if (m.find()) {
                    String pTemp = m.group(0);
//                    System.out.println("***" + pTemp);
                    // 经纬度
                    regular = "\\d+.\\d+,\\s*\\d+.\\d+";
                    Pattern r2 = Pattern.compile(regular);
                    Matcher m2 = r2.matcher(pTemp);
                    if (m2.find()) {
                        pTemp = m2.group(0);
//                        System.out.println("---" + pTemp);
                    }
                    String[] lntlat = pTemp.split(",");
                    System.out.println(lntlat[0].trim() + "\t" + lntlat[1].trim());
                }else {
                    System.out.println("null");
                }
            }


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
