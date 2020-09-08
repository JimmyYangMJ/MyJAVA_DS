package com.acm.leecode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ymj
 * @Date： 2020/8/25 15:54
 * @description: 不邻接植花
 *     作者：Jiachen_Zhang
 *     链接：https://leetcode-cn.com/problems/flower-planting-with-no-adjacent/solution/jian-dan-de-ran-se-wen-ti-bu-xu-yao-kao-lu-hui-su-/
 */
public class Main1042 {
    /**
     * 输入：N = 3, paths = [[1,2],[2,3],[3,1]]
     * 输出：[1,2,3]
     * @param N
     * @param paths
     * @return
     */
    public int[] gardenNoAdj(int N, int[][] paths) {
        /* 这是一道简单题，限制每个节点的度为3，同时提供四种颜色，因此不需要回溯 */
        /* 初始化节点，使用map保存节点与其临界点的关系 */
        /* 第一版本采用了内部类构建，参考评论区的HashMap更简洁 */
        /** 邻接表*/
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }
        /* 初始化路径信息 */
        for (int[] path: paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];
            /* 查看当前节点的所有邻接点的色彩 */
            for (int adj: graph.get(i)) {
                used[res[adj]] = true;
            }
            /* 为当前节点染色 */
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    res[i] = j;
                }
            }
        }
        return res;
    }


}
