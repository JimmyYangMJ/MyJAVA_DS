package com.acm.leecode.String;

/**
 * 58. ���һ�����ʵĳ���
 *  Length of Last Word
 *  ����һ����������Сд��ĸ�Ϳո�?' '?���ַ��������������һ�����ʵĳ��ȡ�
 *
 * ������������һ�����ʣ��뷵�� 0?��
 *
 * ˵����һ��������ָ����ĸ��ɣ����������κοո���ַ�����
 *
 * ʾ��:
 * ����: "Hello World"
 * ���: 5
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/length-of-last-word
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author ymj
 * @Date�� 2019/12/22 12:50
 */
public class Main58 {
    /**
     * ����1 �� ���ÿ⺯�� split ��ʱ�临�ӶȽϸߣ�
     *         String[] s1 = s.split(" +");
     *         if (s1.length-1 >= 0) {
     *             return s1[s1.length-1].length();
     *         }else {
     *             return 0;
     *         }
     *  ����2�����£�ͨ���Ӻ���ǰɨ��
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
