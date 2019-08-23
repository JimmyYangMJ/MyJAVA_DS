package com.java.base;

interface Aa{
    int b = 10;
    int sum();
}

class Bb implements Aa{

    int a = 10;
    int c = 18;
    public int sum() {
        return 2;
    }
}
class Cc extends Bb{
    int a = 11;
    int bc = 12;
    @Override
    public int sum() {
        return 3;
    }

    public int sum7() {
        return 7+bc;
    }
}
public class ExtendsTest01 {
    public static void main(String[] args) {
        Aa obj = new Bb();
        Bb obj2 = new Bb();
        Bb obj3 = new Cc();
        System.out.println(obj.b);
        System.out.println(obj2.a);
        System.out.println(obj3.sum());
        System.out.println(  ((Cc) obj3).sum7()  );
        System.out.println(obj3.b + " " + obj3.c +" "+ obj3.a);  // 没有bc
        System.out.println(Bb.class);
        System.out.println(obj3.getClass());
    }
}
