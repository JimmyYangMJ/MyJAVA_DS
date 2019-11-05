package com.designPattern.CreationModel.singleton;

/**
 * �������ģʽ
 * ���ģ����췽��--����˽��
 */
public class Singleton {
    private static Singleton obj = new Singleton(); //����ͬһ������
    private String content;
    /** ȷ��ֻ�������ڲ����ù��캯��*/
    private Singleton()
    {
        System.out.print("�޲ι��캯��");
        this.content = "abc";
    }

    public String getContent() 	{
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public static Singleton getInstance()	{
        //��̬����ʹ�þ�̬����
        //�������ʹ�÷����ڵ���ʱ���������ǲ������÷Ǿ�̬�ĳ�Ա����
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
        System.out.println(obj1 == obj2); //true, obj1��obj2ָ��ͬһ������
    }

}
