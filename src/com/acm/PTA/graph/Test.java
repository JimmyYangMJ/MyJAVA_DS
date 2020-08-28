package com.acm.PTA.graph;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test {

    static int Nv, Ne, start, end;
    static int[][] G;
    static int[] weight;
    static final int MAX = 501;

    static boolean dijkstra(int[] dist, int[] path, PrintWriter out) {
        int[] dist2 = new int[Nv];  // �ڶ�Ȩ��
        int[] num = new int[Nv];
        Arrays.fill(num, 1);

        boolean[] visit = new boolean[Nv];
        for(int i = 0; i < Nv ;i++) {
            dist[i] = G[start][i];
            dist2[i] = weight[i];
            if(i != start && G[start][i] < MAX){
                dist2[i] += weight[start];
            }
            path[i] = start;
        }
        visit[start] = true;

        while(true) {
            int v = distMin(dist, visit);
            if(v == -1){
                break;
            }
            visit[v] = true;

            for(int i = 0; i < Nv; i++) {
                if(G[v][i] < MAX && visit[i] == false){
                    if(dist[i] > dist[v] + G[v][i]) {
                        dist[i] = dist[v] + G[v][i];
                        dist2[i] = dist2[v] + weight[i]; // ����Ȩ�غ�
                        path[i] = v;
                        num[i] = num[v]; // ����·���� ���·����ͬʱ����
                    }else if(dist[i] == dist[v] + G[v][i]) { // ·����ͬ
                        num[i] += num[v];
                        if(dist2[i] < dist2[v] + weight[i]) { // ��Ԯ����
                            dist2[i] = dist2[v] + weight[i]; // ����Ȩ�غ�
                            path[i] = v; // ����·��
                        }
                    }
                }
            }
        }

        out.println(num[end] + " " + dist2[end]);
        Stack<Integer> stack = new Stack();
        stack.push(end);
        do {
            stack.push(path[end]);
            end = path[end];
        }while (end != start);
        int size = stack.size();
        for(int i = 0; i < size; i++){
            out.print(stack.pop());
            if(i+1 != size) {
                out.print(" ");
            }
        }

        return true;
    }

    static int distMin(int[] dist, boolean[] v) {
        int min = MAX;
        int minIndex = -1;
        for(int i = 0; i < Nv; i++) {
            if(v[i] == false && min > dist[i]){
                min = dist[i];
                minIndex = i;
            }
        }
        return  minIndex;
    }

    /** ��ͼ, �ڽӾ��� */
    static void buildGraph(FR cin){
        G = new int[Nv][Nv];
        /** һ��ʼͼ����ͨ */
        for (int i = 0; i < Nv; i++) {
            Arrays.fill(G[i], MAX);
        }
        for (int i = 0; i < Ne; i++){
            int v1 = cin.nextInt(), v2  = cin.nextInt();
            int l = cin.nextInt();
            /** ����ͼ*/
            G[v1][v2] = l; G[v2][v1] = l;
        }
    }


    static class FR {
        BufferedReader br;
        StringTokenizer tk;

        FR(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream), 32768);
            tk = null;
        }

        String next() {
            while (tk == null || !tk.hasMoreElements()) {
                try {
                    tk = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tk.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static void solve(InputStream stream, PrintWriter out) {
        FR cin = new FR(stream);
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        start = cin.nextInt();
        end = cin.nextInt();
        weight = new int[Nv];
        for(int i = 0; i < Nv ; i++) {
            weight[i] = cin.nextInt();
        }
        buildGraph(cin);
        int[] dist = new int[Nv];
        int[] path = new int[Nv];
        dijkstra(dist, path, out);

    }

    public static void main(String[] args) {
        OutputStream os = System.out;
        InputStream is = System.in;
        PrintWriter out = new PrintWriter(os);
        solve(is, out);
        out.close(); // ���رվ�û�����
    }
}
