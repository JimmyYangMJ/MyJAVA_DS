package com.acm.leecode.DFS;

import java.util.List;

/**
 * @author ymj
 * @Date： 2020/9/2 17:30
 * @description: 钥匙和房间
 *
 * DFS 和 BFS 均可
 */
public class Main841 {
    /**
     * 输入：[[1,3],[3,0,1],[2],[0]]
     * 输出：false
     * 解释：我们不能进入 2 号房间。
     */
    boolean[] vis;
    int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    public void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            if (!vis[it]) {
                dfs(rooms, it);
            }
        }
    }

}
