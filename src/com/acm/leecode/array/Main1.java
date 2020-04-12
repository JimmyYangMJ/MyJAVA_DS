package com.acm.leecode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums?和一个目标值 target，请你在该数组中找出和为目标值的那?两个?整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author ymj
 * @Date： 2019/12/11 18:50
 */
public class Main1 {
    /**
     *  1.暴力法
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
     * 2. 两遍哈希表
     * 一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。
     * 然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i] ）是否存在于表中。注意，该目标元素不能是 nums[i]本身！
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
    /** 方法三：一遍哈希表
     事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，
     我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
     如果它存在，那我们已经找到了对应解，并立即将其返回。
     作者：LeetCode
     链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
