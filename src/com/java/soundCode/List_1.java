package com.java.soundCode;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author ymj
 * @Date£º 2020/3/12 22:45
 */
public class List_1 {


    public static void main(String[] args) {

        String a = "asd";
        System.out.println(Objects.equals(a,a));
        String b = null;
        System.out.println(Objects.isNull(b));

        List<String> list = Arrays.asList("hello,world");
        System.out.println(list.get(0));
        Object[] objects = list.toArray();
        System.out.println(objects[0]);
        objects[0] = new Object();
        list.remove("hello,world");

        System.out.println();
    }

}
