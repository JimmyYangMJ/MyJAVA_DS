package com.PTA.graph;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class Test {
    static class A{
        int i;
        int j;

        @Override
        public boolean equals(Object obj) {
            A a = (A) obj;
            if(this.i == a.i && this.j == a.j){
                return true;
            }else{
                return false;
            }
        }
    }

    static class A2{

    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        A a1 = new A();
        A a2 = new A();
        a1.i = 1;
        a1.j = 2;
        a2.i = 1;
        a2.j = 2;
        System.out.println(a1.equals(a2));
        String a = cin.nextLine();
        String[] num = a.split(" ");
        System.out.println(num.length);
        for(int i = 0; i < num.length; i++){
            System.out.println(num[i]);
        }
        int v1 = Integer.parseInt(num[0]), v2  =  Integer.parseInt(num[1]);
        int l =  Integer.parseInt(num[2]), w =  Integer.parseInt(num[3]);
        System.out.println(w);
    }
}
