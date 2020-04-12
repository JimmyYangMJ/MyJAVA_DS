package com.acm.leecode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. ����֮��
 * ����һ���������� nums?��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ����?����?���������������ǵ������±ꡣ
 *
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/two-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author ymj
 * @Date�� 2019/12/11 18:50
 */
public class Main1 {
    /**
     *  1.������
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for(int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;

    }

    public static void main(String[] args) {
        int[] nums = {3,3,4};
        int target = 6;
        for (int temp : twoSum2(nums, target)) {
            System.out.println(temp + " ");
        }
    }

    /**
     * 2. �����ϣ��
     * һ���򵥵�ʵ��ʹ�������ε������ڵ�һ�ε����У����ǽ�ÿ��Ԫ�ص�ֵ������������ӵ����С�
     * Ȼ���ڵڶ��ε����У����ǽ����ÿ��Ԫ������Ӧ��Ŀ��Ԫ�أ�target - nums[i] ���Ƿ�����ڱ��С�ע�⣬��Ŀ��Ԫ�ز����� nums[i]����
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /** ��������һ���ϣ��
     ��ʵ֤�������ǿ���һ����ɡ��ڽ��е�������Ԫ�ز��뵽���е�ͬʱ��
     ���ǻ���ع�ͷ���������Ƿ��Ѿ����ڵ�ǰԪ������Ӧ��Ŀ��Ԫ�ء�
     ��������ڣ��������Ѿ��ҵ��˶�Ӧ�⣬���������䷵�ء�
     ���ߣ�LeetCode
     ���ӣ�https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
     ��Դ�����ۣ�LeetCode��
     ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
