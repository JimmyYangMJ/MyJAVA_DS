package com.PTA.graph.Kruskal;

import java.util.*;

/**
 * ��·���ͨ����
 * �㷨�� ��С������  Kruskal
 * ������Ȩͼ
 * ͼ�洢--- �ڽӾ���
 */
public class Kruskal {

    static Scanner cin = new Scanner(System.in);
    /** ������ ����, ��1��ʼ*/
    static int Nv, Ne;
    static ArrayList<Edge> edges;
    /** ���鼯�� ����*/
    static int[] s;

    static class Edge implements Comparable<Edge>{
        int v1, v2;
        int w; // Ȩ��
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

    /** �ҵ�һ��������ڵļ���*/
    static int find(int x) {
        if (s[x] < 0) { /* ����Ϊһ������*/
            return x;
        }else {
            return s[x] = find(s[x]);
        }
    }

    /** �ϲ�����*/
    static int union(int root1, int root2) {
        if(s[root1] > s[root2]) { /* �������2�Ƚϴ� */
            s[root2] += s[root1];
            s[root1] = root2;    /* ����1���뼯��2  */
            return  root2;
        }else{
            s[root1] += s[root2];
            s[root2] = root1;    /* ����2���뼯��1  */
            return  root1;
        }

    }

    /** ��������Ƿ�Ϊһ������*/
    static boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

    static void kruskal(){
        /** �������߼���*/
        int edgeN = 0;
        /** ��С������Ȩ�غ�*/
        int cost = 0;
        /** ��һ��Ȩ����С�ߵ�λ�� */
        int nextEdge = 0;
        s = new int[Nv+1];
        /** ��ʼ�����鼯*/
        Arrays.fill(s,-1);
        Collections.sort(edges); /* �Ա߼� ������, ����ʹ����С��*/
        while (edgeN < Nv-1) { /* ��δ�ռ����*/
            if (nextEdge >= Ne) {
                break;
            }
            int v1 = edges.get(nextEdge).v1;
            int v2 = edges.get(nextEdge).v2;
            if (!isSameSet(v1, v2)){ /*��������һ�����ϣ�û���γɻ�·��*/
                cost += edges.get(nextEdge).w;
                edgeN++;
                union(find(v1), find(v2));
            }
            nextEdge++;
        }
        if (edgeN < Nv-1){
            cost = -1; /* ͼ����ͨ*/
        }
        System.out.println(cost);
    }

    public static void main(String[] args) {
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        edges = new ArrayList<>();
        if (Ne < Nv-1) { /* ���������� ͼ����ͨ*/
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
