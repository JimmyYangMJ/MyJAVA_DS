package com.acm.leecode.TwoPointers;


/**
 * 125. ��֤���Ĵ�
 * Valid Palindrome
 * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
 *
 * ˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���
 *
 * ʾ�� 1:
 *
 * ����: "A man, a plan, a canal: Panama"
 * ���: true
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/valid-palindrome
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author ymj
 * @Date�� 2019/12/21 20:21
 */
public class Main125 {
    /**
     * ���ÿ⺯�� (��ʱ�ϴ�)
     * ��˫ָ�� ���� һ��
     */
    public boolean isPalindrome(String s) {

        /** ��ȥ�� ��ĸ������ */
        String s1 = s.replaceAll("[^0-9|^a-z|^A-Z]", "");
        // Сд
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
