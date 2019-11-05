package com.PTA.graph;

import java.util.Scanner;

/**
 * 拓扑排序算法<br>
 * 实现----AOE <br>
 * 案例----关键活动
 */
public class AOE {

    static Scanner cin = new Scanner(System.in);
    /** 下标从 1 开始*/
    static int Nv, Ne;
    static int[][] G;

    static void aoe(){
        /** 入度*/
        int inDegree;
        /** 出度*/
        int outDegree;
    }
    public static void main(String[] args) {
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        aoe();
    }
}
