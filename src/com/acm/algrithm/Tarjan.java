package com.acm.algrithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Tarjan {
    private int numOfNode;
    static Tarjan t;
    private List<ArrayList<Integer>> graph;// ͼ
    private List<ArrayList<Integer>> result;// ���漫��ǿ��ͨͼ

    private boolean[] inStack;// �ڵ��Ƿ���ջ��
    private Stack<Integer> stack;

    /** ʱ������ڼ������ʵ�*/
    private int[] dfn;
    private int[] low;
    private int time;

    /**
     * ��ʼ��������
     * @param graph  ͼ��List Array����ά����洢��
     * @param numOfNode  vertical
     */
    public Tarjan(List<ArrayList<Integer>> graph, int numOfNode) {
        this.graph = graph;
        this.numOfNode = numOfNode;
        this.inStack = new boolean[numOfNode];
        this.stack = new Stack<>();
        dfn = new int[numOfNode];
        low = new int[numOfNode];

        Arrays.fill(dfn, -1);// ��dfn����Ԫ�ض���Ϊ1������dfn[i]=-1���������û�б����ʹ�
        Arrays.fill(low, -1);//

        result = new ArrayList<>();
    }

    public static void show(){

        for(int temp: t.dfn){
            System.out.print(temp + " ");
        }
        System.out.println();
        for(int temp: t.low){
            System.out.print(temp + " ");
        }
        System.out.println();
        System.out.println("==============================");
    }

    public void tarjan(int current) {
        /** ��0��ʼ�洢*/
        dfn[current] = low[current] = time++;
        show();
        inStack[current] = true;
        stack.push(current);

        for (int i = 0; i < graph.get(current).size(); i++) {
            int next = graph.get(current).get(i); // ���� current �б� ָ��Ķ���
            if (dfn[next] == -1) {  // �ö���û�з��ʹ�
                tarjan(next);  // �Ըýڵ� DFS
                /** ����low �� dfn��ȣ����ǳ��ֻ�·��
                 * ����low ָ��·�ĸ���ǿ��ͨͼ�ĸ���
                 * min ��Ҫ����ԭʼ�ĸ���������ʱ�������*/
                low[current] = Math.min(low[current], low[next]);
                show();  // useless
            } else if (inStack[next]) {  // �ö�����ʹ���
                /** ����low*/
                low[current] = Math.min(low[current], dfn[next]);
                show(); // useless
            }
        }
        /**
         * ��ǰcurrent ���Ѿ�û�г��ȣ���û��δ���ʵĽ��
         * ��low == dfn;
         * current ��ʱΪһ��ǿ��ͨ�����ĸ�
         */
        System.out.print("zz");
        stack.forEach(e -> System.out.print(e + " "));
        System.out.println("zz");
        if (low[current] == dfn[current]) {
            /** temp��ʱ�洢һ��ǿ��ͨ����*/
            ArrayList<Integer> temp = new ArrayList<>();
            int j = -1;
            /** ��ջ��ֱ���˵�һ��ǿ��ͨ�����ĸ�*/
            while (current != j) {
                j = stack.pop();
                inStack[j] = false;  //��ǲ���ջ��
                temp.add(j);
            }
            result.add(temp);
        }
    }

    /**
     * ��Ҫ��������ͼ����ͨ
     * @return  ǿ��ͨ�����ļ���
     */
    public List<ArrayList<Integer>> run() {
        for (int i = 0; i < numOfNode; i++) {
            if (dfn[i] == -1)
                tarjan(i);
        }
        return result;
    }

    public static void main(String[] args) {

        // ����ͼ
        int numOfNode = 8;  // vertical
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numOfNode; i++) {
            graph.add(new ArrayList<>());
        }
        /** list.ArrayList*/
        graph.get(0).add(1); // 0 ָ�� 1
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(4);
        graph.get(4).add(5);
        graph.get(5).add(6);
        graph.get(6).add(3);
        graph.get(3).add(7);
        graph.get(7).add(6);


        t = new Tarjan(graph, numOfNode);
        List<ArrayList<Integer>> result = t.run();

        /**
         * ��ӡ���
         */
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
