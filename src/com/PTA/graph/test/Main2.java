package com.PTA.graph.test;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将表达式的值 分割
 * @author ymj
 * @Date： 2019/12/10 11:04
 */
public class Main2 {

    static int index = 0;
    static boolean isNum(char a) {
        if(a >= '0' && a <='9'||a == '.'){
            return true;
        }else {
            return false;
        }
    }

    static String getop(char[] a){
        String temp = "";
        if(a[index] == '*' || a[index] == '/' || a[index] == '(' || a[index] == ')'){  // 运算符
            temp += a[index];
            index++;
            return temp;
        }else if(a[index] == '+' || a[index] == '-'){
            if(index-1 < 0 || a[index-1] == '(') { //  正负号
                temp += a[index++];
                while (isNum(a[index])){
                    temp += a[index++];
                }
                return temp;
            }else{ // 运算符
                temp += a[index++];
                return temp;
            }
        }else { // 数字
            temp += a[index];
            index++;
            return temp;
        }
    }
    public static void main(String[] args) {
        String equation = "-5.8*(6+(-0.9-(-2))+(+1.9)/2)-5";
        String[] b = equation.split("\\(|\\)|\\*|\\/|\\+|\\)\\-");
        for (String temp :b) {
            System.out.print(temp + " ");
        }
        System.out.println();
        char[] a = equation.toCharArray();

        System.out.println(String.valueOf(a));
        while (index < a.length){
            String node = String.valueOf(getop(a));
            try {
                System.out.print(Double.parseDouble(node)+ " ");
            }catch (Exception e) {
                System.out.print(node + " ");
            }
        }

    }
}
