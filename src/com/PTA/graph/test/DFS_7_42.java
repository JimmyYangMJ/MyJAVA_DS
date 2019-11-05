package com.PTA.graph.test;

import java.util.Scanner;

/**
 * 拯救 007
 * DFS， 没有使用图的存储
 */
public class DFS_7_42 {

    static Scanner cin = new Scanner(System.in);
    /** 鳄鱼数量 N（≤100）*/
    static int n;
    /** 007一次能跳跃的最大距离 */
    static int d;
    static boolean[] jump;
    static C[] graph;
    static boolean[] visited;
    static boolean answer;

    /** 鳄鱼的坐标*/
    static class C{
        int x;
        int y;
        C(){}
        C(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /** 可以直接跳上岸的鳄鱼 */
    static void judgeJump() {
        for (int i = 1; i <= n; i++) {
            int x = graph[i].x;
            int y = graph[i].y;
            if(x >= 50-d || x <= -50+d || y >= 50-d || y <= -50+d) {
                jump[i] = true;
            }
        }
    }

    static void buildGraph() {
        graph[0] = new C(0, 0);
        for (int i = 1; i <= n; i++) {
            int x = cin.nextInt();
            int y = cin.nextInt();
            graph[i] = new C(x, y);
        }
    }

    static boolean judgeDistance(C a, C b, int d) {
        double  temp = Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));
        if (temp <= d){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 递归遍历
     * @param head 开始结点
     * @return 是否可以跳上岸
     */
    static boolean DFS(int head) {
        visited[head] = true;
        if (jump[head] == true){
            answer = true;
        }else{
            for (int i = 1; i <= n; i++) {
                /** 没有访问过， 可以跳到 */
                boolean judge;
                if (head == 0) { // 第一跳
                    judge = judgeDistance(graph[head], graph[i], d+15);
                }else {
                    judge = judgeDistance(graph[head], graph[i], d);
                }
                if (visited[i] == false && judge) {
                    answer = DFS(i);
                    if (answer == true){
                        break;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        n = cin.nextInt();
        d = cin.nextInt();
        jump = new boolean[n+1];
        graph = new C[n+1];
        visited = new boolean[n+1];
        buildGraph();
        judgeJump();
        C people = new C(0, 0);
        boolean result = DFS(0);
        if (d+15 >= 50){ // 直接可以跳上岸
            System.out.print("Yes");
        }else if (result == true){
            System.out.print("Yes");
        }else {
            System.out.print("No");
        }
    }
}
