package com.designPattern.CreationModel.singleton;

/**
 * 单例设计模式
 * 核心：构造方法--采用私有
 */
public class Singleton {
    private static Singleton obj = new Singleton(); //共享同一个对象
    private String content;
    /** 确保只能在类内部调用构造函数*/
    private Singleton()
    {
        System.out.print("无参构造函数");
        this.content = "abc";
    }

    public String getContent() 	{
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public static Singleton getInstance()	{
        //静态方法使用静态变量
        //另外可以使用方法内的临时变量，但是不能引用非静态的成员变量
        return obj;
    }

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        System.out.println(obj1.getContent());  //abc

        Singleton obj2 = Singleton.getInstance();
        System.out.println(obj2.getContent());  //abc

        obj2.setContent("def");
        System.out.println(obj1.getContent());
        System.out.println(obj2.getContent());
        Singleton obj3 = new Singleton();
        System.out.println("++"+obj3.getContent());
        System.out.println(obj1 == obj2); //true, obj1和obj2指向同一个对象
    }

}
