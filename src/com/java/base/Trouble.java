package com.java.base;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Trouble {

    class Node{}

    public static void main(String[] args) {
        /** 浮点运算精度问题*/
//        trouble1();
//        trouble2();
        trouble3();
    }

    private final static Lock lock = new ReentrantLock();
    private static void trouble3() {  // 公众号：，，，待解决······
        try {
            lock.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 关于BigDecimal 问题
     */
    private static void trouble2() {
        BigDecimal a = new BigDecimal(0.1);  // 不能以这种赋值
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");  // 要以字符串形式赋值
        System.out.println(b);
        /**如果必须将一个 double 作为参数传递给 BigDecimal 的话，建议传递该 double 值匹配的字符串值。
         * 方式有两种：
         */

        double a2 = 0.1;
        /** 第一种，使用 String.valueOf() 把 double 转为字符串。*/
        BigDecimal a3 = new BigDecimal(String.valueOf(a2));
        BigDecimal a4 = new BigDecimal(Double.toString(a2));  // 或者
        System.out.println(a3); // 0.1  转为字符串

        /** 第二种，使用 valueOf() 方法，该方法内部会调用 Double.toString() 将 double 转为字符串，源码如下：*/
        BigDecimal a5 = BigDecimal.valueOf(a2);
        System.out.println(a5); // 0.1

    }

    /**
     * Java 语言支持两种基本的浮点类型：float 和 double ，以及与它们对应的包装类 Float 和 Double 。
     * 它们都依据 IEEE 754 标准，该标准用科学记数法以底数为 2 的小数来表示浮点数。
     *
     * 但浮点运算很少是精确的。虽然一些数字可以精确地表示为二进制小数，比如说 0.5，它等于 2-1；
     * 但有些数字则不能精确的表示，比如说 0.1。因此，浮点运算可能会导致舍入误差，产生的结果接近但并不等于我们希望的结果。
     *
     * 所以，我们看到了 0.1 的两个相近的浮点值，
     * 一个是比 0.1 略微大了一点点的 0.100000024，一个是比 0.1 略微小了一点点的 0.099999964。
     *
     * Java 对于任意一个浮点字面量，最终都舍入到所能表示的最靠近的那个浮点值，
     * 遇到该值离左右两个能表示的浮点值距离相等时，默认采用偶数优先的原则——
     * 这就是为什么我们会看到两个都以 4 结尾的浮点值的原因。
     */
    private static void trouble1() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        /** 通过printf格式化输出会小数点四舍五入，默认保留6位*/
        System.out.printf("%f  \n%.7f\n",a, b);  //0.100000

        System.out.println(a);  // 0.100000024
        System.out.println(b);  // 0.099999964
        if (a == b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        /** 如果对精度有要求，则推荐使用 BigDecimal
         *  注意：包装类 并不会解决掉精度的问题，即使用Float也没用*/

    }
}
