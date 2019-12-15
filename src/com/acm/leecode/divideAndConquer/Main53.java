package com.acm.leecode.divideAndConquer;

/**53 ������к�
 * ����1 ����
 * @author ymj
 * @Date�� 2019/12/14 18:52
 */
public class Main53 {

    /**
     * �����㷨
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        sum = maxSub(nums, 0, nums.length-1);
        System.out.println(sum);
        return sum;
    }

    /** ���κ����ӿ� */
    public static int maxSub(int[] nums, int start, int end) {
        if(start == end) {
            return nums[start];
        }else {
            int mid = (end - start)/2 + start;
            int leftMax = maxSub(nums, start, mid);
            int rightMax = maxSub(nums, mid+1, end);
            // ��Խ�߽�����
            int midLeftMax = nums[mid], midRightMax = nums[mid+1];
            int midLeftSum = 0, midRightSum = 0;
            for(int i = mid; i >= start; i--){
                midLeftSum += nums[i];
                if (midLeftMax < midLeftSum) {
                    midLeftMax = midLeftSum;
                }
            }
            for(int i = mid+1; i <= end; i++){
                midRightSum += nums[i];
                if (midRightMax < midRightSum) {
                    midRightMax = midRightSum;
                }
            }
            return max3(leftMax, rightMax, midLeftMax + midRightMax);

        }
    }

    /** ����������������*/
    private static int max3(int a, int b, int c) {
        return a > b ? a > c ? a : c : b > c ? b : c;
    }

    public static void main(String[] args) {
        Main53 main53 = new Main53();
        main53.maxSubArray(new int[]{-2,0});

    }
}
