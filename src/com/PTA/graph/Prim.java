package com.PTA.graph;

import java.util.Scanner;

/**
 * ��·���ͨ����
 * �㷨�� ��С������  Prim
 * ͼ�洢--- �ڽӾ���
 */
public class Prim {

    static Scanner cin = new Scanner(System.in);
    /** ������ ����*/
    static int Nv, Ne;
    static int[][] G;

    /** ��ͼ ,�±��1��ʼ*/
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

    /** prim�㷨*/
    public static void prim(){
        boolean[] visited = new boolean[Nv+1];
        /** ��һ��Ȩ�� ��¼���·��*/
        int[] dist = new int[Nv+1];
        /** ��¼�������һ������*/
        int[] path = new int[Nv+1];

        /** ��·�ܻ���*/
        int sum = 0;
        int vCount = 0;
        /** �������г�ʼ��*/
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
