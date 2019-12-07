package com.acm.test.recursion;

import java.util.*;

/**
 * 全排列
 * @author ymj
 * @Date： 2019/11/12 20:17
 */
public class Test01 {

    static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        int[] num = {1,2,3};
        List<List<Integer>> arrayList = permute(num);
        for (List<Integer> list : arrayList) {
            System.out.println(list);
        }

    }

    public static List<List<Integer>> permute(int[] num) {

        /** 存放结果集 */
        List<List<Integer>> output = new LinkedList();
        /** 要排列的串*/
        ArrayList<Integer> nums_list = new ArrayList<>();
        for (int temp : num) {
            nums_list.add(temp);
        }
        backtrack(nums_list, output, 0, num.length);

        return output;
    }

    /**
     *
     * @param nums 整个要排列的 字符串
     * @param output 存放结果集
     * @param first 开始
     * @param end 结束
     */
    public static void backtrack(ArrayList<Integer> nums, List<List<Integer>> output, int first, int end){


        if (first == end) { // 一组排列完成
            output.add(new ArrayList<Integer>(nums));
        }
        for (int i = first; i < end; i++) {
            Collections.swap(nums, first, i);

            backtrack(nums, output, first+1, end);
            /** 交换回来, 防止冲突 */
            Collections.swap(nums, first, i);
        }
    }

}
