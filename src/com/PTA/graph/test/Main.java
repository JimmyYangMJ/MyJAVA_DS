package com.PTA.graph.test;

import java.util.Scanner;

/**
 * 哥尼斯堡的“七桥问题”
 * 邻接表, 无向无权图
 * @author ymj
 * @Date： 2019/12/10 15:02
 */
public class Main {

    static Vnode[] vnodes;
    static int Nv, Ne;
    static boolean flag = true;
    static Scanner cin = new Scanner(System.in);

    /** 判断图是否连通 DFS 递归算法*/
    static void DFS(boolean[] visit, int start) {
        visit[start] = true;
        Node node = vnodes[start].point;
        while(node != null) {
            if(visit[node.id] == false) { // 未访问
                DFS(visit, node.id);
            }
            node = node.next;
        }
    }

    // 邻接表存储
    /** 邻接表 <表头结点>
     * 下标就是表示 结点号*/
    static class Vnode {
        int degree = 0;
        Node point = null;
    }
    /** 结点 */
    static class Node {
        int id;
        Node next = null;
        Node(int id, Node next){
            this.id = id;
            this.next = next;
        }
    }
    static void buildGraph(){
        /** 邻接表 头节点：vnodes*/
        vnodes = new Vnode[Nv+1];
        for (int i = 0; i <= Nv; i++) { // 分配空间
            vnodes[i] = new Vnode();
        }
        for (int i = 1; i <= Ne ; i++) {
            int start = cin.nextInt();
            int end = cin.nextInt();
            vnodes[start].point = new Node(end, vnodes[start].point);
            vnodes[start].degree++;
            /** 由于是无向图 */
            vnodes[end].point = new Node(start, vnodes[end].point);
            vnodes[end].degree++;
        }
    }

    public static void main(String[] args) {
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        buildGraph();
        for (int i = 1; i <= Nv; i++) {
            if(vnodes[i].degree % 2 != 0) {
                flag = false;
                break;
            }
        }
        boolean[] visited = new boolean[Nv+1];

        DFS(visited, 1);
        for (int i = 1; i <= Nv; i++) {
            if(visited[i] == false) {
                flag = false;
                break;
            }
        }

        if(flag == true){
            System.out.println("1");
        }else {
            System.out.println("0");
        }

    }
}
