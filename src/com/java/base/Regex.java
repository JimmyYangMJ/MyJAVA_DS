package com.java.base;

/**
 * ������ʽ��ʹ��
 * @author ymj
 * @Date�� 2020/4/10 9:48
 */
public class Regex {
    public static void main(String[] args) {
        //�����ж�����������С��
        //?:0��1��, *:0����, +:1����
        String str = "4253.";
        Boolean strResult = str.matches("-?[0-9]+\\.*[0-9]*");
        System.out.println(strResult);
    }
}
