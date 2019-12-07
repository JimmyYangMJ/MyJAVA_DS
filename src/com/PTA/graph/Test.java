package com.PTA.graph;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {

    static int Nv, Ne;
    static int[][] G;
    static int[] sumMin;
    static void buildGraph(InputStream stream, FR cin) {
        for(int i = 1; i <= Nv; i++){
            Arrays.fill(G[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i < Ne; i++){
            int start, end, w;
            start = cin.nextInt();
            end = cin.nextInt();
            w = cin.nextInt();
            G[start][end] = w;
            G[end][start] = w;
        }
    }

    static int[] prime(int start){

        int[] path = new int[Nv+1];
        int[] dist = new int[Nv+1];
        boolean[] visit = new boolean[Nv+1];
        Arrays.fill(path, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 1; i <= Nv; i++) {
            if(G[start][i] < Integer.MAX_VALUE) {
                dist[i] = G[start][i];
                path[i] = 1;
            }
        }
        int flag = 1;
        visit[start] = true;
        while(true) {
            int v = distMin(dist, visit);
            if(v == 0){
                break;
            }
            visit[v] = true;
            flag++;
            for(int i =1; i <= Nv; i++) {
                if(visit[i] == false && G[v][i] < Integer.MAX_VALUE){
                    if(dist[i] > G[v][i] + dist[v]) {
                        dist[i] = G[v][i] + dist[v];
                        path[i] = v;
                    }
                }
            }
        }
        if(flag != Nv){
            return null;
        }
        int a = 0;
        for(int i =1; i <=Nv; i++){
            if(i!=start && a < dist[i]){
                a = dist[i];
            }
        }
        sumMin[start] = a;
        return dist;
    }
    public static int distMin(int[] dist, boolean[] visit) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 1; i <= Nv; i++){
            if(visit[i] == false && dist[i] < min) {
                min= dist[i];
                minIndex = i;
            }
        }
        return minIndex;
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
        sumMin = new int[Nv+1];
        G = new int[Nv+1][Nv+1];
        buildGraph(stream, cin);
        for(int i = 1; i <= Nv; i++){
            if(prime(i) == null){
                System.out.print("0");
                System.exit(0);
            }
        }

        int min = Integer.MAX_VALUE;
        int index = 1;
        for(int i = 1; i<= Nv; i++) {
            if(sumMin[i] < min){
                min = sumMin[i];
                index = i;
            }
        }
        out.print(index + " "+ sumMin[index]);

    }

    public static void main(String[] args) {
        OutputStream os = System.out;
        InputStream is = System.in;
        PrintWriter out = new PrintWriter(os);
        solve(is, out);
        out.close(); // 不关闭就没有输出
    }
}
