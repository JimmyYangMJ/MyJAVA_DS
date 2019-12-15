package com.acm.leecode.divideAndConquer;

/**
 * 169 多数元素 Majority Element
 * @author ymj
 * @Date： 2019/12/11 13:20
 */
public class Main169 {

    // 在范围lo， hi 内 num 出现几次
    private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    // 分治算法接口
    private static int divideAndConquer(int[] nums, int left, int right) {
        if(left == right) {
            return nums[left];
        }else{
            int mid = (right - left)/2 + left;
            int l = divideAndConquer(nums, left, mid);
            int r = divideAndConquer(nums, mid+1, right);

            if(l == r){ // 两边众数相等
                return l;
            }else{
                int leftCount = countInRange(nums, l, left, right);
                int rightCount = countInRange(nums, r, left, right);
                return leftCount > rightCount ? l : r;
            }
        }
    }

    // 分治法
    public int majorityElement(int[] nums) {
        return divideAndConquer(nums, 0, nums.length-1);
    }
    public static void main(String[] args) {
        int[] nums ={3, 2, 3};
        Main169 main169 = new Main169();
        System.out.println(main169.majorityElement(nums));
    }
}
