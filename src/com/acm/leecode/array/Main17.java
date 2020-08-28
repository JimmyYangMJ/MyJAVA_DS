package com.acm.leecode.array;

/**
 * @author ymj
 * @Date： 2020/8/21 16:00
 * @description: 面试题 17.04. 消失的数字
 */
public class Main17 {
    /**
     * 输入：[9,6,4,2,3,5,7,0,1]
     * 输出：8
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = (length + 1)* length / 2;
        for (int temp: nums){
            sum -= temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Main17().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}) );
    }
}
