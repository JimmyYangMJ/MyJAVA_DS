package com.Test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 关于子父类转换问题
 * @author ymj
 * @Date： 2020/7/8 9:11
 */
public class Test1 {

    static class User {
        public String name;

    }
    static class Admin extends User {
        public String name;
        public int age;
    }

    public static void main(String[] args) {
        User user = new User();
        user.name = "jimmy";

        Object object = user; // 父 - 子
        User users = (User) object; // 子 - 父（）
        System.out.println(users.name);

        Admin admin = new Admin();
        admin.name = "jimmy2";
        admin.age = 10;
        User user1 = admin;  // 父 - 子 ，age 消失
        Admin admin1 = (Admin) user1; // 子 - 父 ，age 回来了
        System.out.println(admin1.equals(admin)); // true 转回来了
        if (admin1 instanceof User) {
            System.out.println(admin1.name);
            System.out.println(admin1.age); // age 回来了
        }

        User user3 = new User();
        user3.name = "jimmy3";
//        Admin admin3 = (Admin) user3; // 子 - 父 （直接转换,会抛出ClassCastException异常）
//        System.out.println(admin3.name);


    }
}
