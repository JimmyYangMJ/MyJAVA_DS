package com.acm.test.recursion;

import java.util.*;

/**
 * ȫ����
 * @author ymj
 * @Date�� 2019/11/12 20:17
 */
public class Test01 {

    static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        int[] num = {1,2,3};
        List<List<Integer>> arrayList = permute(num);
        for (List<Integer> list : arrayList) {
            System.out.println(list);
        }

    }

    public static List<List<Integer>> permute(int[] num) {

        /** ��Ž���� */
        List<List<Integer>> output = new LinkedList();
        /** Ҫ���еĴ�*/
        ArrayList<Integer> nums_list = new ArrayList<>();
        for (int temp : num) {
            nums_list.add(temp);
        }
        backtrack(nums_list, output, 0, num.length);

        return output;
    }

    /**
     *
     * @param nums ����Ҫ���е� �ַ���
     * @param output ��Ž����
     * @param first ��ʼ
     * @param end ����
     */
    public static void backtrack(ArrayList<Integer> nums, List<List<Integer>> output, int first, int end){


        if (first == end) { // һ���������
            output.add(new ArrayList<Integer>(nums));
        }
        for (int i = first; i < end; i++) {
            Collections.swap(nums, first, i);

            backtrack(nums, output, first+1, end);
            /** ��������, ��ֹ��ͻ */
            Collections.swap(nums, first, i);
        }
    }

}
