package com.java.base;

/**
 * 正则表达式的使用
 * @author ymj
 * @Date： 2020/4/10 9:48
 */
public class Regex {
    public static void main(String[] args) {
        //可以判断正负、整数小数
        //?:0或1个, *:0或多个, +:1或多个
        String str = "4253.";
        Boolean strResult = str.matches("-?[0-9]+\\.*[0-9]*");
        System.out.println(strResult);
    }
}
