package com.acm.leecode.Greedy;

import com.java.Comparator.Main;

/**
 * 392. �ж�������
 * �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
 * ����
 * @author ymj
 * @Date�� 2019/12/11 20:48
 */
public class Main392 {
    /**
     * ������ �ַ�������
     */
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        char[] t1 = t.toCharArray();
        for (int i = 0; i < t.length(); i++){
            if(index >= s.length()){
                return true;
            }
            if(t1[i] == s.charAt(index)) {
                index++;
            }
        }
        if(index >= s.length()){
            return true;
        }else{
            return false;
        }

    }
    public static void main(String[] args) {
        Main392 main392 = new Main392();
        System.out.println(main392.isSubsequence("axc", "ahbgdc"));
    }
}
