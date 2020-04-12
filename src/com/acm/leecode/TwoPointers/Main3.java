package com.acm.leecode.TwoPointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个整数数组，判断是否存在重复元素
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 *
 * @author ymj
 * @Date： 2019/12/14 23:44
 */
public class Main3 {

    /** 方法1 */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap(n);
        int left = 0, right = 0;
        /** left right 之间模拟的是类似队列形式 */
        while (left < n && right < n) {
            char c = s.charAt(right);
            if(map.containsKey(c)) {
                if (map.get(c) >= left){ // 不考虑之前重复的（队列之外的）
                    left = map.get(c) + 1;
                }
            }
            ans = Math.max(ans, right - left +1);
            map.put(c, right++);
        }
        return ans;
    }



    /**  方法 2 */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Main3().lengthOfLongestSubstring("abcabcbb") );
    }
}
