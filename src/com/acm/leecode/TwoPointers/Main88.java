package com.acm.leecode.TwoPointers;

/**
 * 88. �ϲ�������������
 * Merge Sorted Array
 * ��������������������?nums1 �� nums2���� nums2 �ϲ���?nums1?�У�ʹ��?num1 ��Ϊһ���������顣
 *
 * ˵��:
 *
 * ��ʼ��?nums1 �� nums2 ��Ԫ�������ֱ�Ϊ?m �� n��
 * ����Լ���?nums1?���㹻�Ŀռ䣨�ռ��С���ڻ����?m + n�������� nums2 �е�Ԫ�ء�
 * ʾ��:
 *
 * ����:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * ���:?[1,2,2,3,5,6]
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-sorted-array
 * @author ymj
 * @Date�� 2019/12/20 15:45
 */
public class Main88 {
    /**
     * ����1 �� ����������ϲ�������
     *         ʱ�临�Ӷȣ� O((n+m)log(n+m))
     *         �ռ临�Ӷ� : O(1)��
     * ����2�� ʹ������ָ�룬
     *        �����������ǰ�濪ʼɨ�裬���մ�С�����ڵ�����������
     *        ʱ�临�Ӷ� : O(n + m)��
     *         �ռ临�Ӷ� : O(m)��
     * ����3�� �� һ����ռ������β����ʼ �Ӻ���ǰ ɨ�� �����Ž⣩
     *          ʱ�临�Ӷ� : O(n + m)��
     *          �ռ临�Ӷ� : O(1)��
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
        // �� num2ʣ��Ŀ����� num1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        new Main88().merge(new int[]{1,2,3,0,0,0},0,  new int[]{2,5,6},1);
    }
}
