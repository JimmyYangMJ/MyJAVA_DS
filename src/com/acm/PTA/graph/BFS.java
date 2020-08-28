package com.acm.PTA.graph;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 无权图的单元最短路径算法<br>
 * 实现----BFS <br>
 * 案例----六度空间
 * (缺陷： 对于边界测试，最大N和 M 错误)
 * 正解：https://blog.csdn.net/fairydeng/article/details/89470635)
 */
public class BFS {
    /**思路： 对每个结点进行广度搜索
     * 难点： 层数的建立*/

    /** 点数从  1 开始*/
    static int Ne;
    static int Nv;
    /** 标记 下标 节点是否被访问 */
    static boolean [] visited;
    static Vnode[] vnodes;
    static Scanner cin = new Scanner(System.in);

    /** 邻接表 <表头结点>
     * 下标就是表示 结点号*/
    static class Vnode {
        Node point = null;
    }
    /** 结点 */
    static class Node {
        int num;
        Node next = null;
    }
    /** 建图, 邻接表 */
    static void BuildGraph(){
        /** 邻接表 头节点：vnodes*/
        for (int i = 1; i <= Ne ; i++) {
            int start = cin.nextInt();
            int end = cin.nextInt();
            // 1.
            Node temp = new Node();
            temp.num = end;
            temp.next = vnodes[start].point;
            vnodes[start].point = temp;
            /** 由于是无向图 */
            // 2.
            temp = new Node();
            temp.num = start;
            temp.next = vnodes[end].point;
            vnodes[end].point = temp;

        }
    }

    /** 对每个结点进行 广度优先搜索 */
    static void sixDegree(){
        for (int i = 1; i <= Nv; i++) {
            int num = BFS(i);
            double rate = num*1.0/Nv;
            DecimalFormat df = new DecimalFormat("00.00%");
            System.out.println(i + ": " +df.format(rate));
        }
    }

    /**
     *
     * @param start 开始的结点
     * @return 关系层数在 6 以内的结点数
     */
    static int BFS(int start){
        visited = new boolean[Nv+1];
        /** 记录6层以内的相关的人数 */
        int count = 1;
        /** 记录层数 */
        int level = 0;
        /** 记录一层中最后一个访问的结点 */
        int last = start;
        int tail = 0; // 辅助结点

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int  v = queue.poll();
            Node temp;
            temp = vnodes[v].point;
            while(temp != null) {
                if(temp != null && visited[temp.num] == false){
                    queue.add(temp.num);
                    count++;
                    visited[temp.num] = true;
                    tail = temp.num;
                }
                temp = temp.next;
            }
            if (v == last) {
                level++;
                last = tail;
            }
            if (level == 6) {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        vnodes = new Vnode[Nv+1];
        for (int i = 0; i <= Nv; i++) { // 分配空间
            vnodes[i] = new Vnode();
        }
        BuildGraph();
        sixDegree();
    }
}

