package com.java.JCF.Stack_Queue;


import java.util.*;


/**
 * 优先队列
 * @author ymj
 * @Date： 2019/12/14 19:48
 */
public class priorityQueue {

    public static class people implements Comparable<people>{
        int age;
        int num;
        people(int age, int num){
            this.age = age;
            this.num = num;
        }

        @Override
        public int compareTo(people o) {
            if(o.age != this.age){
                return o.age - this.age;
            }else{
                return o.num - this.num;
            }
        }
    }
    public static void main(String[] args) {
        test1();
//        Queue<people> queue = new PriorityQueue<>();
//        queue.add(new people(3,4));
//        queue.add(new people(3,5));
//        queue.add(new people(4,6));
//        queue.add(new people(4,5));
//        Iterator<people> iterator = queue.iterator();
//        while(iterator.hasNext())
//            System.out.println(iterator.next().age );
//
//
//        while(!queue.isEmpty())
//            System.out.println(queue.peek().age +" "+ queue.poll().num );
//
//        String a = "as";
//        a.compareTo("as");
    }

    public static void test1(){
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        queue.add(5);
        queue.add(1);
        queue.add(3);
        queue.add(2);
        while(!queue.isEmpty())
            System.out.println(queue.poll());

    }
}
