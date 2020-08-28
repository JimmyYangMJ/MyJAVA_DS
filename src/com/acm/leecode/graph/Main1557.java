package com.acm.leecode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ymj
 * @Date： 2020/8/25 16:26
 * @description:  1557. 可以到达所有点的最少点数目
 */
public class Main1557 {
    /**
     * 输入：n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
     * 输出：[0,3]
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> canArrive = new HashSet<>();
        // 有入度的点
        for (int i = 0; i < edges.size(); i++) {
            int W = edges.get(i).get(1);
            canArrive.add(W);
        } // 1 2 5 4
        // 有入度的点都是可由其他点到达的，（充要条件）
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!canArrive.contains(i))
                res.add(i);
        }
        return res;
    }

}
