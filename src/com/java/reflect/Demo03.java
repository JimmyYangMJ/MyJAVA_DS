package com.java.reflect;

public class Demo03 {
    public static void main(String[] args) {
        String s ="Hello";
        GetClassALL.printClassMethodMessage(s);

        /** 成员变量信息 */
        GetClassALL.printFieldMessage("hello");
        System.out.println("=============");
        GetClassALL.printFieldMessage(new Integer(1));

        /** 构造函数信息 */
        GetClassALL.printConMessage("hello");
        GetClassALL.printConMessage(new Integer(1));

    }
}
