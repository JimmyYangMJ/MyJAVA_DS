package com.java.reflect;

public class Demo03 {
    public static void main(String[] args) {
        String s ="Hello";
        GetClassALL.printClassMethodMessage(s);

        /** ��Ա������Ϣ */
        GetClassALL.printFieldMessage("hello");
        System.out.println("=============");
        GetClassALL.printFieldMessage(new Integer(1));

        /** ���캯����Ϣ */
        GetClassALL.printConMessage("hello");
        GetClassALL.printConMessage(new Integer(1));

    }
}
