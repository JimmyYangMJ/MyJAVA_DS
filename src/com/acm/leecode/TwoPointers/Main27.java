package com.acm.leecode.TwoPointers;

/**
 * 27. Remove Element
 *  给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，
 *  并返回移除后数组的新长度。
 * 移除元素
 * @author ymj
 * @Date： 2019/12/19 20:20
 */
public class Main27 {

    /** 1. 删除之后相对位置不变的情况（快指针，慢指针）
     *  2. 对于删除后相对位置可变的情况 可以 设置 一前一后 的指针
     */
    public int removeElement(int[] nums, int val) {
        // 定义快指针 和 慢指针
        // （慢指针之前的元素弄好的， 慢指针指向的元素是要删除的）
        int fast = 0, slow = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        new Main27().removeElement(new int[]{3, 2, 2, 3}, 3);
    }

}
