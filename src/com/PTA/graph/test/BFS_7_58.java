package com.PTA.graph.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * PTA �� ���뻢Ѩ
 * ˼·�� BFS--���Ĳ������
 */
public class BFS_7_58 {
    static Scanner cin = new Scanner(System.in);
    static  ArrayList<LinkedList> arrayList;
    static  int n;
    public static void main(String[] args) {
        n = cin.nextInt();
        /** �±��1 ��ʼ */
        arrayList = new ArrayList<>(n+1);
        arrayList.add(null);  // ���±� 0 ��ֵ

        for (int i = 1; i <= n; i++) {
            int num = cin.nextInt();
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int j = 0; j < num; j++) {
                int temp = cin.nextInt();
                linkedList.add(temp);
            }
            arrayList.add(i, linkedList);
        }
        /**������в������ */
        System.out.print(BFS());

    }

    static int BFS() {
        int deep = 1;
        Queue<Integer> queue = new LinkedList<>();
        while (!arrayList.get(1).isEmpty()) {
            queue.add((Integer) arrayList.get(1).get(0));
            arrayList.get(1).remove(0);
        }
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            while (!arrayList.get(temp).isEmpty()) {
                queue.add((Integer) arrayList.get(temp).get(0));
                arrayList.get(temp).remove(0);
            }
            deep = temp;
        }
        return deep;

    }
}
