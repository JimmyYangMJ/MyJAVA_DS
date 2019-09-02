package com.PTA.graph;

import java.util.*;

/**
 * 搜索算法<br>
 * 实现----BFS / DFS <br>
 * 图存储---邻接矩阵
 * 案例----列出连通集
 */
public class BFSDFS {

    static Scanner cin  = new Scanner(System.in);

    /** 点数， 边数*/
    static int Nv, Ne;
    static int[][] G;

    /** 建图, 邻接矩阵 */
    static void BuildGraph(){
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        G = new int[Nv][Nv];
        for (int i = 0; i < Ne; i++){
            int v1 = cin.nextInt();
            int v2  = cin.nextInt();
            /** 无向图 1/0表示是否有边 */
            G[v1][v2] = 1;
            G[v2][v1] = 1;
        }
    }

    /**
     * 非递归 DFS
     */
    static void DFSTravel(){
        int[] visited = new int[Nv];
        for(int i = 0; i < Nv; i++){
            if(visited[i] == 0) { // 可能图不连通
                DFS(i,visited);
            }
        }
    }

    static void DFS(int head, int[] v){
        Stack<Integer> stack = new Stack<>();
        System.out.print("{ ");
        stack.push(head);
        v[head] = 1; // 起点已经访问了
        System.out.print(head + " ");
        while(!stack.isEmpty()){
            for (int i = 0; i < Nv; i++){
                /** 没有访问过， 并且是邻接点*/
                if ( v[i] == 0 && G[head][i] == 1){
                    stack.push(i);
                    v[i] = 1;
                    System.out.print(stack.peek() + " ");
                    break;
                }
            }
            if (head == stack.peek()){ /* 没有邻接点了*/
                stack.pop();
            }else { /* 有邻接点*/
                head = stack.peek();
            }
        }
        System.out.println("}");
    }

    static void DFSTravelRecursion(){
        int[] visited = new int[Nv];
        for(int i = 0; i < Nv; i++){
            if(visited[i] == 0) { // 可能图不连通
                System.out.print("{ ");
                DFSRecursion(i,visited);
                System.out.println("}");
            }
        }
    }

    static void DFSRecursion(int head, int[] v){
        v[head] = 1;
        System.out.print(head + " ");
        for (int i = 0; i < Nv; i++){
            /** 没有访问过， 并且是邻接点*/
            if ( v[i] == 0 && G[head][i] == 1){
                DFSRecursion(i, v);
            }
        }
    }

    /**
     * 非递归 BFS
     */
    static void BFSTravel(){
        int[] visited = new int[Nv]; /*开始都未访问过*/
        for(int i = 0; i < Nv; i++){ /*访问每一个结点*/
            if(visited[i] == 0)  //可能图不连通
                BFS(i,visited);
        }
    }

    static void BFS(int head, int[] v){
        Queue<Integer> queue = new LinkedList<>();
        System.out.print("{ ");
        queue.add(head);
        v[head] = 1;
        while (!queue.isEmpty()){
            head = queue.peek();
            for (int i = 0; i < Nv; i++){ /* head 的邻接点入队列*/
                /** 没有访问过， 并且是邻接点*/
                if ( v[i] == 0 && G[head][i] == 1){
                    v[i] = 1;
                    queue.add(i);
                }
            }
            System.out.print(queue.peek() + " ");
            if (!queue.isEmpty()){
                queue.poll();
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        /** 邻接矩阵储存Grape */
        BuildGraph();
        DFSTravelRecursion(); // Queue travel
        BFSTravel(); // Stack travel
    }
}
