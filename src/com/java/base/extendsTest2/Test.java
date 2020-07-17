package com.java.base.extendsTest2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ymj
 * @Date： 2019/12/17 16:12
 */
public class Test {
    static class demo {
        int a;
        int b;

        public demo(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }


    public static void main(String[] args) {
        demo[] demos = new demo[4];
        Queue<demo> queue = new PriorityQueue<>(new Comparator<demo>() {
            @Override
            public int compare(demo o1, demo o2) {
                return  o2.a - o1.a;// 小 -- 大
            }
        });

        queue.offer(new demo(1,1));
        queue.offer(new demo(3,0));
        queue.offer(new demo(3,1));
        queue.offer(new demo(3,7));
        queue.offer(new demo(3,6));
        queue.offer(new demo(3,8));
        queue.offer(new demo(2,-1));

        while(!queue.isEmpty()) {
            demo temp = queue.poll();
            System.out.println(temp.a + ":" + temp.b);
        }

    }
}
