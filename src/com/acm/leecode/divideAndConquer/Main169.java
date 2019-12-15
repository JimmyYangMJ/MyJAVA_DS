package com.acm.leecode.divideAndConquer;

/**
 * 169 ����Ԫ�� Majority Element
 * @author ymj
 * @Date�� 2019/12/11 13:20
 */
public class Main169 {

    // �ڷ�Χlo�� hi �� num ���ּ���
    private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    // �����㷨�ӿ�
    private static int divideAndConquer(int[] nums, int left, int right) {
        if(left == right) {
            return nums[left];
        }else{
            int mid = (right - left)/2 + left;
            int l = divideAndConquer(nums, left, mid);
            int r = divideAndConquer(nums, mid+1, right);

            if(l == r){ // �����������
                return l;
            }else{
                int leftCount = countInRange(nums, l, left, right);
                int rightCount = countInRange(nums, r, left, right);
                return leftCount > rightCount ? l : r;
            }
        }
    }

    // ���η�
    public int majorityElement(int[] nums) {
        return divideAndConquer(nums, 0, nums.length-1);
    }
    public static void main(String[] args) {
        int[] nums ={3, 2, 3};
        Main169 main169 = new Main169();
        System.out.println(main169.majorityElement(nums));
    }
}
