package com.acm.algrithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Tarjan {
    private int numOfNode;
    static Tarjan t;
    private List<ArrayList<Integer>> graph;// 图
    private List<ArrayList<Integer>> result;// 保存极大强连通图

    private boolean[] inStack;// 节点是否在栈内
    private Stack<Integer> stack;

    /** 时间戳，第几个访问的*/
    private int[] dfn;
    private int[] low;
    private int time;

    /**
     * 初始化操作，
     * @param graph  图，List Array（二维数组存储）
     * @param numOfNode  vertical
     */
    public Tarjan(List<ArrayList<Integer>> graph, int numOfNode) {
        this.graph = graph;
        this.numOfNode = numOfNode;
        this.inStack = new boolean[numOfNode];
        this.stack = new Stack<>();
        dfn = new int[numOfNode];
        low = new int[numOfNode];

        Arrays.fill(dfn, -1);// 将dfn所有元素都置为1，其中dfn[i]=-1代表这个点没有被访问过
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
        /** 从0开始存储*/
        dfn[current] = low[current] = time++;
        show();
        inStack[current] = true;
        stack.push(current);

        for (int i = 0; i < graph.get(current).size(); i++) {
            int next = graph.get(current).get(i); // 遍历 current 有边 指向的顶点
            if (dfn[next] == -1) {  // 该顶点没有访问过
                tarjan(next);  // 对该节点 DFS
                /** 本来low 和 dfn相等，但是出现环路后，
                 * 更新low 指向环路的根（强连通图的根）
                 * min 是要找最原始的根，即出现时间最早的*/
                low[current] = Math.min(low[current], low[next]);
                show();  // useless
            } else if (inStack[next]) {  // 该顶点访问过了
                /** 更新low*/
                low[current] = Math.min(low[current], dfn[next]);
                show(); // useless
            }
        }
        /**
         * 当前current 点已经没有出度，或没有未访问的结点
         * 当low == dfn;
         * current 此时为一个强连通分量的根
         */
        System.out.print("zz");
        stack.forEach(e -> System.out.print(e + " "));
        System.out.println("zz");
        if (low[current] == dfn[current]) {
            /** temp暂时存储一个强连通分量*/
            ArrayList<Integer> temp = new ArrayList<>();
            int j = -1;
            /** 出栈，直到退到一个强连通分量的根*/
            while (current != j) {
                j = stack.pop();
                inStack[j] = false;  //标记不在栈中
                temp.add(j);
            }
            result.add(temp);
        }
    }

    /**
     * 主要函数，防图不连通
     * @return  强连通分量的集合
     */
    public List<ArrayList<Integer>> run() {
        for (int i = 0; i < numOfNode; i++) {
            if (dfn[i] == -1)
                tarjan(i);
        }
        return result;
    }

    public static void main(String[] args) {

        // 创建图
        int numOfNode = 8;  // vertical
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numOfNode; i++) {
            graph.add(new ArrayList<>());
        }
        /** list.ArrayList*/
        graph.get(0).add(1); // 0 指向 1
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
         * 打印结果
         */
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
