package com.PTA.graph.Floyd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Floyed 算法
 * 图存储： 邻接矩阵
 * 图类型：无向有权图
 */
public class Main {

    static int Nv, Ne;
    static int[][] G;

    static final int MAX = 101;
    static Scanner cin = new Scanner(System.in);

    static void buildGraph() {
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        G = new int[Nv+1][Nv+1];

        for(int i = 1; i <= Nv; i++){
            Arrays.fill(G[i], MAX);
        }
        for(int i = 1; i <= Ne; i++){
            int start, end, w;
            start = cin.nextInt();
            end = cin.nextInt();
            w = cin.nextInt();
            G[start][end] = w;
            G[end][start] = w;
        }
    }

    static int[][] floyd() {
        int[][] dist = new int[Nv+1][Nv+1];
        int[][] path = new int[Nv+1][Nv+1];

        for (int i = 1; i <= Nv; i++) {
            for (int j = 1; j <= Nv; j++) {
                dist[i][j] = G[i][j]; // 复制 图 邻接矩阵
                path[i][j] = i; // i 为起点
            }

        }

        // floyd 算法
        for (int k = 1; k <= Nv; k++) {
            for (int i = 1; i <= Nv; i++) {
                for (int j = 1; j <= Nv; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j] && i != j) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        buildGraph();
        floyd();
    }


}
