package com.acm.leecode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author ymj
 * @Date： 2019/12/11 18:50
 */
public class Main1 {
    /**
     *  1.暴力法
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for(int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;

    }

    public static void main(String[] args) {
        int[] nums = {3,3,4};
        int target = 6;
        for (int temp : twoSum2(nums, target)) {
            System.out.println(temp + " ");
        }
    }

    /**
     * 2. 两遍哈希表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
