package com.acm.leecode.String;

/**
 * 58. 最后一个单词的长度
 *  Length of Last Word
 *  给定一个仅包含大小写字母和空格?' '?的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0?。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author ymj
 * @Date： 2019/12/22 12:50
 */
public class Main58 {
    /**
     * 方法1 ： 利用库函数 split （时间复杂度较高）
     *         String[] s1 = s.split(" +");
     *         if (s1.length-1 >= 0) {
     *             return s1[s1.length-1].length();
     *         }else {
     *             return 0;
     *         }
     *  方法2：如下，通过从后往前扫描
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        boolean flag = false;
        int count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
           if(s.charAt(i) == ' ' && flag == false) {
               continue;
           }if (s.charAt(i) == ' ' && flag == true){
               break;
           } else{
               flag = true;
               count++;
           }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Main58().lengthOfLastWord(" asdf asdf asdf  "));
    }
}
