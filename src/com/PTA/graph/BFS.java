package com.PTA.graph;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * ��Ȩͼ�ĵ�Ԫ���·���㷨<br>
 * ʵ��----BFS <br>
 * ����----���ȿռ�
 * (ȱ�ݣ� ���ڱ߽���ԣ����N�� M ����
 * ���⣺https://blog.csdn.net/fairydeng/article/details/89470635)
 */
public class BFS {
    /**˼·�� ��ÿ�������й������
     * �ѵ㣺 �����Ľ���*/

    /** ������  1 ��ʼ*/
    static int Ne;
    static int Nv;
    /** ��� �±� �ڵ��Ƿ񱻷��� */
    static boolean [] visited;
    static Vnode[] vnodes;
    static Scanner cin = new Scanner(System.in);

    /** �ڽӱ� <��ͷ���>
     * �±���Ǳ�ʾ ����*/
    static class Vnode {
        Node point = null;
    }
    /** ��� */
    static class Node {
        int num;
        Node next = null;
    }
    /** ��ͼ, �ڽӱ� */
    static void BuildGraph(){
        /** �ڽӱ� ͷ�ڵ㣺vnodes*/
        for (int i = 1; i <= Ne ; i++) {
            int start = cin.nextInt();
            int end = cin.nextInt();
            // 1.
            Node temp = new Node();
            temp.num = end;
            temp.next = vnodes[start].point;
            vnodes[start].point = temp;
            /** ����������ͼ */
            // 2.
            temp = new Node();
            temp.num = start;
            temp.next = vnodes[end].point;
            vnodes[end].point = temp;

        }
    }

    /** ��ÿ�������� ����������� */
    static void sixDegree(){
        for (int i = 1; i <= Nv; i++) {
            int num = BFS(i);
            double rate = num*1.0/Nv;
            DecimalFormat df = new DecimalFormat("00.00%");
            System.out.println(i + ": " +df.format(rate));
        }
    }

    /**
     *
     * @param start ��ʼ�Ľ��
     * @return ��ϵ������ 6 ���ڵĽ����
     */
    static int BFS(int start){
        visited = new boolean[Nv+1];
        /** ��¼6�����ڵ���ص����� */
        int count = 1;
        /** ��¼���� */
        int level = 0;
        /** ��¼һ�������һ�����ʵĽ�� */
        int last = start;
        int tail = 0; // �������

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int  v = queue.poll();
            Node temp;
            temp = vnodes[v].point;
            while(temp != null) {
                if(temp != null && visited[temp.num] == false){
                    queue.add(temp.num);
                    count++;
                    visited[temp.num] = true;
                    tail = temp.num;
                }
                temp = temp.next;
            }
            if (v == last) {
                level++;
                last = tail;
            }
            if (level == 6) {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Nv = cin.nextInt();
        Ne = cin.nextInt();
        vnodes = new Vnode[Nv+1];
        for (int i = 0; i <= Nv; i++) { // ����ռ�
            vnodes[i] = new Vnode();
        }
        BuildGraph();
        sixDegree();
    }
}

