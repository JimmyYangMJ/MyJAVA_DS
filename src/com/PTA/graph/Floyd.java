package com.PTA.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有权图的单元最短路径算法<br>
 * 实现----Floyd <br>
 * 图存储 -- 邻接矩阵
 * 案例----哈利波特的考试
 */
public class Floyd {
    static Scanner cin = new Scanner(System.in);
    /** 点数， 边数*/
    static int Nv, Ne;
    /** 邻接矩阵存储图 城市的编号为 1-N*/
    static int[][] G; // 存储权重

    /** 建图, 邻接矩阵 */
    static void BuildGraph(){
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        G = new int[Nv+1][Nv+1];
        /** 一开始图不连通 */
        for (int i = 1; i <= Nv; i++) {
            Arrays.fill(G[i], 65535);
        }
        for (int i = 1; i <= Ne; i++){
            int v1 = cin.nextInt(), v2  = cin.nextInt();
            int l = cin.nextInt();
            /** 无向图*/
            G[v1][v2] = l; G[v2][v1] = l;
        }
    }

    static int[][] floyed() {
        /** 存放floyd 算法结果*/
        int[][] GF = new int[Nv+1][Nv+1];
        for (int i = 1; i <= Nv; i++) {
            for (int j = 1; j <= Nv; j++) {
                GF[i][j] = G[i][j];
            }
        }

        for (int k = 1; k <= Nv; k++)   //Floyd算法
            for (int i = 1; i <= Nv; i++)
                for (int j = 1; j <= Nv; j++) {
                    if(GF[i][j] > GF[i][k] + GF[k][j] && i != j)
                        GF[i][j] = GF[i][k] + GF[k][j];
                }
        return GF;
    }

    /**
     *
     * @param d floyd 邻接矩阵
     * @param i 起点
     * @return 起点i到那个点的距离最长
     */
    static int findMaxDist(int[][] d, int i){
        int max = 0;
        for (int j = 1; j <= Nv; j++) {
            if (i != j && d[i][j] > max) {
                max = d[i][j];
            }
        }
        return max;
    }

    static void findAnimal() {
        int[][] f = null;
        f = floyed();
        int animal = 0;
        int min = 65535;
        for (int i = 1; i <= Nv; i++) {
            int max = findMaxDist(f, i);
            if (max == Integer.MAX_VALUE) {
                System.out.println("0");
                return ;
            }
            if (max < min) {
                min = max;
                animal = i;
            }
        }
        System.out.println(animal + " " + min);
    }

    public static void main(String[] args) {
        BuildGraph();
        findAnimal();

    }
}
