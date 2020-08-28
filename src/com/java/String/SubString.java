package com.java.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ymj
 * @Date： 2020/7/15 11:35
 * @description: 求子串,字符串匹配
 */
public class SubString {
    public static void main(String[] args) {
        String line = "mingasd54 dfa asdf asd7sdf";
        test();

        String pattern = "asd.*asd7";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);

        if (m.find()) {
            System.out.println(m.start());
            System.out.println(m.end());
            System.out.println("找到： " + m.group(0) );
        } else {
            System.out.println("没有");
        }

        String s1 = "12345?6789";
        /** replace只能替换字符， replaceALL 第一个参数是正则表达式*/
        String s2 = s1.replace("\\?", "a");
        System.out.println(s2);
        // 这里的[?] 才表示字符问号，这样才能正常替换。不然在正则中会有特殊的意义就会报异常
        String s3 = s1.replaceAll("[?]", "a");
        System.out.println(s3);
    }

    public static void test() {
        //String result = "庐江县\",\"center\":\"117.289844,31.251488\",\"level\":\"district";
        String result = null;
        String regular = "江" + ".*" + "\",\"level\":\"";
        Pattern r2 = Pattern.compile(regular);
        Matcher m2 = r2.matcher(result);
        if (m2.find()) {
            System.out.println("---" + m2.group(0));
        }
    }
}
