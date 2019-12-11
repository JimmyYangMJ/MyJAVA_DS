package com.PTA.graph.Kruskal;

import java.util.*;

/**
 * 公路村村通问题
 * 算法： 最小生成树  Kruskal
 * 无向有权图
 * 图存储--- 邻接矩阵
 */
public class Kruskal {

    static Scanner cin = new Scanner(System.in);
    /** 点数， 边数, 从1开始*/
    static int Nv, Ne;
    static ArrayList<Edge> edges;
    /** 并查集， 点数*/
    static int[] s;

    static class Edge implements Comparable<Edge>{
        int v1, v2;
        int w; // 权重
        Edge(int v1, int v2, int w){
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }
    }

    /** 找到一个结点所在的集合*/
    static int find(int x) {
        if (s[x] < 0) { /* 本身为一个集合*/
            return x;
        }else {
            return s[x] = find(s[x]);
        }
    }

    /** 合并集合*/
    static int union(int root1, int root2) {
        if(s[root1] > s[root2]) { /* 如果集合2比较大 */
            s[root2] += s[root1];
            s[root1] = root2;    /* 集合1并入集合2  */
            return  root2;
        }else{
            s[root1] += s[root2];
            s[root2] = root1;    /* 集合2并入集合1  */
            return  root1;
        }

    }

    /** 监测俩个是否为一个集合*/
    static boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

    static void kruskal(){
        /** 生成树边计数*/
        int edgeN = 0;
        /** 最小生成树权重和*/
        int cost = 0;
        /** 下一个权重最小边的位置 */
        int nextEdge = 0;
        s = new int[Nv+1];
        /** 初始化并查集*/
        Arrays.fill(s,-1);
        Collections.sort(edges); /* 对边集 合排序, 或者使用最小堆*/
        while (edgeN < Nv-1) { /* 边未收集完成*/
            if (nextEdge >= Ne) {
                break;
            }
            int v1 = edges.get(nextEdge).v1;
            int v2 = edges.get(nextEdge).v2;
            if (!isSameSet(v1, v2)){ /*两个不是一个集合（没有形成环路）*/
                cost += edges.get(nextEdge).w;
                edgeN++;
                union(find(v1), find(v2));
            }
            nextEdge++;
        }
        if (edgeN < Nv-1){
            cost = -1; /* 图不连通*/
        }
        System.out.println(cost);
    }

    public static void main(String[] args) {
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        edges = new ArrayList<>();
        if (Ne < Nv-1) { /* 边数不够， 图不连通*/
            System.out.println("-1");
        }else {
            for (int i = 0; i < Ne; i++) {
                int from = cin.nextInt();
                int to = cin.nextInt();
                int w = cin.nextInt();
                edges.add(new Edge(from, to, w));
            }
            kruskal();
        }
    }
}
