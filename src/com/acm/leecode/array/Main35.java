package com.acm.leecode.array;

import java.util.Scanner;

/**
 * 35 Insert Position
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * @author ymj
 * @Date： 2020/1/22 22:11
 */
public class Main35 {

    static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(new Main35().searchInsert(new int[]{1, 3, 5, 6}, 4));


    }

    /**
     * 通过二分法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1 ;

        return binSearch(nums, target, low, high);
    }

    public static int binSearch(int[] nums, int target, int low, int high) {
        int mid;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            }else if (nums[mid] < target){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return low;
    }
}
