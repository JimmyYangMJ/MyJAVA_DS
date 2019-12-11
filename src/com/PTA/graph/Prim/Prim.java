package com.PTA.graph.Prim;

import java.util.Scanner;

/**
 * PTA 公路村村通问题
 * 算法： 最小生成树  Prim
 * 图存储--- 邻接矩阵
 */
public class Prim {

    static Scanner cin = new Scanner(System.in);
    /** 点数， 边数 从1 开始*/
    static int Nv, Ne;
    static int[][] G;

    /** 建图 ,下标从1开始*/
    static void BuildGraph(){
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        G = new int[Nv+1][Nv+1];
        for (int i = 1; i <= Nv; i++){
            for (int j = 1; j <= Nv; j++){
                G[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= Ne; i++){
            int v1 = cin.nextInt(), v2  = cin.nextInt();
            int w = cin.nextInt();
            G[v1][v2] = w;
            G[v2][v1] = w;
        }
    }

    /**
     * @return --dist最小的下标
     */
    public static int distMin(int[] dist, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int minV = 0; /* 存储下标*/
        for(int v = 1; v <= Nv; v++){
            if(visited[v] == false && dist[v] < min){
                min = dist[v];
                minV = v;
            }
        }
        if(min < Integer.MAX_VALUE){
            return minV;
        }else {
            return -1; /* 这样的顶点不存在*/
        }
    }

    /** prim算法*/
    public static void prim(){
        boolean[] visited = new boolean[Nv+1];
        /** 第一种权重 收录最短路径*/
        int[] dist = new int[Nv+1];
        /** 记录顶点的上一个顶点*/
        int[] path = new int[Nv+1];

        /** 修路总花费*/
        int sum = 0;
        int vCount = 0;
        for (int i = 1; i <= Nv; i++) {
            path[i] = 1; /*暂且定义所有顶点的父结点都是初始点1*/
            dist[i] = G[1][i];  /*起点的邻接点*/
        }
        /** 对起点进行初始化*/
        visited[1] = true;
        dist[1] = 0;

        while (true){
            int v = distMin(dist, visited); /** 未收录的顶点dist最小者*/
            if (v == -1){
                break;
            }
            sum += G[v][path[v]];
            visited[v] = true;
            vCount++;
            for (int i = 1; i <= Nv; i++) {
                if (G[v][i] < dist[i] ) {
                    dist[i] = G[v][i];
                    path[i] = v;
                }
            }
        }
        if (vCount == (Nv-1))
            System.out.println(sum);
        else System.out.println("-1");  /*图不连通*/

    }

    public static void main(String[] args) {
        BuildGraph();
        prim();
    }
}
