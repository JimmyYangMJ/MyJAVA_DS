package com.PTA.graph.test;

import java.util.Scanner;

/**
 * ����˹���ġ��������⡱
 * �ڽӱ�, ������Ȩͼ
 * @author ymj
 * @Date�� 2019/12/10 15:02
 */
public class Main {

    static Vnode[] vnodes;
    static int Nv, Ne;
    static boolean flag = true;
    static Scanner cin = new Scanner(System.in);

    /** �ж�ͼ�Ƿ���ͨ DFS �ݹ��㷨*/
    static void DFS(boolean[] visit, int start) {
        visit[start] = true;
        Node node = vnodes[start].point;
        while(node != null) {
            if(visit[node.id] == false) { // δ����
                DFS(visit, node.id);
            }
            node = node.next;
        }
    }

    // �ڽӱ�洢
    /** �ڽӱ� <��ͷ���>
     * �±���Ǳ�ʾ ����*/
    static class Vnode {
        int degree = 0;
        Node point = null;
    }
    /** ��� */
    static class Node {
        int id;
        Node next = null;
        Node(int id, Node next){
            this.id = id;
            this.next = next;
        }
    }
    static void buildGraph(){
        /** �ڽӱ� ͷ�ڵ㣺vnodes*/
        vnodes = new Vnode[Nv+1];
        for (int i = 0; i <= Nv; i++) { // ����ռ�
            vnodes[i] = new Vnode();
        }
        for (int i = 1; i <= Ne ; i++) {
            int start = cin.nextInt();
            int end = cin.nextInt();
            vnodes[start].point = new Node(end, vnodes[start].point);
            vnodes[start].degree++;
            /** ����������ͼ */
            vnodes[end].point = new Node(start, vnodes[end].point);
            vnodes[end].degree++;
        }
    }

    public static void main(String[] args) {
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        buildGraph();
        for (int i = 1; i <= Nv; i++) {
            if(vnodes[i].degree % 2 != 0) {
                flag = false;
                break;
            }
        }
        boolean[] visited = new boolean[Nv+1];

        DFS(visited, 1);
        for (int i = 1; i <= Nv; i++) {
            if(visited[i] == false) {
                flag = false;
                break;
            }
        }

        if(flag == true){
            System.out.println("1");
        }else {
            System.out.println("0");
        }

    }
}
