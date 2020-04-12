package com.acm.leecode.TwoPointers;

/**
 * 167两数之和 II - 输入有序数组
 * @author ymj
 * @Date： 2019/12/14 23:44
 */
public class Main167 {

    /**  方法1： 双指针 */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right) {
            if(numbers[left] + numbers[right] > target) {
                right--;
            }else if(numbers[left] + numbers[right] < target) {
                left++;
            }else {
                System.out.println(left + " " + right);
                return new int[]{left+1, right+1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Main167().twoSum(new int[]{-2,-1,0,0,0,2,2,5,5,7,7,7,7,9,11,12,13}, 8) );
    }
}
