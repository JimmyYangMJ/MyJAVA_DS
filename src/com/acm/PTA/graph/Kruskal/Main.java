package com.acm.PTA.graph.Kruskal;

import java.util.*;

/**
 * ???? ??С??????  Kruskal
 * ??????У???С???
 */
public class Main {

    static Scanner cin = new Scanner(System.in);
    static int Nv, Ne;
    static Queue<Edge> edges; // ?????
    static int[] s;

    static class Edge implements Comparable<Edge> {
        int v1, v2;
        int w; // ???
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
        if(Ne < Nv - 1) { // ????????
            System.out.println("-1");
        }else {
            for (int i = 0; i < Ne; i++) { // ?????????
                int from = cin.nextInt();
                int to =cin.nextInt();
                int w = cin.nextInt();
                edges.add(new Edge(from, to, w));
            }
            kruskal();
        }

    }

    static void kruskal() {
        int edgCount = 0; // ??????????
        int cost = 0; // ??????????
        // ????????鼯
        s = new int[Nv+1];
        Arrays.fill(s, -1);
        // ?????
        int index = 0;

        while (edgCount < Nv - 1) {
            if(index >= Ne) {  // ??????
                break;
            }
            int v1 = edges.peek().v1;
            int v2 = edges.peek().v2;
            if(isSameUnion(v1, v2) == false) {
                edgCount++; // ????????
                cost += edges.peek().w;
                union(find(v1), find(v2));
            }
            index++;
            edges.poll();
        }
        if (edgCount < Nv-1) { // ??????
            cost = -1;
        }
        System.out.println(cost);
    }

    // ?? root1 ??root2 ??????????? |????|??? ???????????
    static void union(int root1, int root2) {
        if (s[root1] < s[root2]) { // ???? 1 ??
            s[root1] += s[root2];
            s[root2] = root1;
        }else {
            s[root2] += s[root1];
            s[root1] = root2;
        }
    }

    // ????? x ??????
    static int find(int x) {
        if (s[x] < 0) {
            return x;
        }else {
            return s[x] = find(s[x]); // ?????·??
        }
    }

    // ?????????????????鼯
    static boolean isSameUnion(int x1, int x2) {
        return find(x1) == find(x2);
    }

}