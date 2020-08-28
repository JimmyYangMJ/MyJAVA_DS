package com.acm.leecode.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ymj
 * @Date： 2020/8/24 15:22
 * @description: 448. 找到所有数组中消失的数字
 */
public class Main448 {

    /**
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * 输出:
     * [5,6]
     *
     * 使用额外空间：hash
     * 不使用： 原地 更改数组内容： 如果某数字存在，那么在对应数字 下标的数 变为负数
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {


        for (int i = 0; i < nums.length; i++) {

            // Treat the value as the new index
            int newIndex = Math.abs(nums[i]) - 1;

            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Main448().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }


}
