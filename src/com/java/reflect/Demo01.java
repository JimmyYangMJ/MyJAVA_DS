package com.java.reflect;

class Foo{

    void print(){
        System.out.println("foo");
    }
}
public class Demo01 {
    public static void main(String[] args) {
        /** 在命令行
         * 编译
         *  D:\IDEA-workspace\MyJAVA_DS\src>   javac com/java/reflect/Demo01.java
         * 运行
         *  D:\IDEA-workspace\MyJAVA_DS\src>   java com/java/reflect/Demo01 （参数1 参数2····）
         *
         */
        System.out.println(args[0]);
        //Foo的实例对象如何表示
        Foo foo1 = new Foo();//foo1就表示出来了.
        //Foo这个类 也是一个实例对象，Class类的实例对象,如何表示呢
        //任何一个类都是Class的实例对象，
        /**这个实例对象有三种表示方式*/

        /** 第一种表示方式--->实际在告诉我们任何一个类都有一个隐含的静态成员变量class */
        Class c1 = Foo.class;
        System.out.println(c1);
        /** 第二中表达方式  已经知道该类的对象通过getClass方法 */
        Class c2 = foo1.getClass();
        System.out.println(c2);
        /*官网 c1 ,c2 表示了Foo类的类类型(class type)
         * 万事万物皆对象，
         * 类也是对象，是Class类的实例对象
         * 这个对象我们称为该类的类类型
         *
         */

        //不管c1  or c2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);

        /** 第三种表达方式 */
        try {
            Class c3 = null;
            c3 = Class.forName("com.java.reflect.Foo");

            System.out.println("3: " + (c2 == c3) );
            System.out.println(c2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //我们完全可以通过类的类类型创建该类的对象实例---->通过c1 or c2 or c3创建Foo的实例对象
        try {
            if(c1 instanceof Class){
                System.out.println("c1 instanceof Class:" + true);
            }
                Foo foo = (Foo)c1.newInstance();//需要有无参数的构造方法
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

