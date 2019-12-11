package com.PTA.graph.Kruskal;

import java.util.*;

/**
 * 算法： 最小生成树  Kruskal
 * 优先队列（最小堆）
 */
public class Main {

    static Scanner cin = new Scanner(System.in);
    static int Nv, Ne;
    static Queue<Edge> edges; // 边集合
    static int[] s;

    static class Edge implements Comparable<Edge> {
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

    public static void main(String[] args) {
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        edges = new PriorityQueue<>();
        if(Ne < Nv - 1) { // 边数不够
            System.out.println("-1");
        }else {
            for (int i = 0; i < Ne; i++) { // 收集每一条边
                int from = cin.nextInt();
                int to =cin.nextInt();
                int w = cin.nextInt();
                edges.add(new Edge(from, to, w));
            }
            kruskal();
        }

    }

    static void kruskal() {
        int edgCount = 0; // 生成树计数
        int cost = 0; // 生成树权重和
        // 初始化并查集
        s = new int[Nv+1];
        Arrays.fill(s, -1);
        // 队列头
        int index = 0;

        while (edgCount < Nv - 1) {
            if(index >= Ne) {  // 边收完
                break;
            }
            int v1 = edges.peek().v1;
            int v2 = edges.peek().v2;
            if(isSameUnion(v1, v2) == false) {
                edgCount++; // 收录一条边
                cost += edges.peek().w;
                union(find(v1), find(v2));
            }
            index++;
            edges.poll();
        }
        if (edgCount < Nv-1) { // 图不连通
            cost = -1;
        }
        System.out.println(cost);
    }

    // 将 root1 和root2 合并为一个集合 |负数|表示 集合的元素个数
    static void union(int root1, int root2) {
        if (s[root1] < s[root2]) { // 集合 1 大
            s[root1] += s[root2];
            s[root2] = root1;
        }else {
            s[root2] += s[root1];
            s[root1] = root2;
        }
    }

    // 找元素 x 的根节点
    static int find(int x) {
        if (s[x] < 0) {
            return x;
        }else {
            return s[x] = find(s[x]); // 同时压缩路径
        }
    }

    // 两个元素是否为一个并查集
    static boolean isSameUnion(int x1, int x2) {
        return find(x1) == find(x2);
    }

}
