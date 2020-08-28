package com.acm.leecode.array;

/**
 * @author ymj
 * @Date： 2020/7/17 15:51
 * @description: 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class Main53 {



    /** 二分法 */
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) { // 在右边
                left = mid + 1;
            } else { // 下标本身 | 在 左边
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = {0,1,2,3,5};
        System.out.println(new Main53().missingNumber(nums));
    }
}
