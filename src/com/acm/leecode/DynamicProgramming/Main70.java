package com.acm.leecode.DynamicProgramming;

/**
 * 70 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Main70 {
    // 递归 会超时
    public int climbStairs2(int n) {
        if (n <= 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else if (n == 2) {
            return 2;
        }else {
            return climbStairs2(n-2) + climbStairs2(n-1);
        }
    }

    /** 递归改为动态规划
     <table border="1">
     <th>是否走 </th><th> 1 </th> <th> 2 </th><th> 3 </th>
     <tr><td> 0 </td><td> 1 </td><td> 1 </td><td> 2 </td>
     <tr><td> 1 </td><td> 1 </td><td> 2 </td><td> 3 </td>
     </table>
     <table border="1">
     <th>b | 1 | 2 | 3</th>
     <tr><td>0 | 1 | 2 | 3</td>
     <tr><td>1 | 1 | 2 | 3</td>
     </table>
     */
    public int climbStairs(int n) {
        int[] choice = {1, 1}; // 初始化 0 代表不走，1代表走
        for (int i = 2; i <= n; i++) {
            int temp0 =  choice[0]; // 记录覆盖前数据
            choice[0] = choice[1];
            choice[1] = temp0 + choice[1];
        }
        return choice[1];
    }

    public static void main(String[] args) {

        System.out.println(new Main70().climbStairs(5));
    }
}
