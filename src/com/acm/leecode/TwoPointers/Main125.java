package com.acm.leecode.TwoPointers;


/**
 * 125. 验证回文串
 * Valid Palindrome
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author ymj
 * @Date： 2019/12/21 20:21
 */
public class Main125 {
    /**
     * 调用库函数 (用时较大)
     * 用双指针 更好 一点
     */
    public boolean isPalindrome(String s) {

        /** 除去非 字母和数字 */
        String s1 = s.replaceAll("[^0-9|^a-z|^A-Z]", "");
        // 小写
        s1 = s1.toLowerCase();
        char[] s2 = s.toCharArray();
        for (int i = 0; i < s1.length()/2; i++) {
            if(s2[i] != s2[s1.length()-1-i]) {
                return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Main125().isPalindrome("`l;`` 101 ??;l`"));
    }

}
