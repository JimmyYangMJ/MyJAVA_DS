package com.java.reflect;

class Foo{

    void print(){
        System.out.println("foo");
    }
}
public class Demo01 {
    public static void main(String[] args) {
        /** ��������
         * ����
         *  D:\IDEA-workspace\MyJAVA_DS\src>   javac com/java/reflect/Demo01.java
         * ����
         *  D:\IDEA-workspace\MyJAVA_DS\src>   java com/java/reflect/Demo01 ������1 ����2����������
         *
         */
        System.out.println(args[0]);
        //Foo��ʵ��������α�ʾ
        Foo foo1 = new Foo();//foo1�ͱ�ʾ������.
        //Foo����� Ҳ��һ��ʵ������Class���ʵ������,��α�ʾ��
        //�κ�һ���඼��Class��ʵ������
        /**���ʵ�����������ֱ�ʾ��ʽ*/

        /** ��һ�ֱ�ʾ��ʽ--->ʵ���ڸ��������κ�һ���඼��һ�������ľ�̬��Ա����class */
        Class c1 = Foo.class;
        System.out.println(c1);
        /** �ڶ��б�﷽ʽ  �Ѿ�֪������Ķ���ͨ��getClass���� */
        Class c2 = foo1.getClass();
        System.out.println(c2);
        /*���� c1 ,c2 ��ʾ��Foo���������(class type)
         * ��������Զ���
         * ��Ҳ�Ƕ�����Class���ʵ������
         * ����������ǳ�Ϊ�����������
         *
         */

        //����c1  or c2��������Foo��������ͣ�һ����ֻ������Class���һ��ʵ������
        System.out.println(c1 == c2);

        /** �����ֱ�﷽ʽ */
        try {
            Class c3 = null;
            c3 = Class.forName("com.java.reflect.Foo");

            System.out.println("3: " + (c2 == c3) );
            System.out.println(c2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //������ȫ����ͨ����������ʹ�������Ķ���ʵ��---->ͨ��c1 or c2 or c3����Foo��ʵ������
        try {
            if(c1 instanceof Class){
                System.out.println("c1 instanceof Class:" + true);
            }
                Foo foo = (Foo)c1.newInstance();//��Ҫ���޲����Ĺ��췽��
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

