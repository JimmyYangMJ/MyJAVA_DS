package com.acm.PTA.graph.Dijkstra;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Dijkstra
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

    static boolean dijkstra(int start,int[] dist, int[] path) {

        boolean[] visit = new boolean[Nv +1];

        for (int i = 1; i <= Nv; i++) {
            dist[i] = G[start][i];
            path[i] = start;
        }
        //  start
        visit[start] = true;
        dist[start] = 0;
        int count = 1;
        while(true){
            int v = distMin(dist, visit);
            if(v == -1){
                break;
            }
            visit[v] = true;
            count++;  // ��¼��¼����ĸ���

            for(int i =1; i <= Nv; i++) {
                if(visit[i] == false && G[v][i] < MAX){ // �� v���ڽӵ㣬��δ���ʹ�
                    if(dist[i] > G[v][i] + dist[v]) {
                        dist[i] = G[v][i] + dist[v];
                        path[i] = v;
                    }
                }
            }

        }
        // ͼ����ͨ
        if (count != Nv) {
            return false;
        }else{
            return true;
        }

    }

    static int distMin(int[] dist, boolean[] v) {
        int min = MAX, minIndex = -1;
        for(int i = 1; i <= Nv; i++) {
            if(v[i] == false && dist[i] < min){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        buildGraph();
        int[] dist = new int[Nv + 1];
        int[] path = new int[Nv + 1];
        int start = 1;
        dijkstra(start, dist, path);

    }


}
