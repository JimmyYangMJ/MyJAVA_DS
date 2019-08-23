package com.PTA.graph;

import java.util.Scanner;

/**
 * 公路村村通问题
 * 算法： 最小生成树  Prim
 * 图存储--- 邻接矩阵
 */
public class Prim {

    static Scanner cin = new Scanner(System.in);
    /** 点数， 边数*/
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
        for (int i = 1; i < Ne; i++){
            int v1 = cin.nextInt(), v2  = cin.nextInt();
            int w = cin.nextInt();
            G[v1][v2] = w;
            G[v2][v1] = w;
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
        /** 对起点进行初始化*/
        visited[1] = true;
        dist[1] = 0;

        for (int i = 1; i <= Nv; i++) {

        }



    }

    public static void main(String[] args) {
        BuildGraph();
        prim();
    }
}
