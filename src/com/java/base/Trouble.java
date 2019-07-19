package com.java.base;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Trouble {

    class Node{}

    public static void main(String[] args) {
        /** �������㾫������*/
//        trouble1();
//        trouble2();
        trouble3();
    }

    private final static Lock lock = new ReentrantLock();
    private static void trouble3() {  // ���ںţ������������������������
        try {
            lock.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * ����BigDecimal ����
     */
    private static void trouble2() {
        BigDecimal a = new BigDecimal(0.1);  // ���������ָ�ֵ
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");  // Ҫ���ַ�����ʽ��ֵ
        System.out.println(b);
        /**������뽫һ�� double ��Ϊ�������ݸ� BigDecimal �Ļ������鴫�ݸ� double ֵƥ����ַ���ֵ��
         * ��ʽ�����֣�
         */

        double a2 = 0.1;
        /** ��һ�֣�ʹ�� String.valueOf() �� double תΪ�ַ�����*/
        BigDecimal a3 = new BigDecimal(String.valueOf(a2));
        BigDecimal a4 = new BigDecimal(Double.toString(a2));  // ����
        System.out.println(a3); // 0.1  תΪ�ַ���

        /** �ڶ��֣�ʹ�� valueOf() �������÷����ڲ������ Double.toString() �� double תΪ�ַ�����Դ�����£�*/
        BigDecimal a5 = BigDecimal.valueOf(a2);
        System.out.println(a5); // 0.1

    }

    /**
     * Java ����֧�����ֻ����ĸ������ͣ�float �� double ���Լ������Ƕ�Ӧ�İ�װ�� Float �� Double ��
     * ���Ƕ����� IEEE 754 ��׼���ñ�׼�ÿ�ѧ�������Ե���Ϊ 2 ��С������ʾ��������
     *
     * ��������������Ǿ�ȷ�ġ���ȻһЩ���ֿ��Ծ�ȷ�ر�ʾΪ������С��������˵ 0.5�������� 2-1��
     * ����Щ�������ܾ�ȷ�ı�ʾ������˵ 0.1����ˣ�����������ܻᵼ�������������Ľ���ӽ���������������ϣ���Ľ����
     *
     * ���ԣ����ǿ����� 0.1 ����������ĸ���ֵ��
     * һ���Ǳ� 0.1 ��΢����һ���� 0.100000024��һ���Ǳ� 0.1 ��΢С��һ���� 0.099999964��
     *
     * Java ��������һ�����������������ն����뵽���ܱ�ʾ��������Ǹ�����ֵ��
     * ������ֵ�����������ܱ�ʾ�ĸ���ֵ�������ʱ��Ĭ�ϲ���ż�����ȵ�ԭ�򡪡�
     * �����Ϊʲô���ǻῴ���������� 4 ��β�ĸ���ֵ��ԭ��
     */
    private static void trouble1() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        /** ͨ��printf��ʽ�������С�����������룬Ĭ�ϱ���6λ*/
        System.out.printf("%f  \n%.7f\n",a, b);  //0.100000

        System.out.println(a);  // 0.100000024
        System.out.println(b);  // 0.099999964
        if (a == b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        /** ����Ծ�����Ҫ�����Ƽ�ʹ�� BigDecimal
         *  ע�⣺��װ�� �������������ȵ����⣬��ʹ��FloatҲû��*/

    }
}
