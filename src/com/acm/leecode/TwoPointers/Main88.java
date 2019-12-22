package com.acm.leecode.TwoPointers;

/**
 * 88. 合并两个有序数组
 * Merge Sorted Array
 * 给定两个有序整数数组?nums1 和 nums2，将 nums2 合并到?nums1?中，使得?num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化?nums1 和 nums2 的元素数量分别为?m 和 n。
 * 你可以假设?nums1?有足够的空间（空间大小大于或等于?m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出:?[1,2,2,3,5,6]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * @author ymj
 * @Date： 2019/12/20 15:45
 */
public class Main88 {
    /**
     * 方法1 ： 将俩个数组合并后排序
     *         时间复杂度： O((n+m)log(n+m))
     *         空间复杂度 : O(1)。
     * 方法2： 使用两个指针，
     *        从两个数组的前面开始扫描，按照大小，放在第三方数组中
     *        时间复杂度 : O(n + m)。
     *         空间复杂度 : O(m)。
     * 方法3： 从 一个大空间数组的尾部开始 从后向前 扫描 （较优解）
     *          时间复杂度 : O(n + m)。
     *          空间复杂度 : O(1)。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int p1 = m - 1, p2 = n - 1;
        while(p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
        // 将 num2剩余的拷贝到 num1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        new Main88().merge(new int[]{1,2,3,0,0,0},0,  new int[]{2,5,6},1);
    }
}
