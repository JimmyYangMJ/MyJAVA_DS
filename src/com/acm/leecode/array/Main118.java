package com.acm.leecode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 方法：动态规划 / 递归
 * @author ymj
 * @Date： 2020/3/22 20:57
 */
public class Main118 {

    /**
     * 使用动态规划(迭代) / 或者递归
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();
        if(numRows == 0){
            return dp;
        }
        dp.add(new ArrayList<>());
        dp.get(0).add(1);
        //注意这里的 i 是指行数，但是dp是从0开始的
        //所以preRow是i-2
        for(int i = 2;i <= numRows;i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = dp.get(i-2);
            row.add(1);
            for(int j = 1;j < i-1;j++){
                row.add(preRow.get(j) + preRow.get(j-1));
            }
            row.add(1);
            dp.add(row);
        }
        return dp;
    }

    /** 使用递归 */
    public List<List<Integer>> generate(int numRows) {
        //存储要返回的杨辉三角
        List<List<Integer>> dg = new ArrayList<>();
        //若0行，则返回空
        if(numRows == 0){
            return dg;
        }
        //递归出口，这是第一步！找到出口
        if(numRows == 1){
            dg.add(new ArrayList<>());
            dg.get(0).add(1);
            return dg;
        }
        //递归，注意返回值！！！这是第二步
        dg = generate(numRows-1);

        List<Integer> row = new ArrayList<>();
        row.add(1); // 第一个元素
        for(int j = 1;j < numRows - 1;j++){
            row.add(dg.get(numRows-2).get(j-1) + dg.get(numRows-2).get(j));
        }
        row.add(1);
        dg.add(row);
        return dg;
    }

    public static void main(String[] args) {

    }

}
