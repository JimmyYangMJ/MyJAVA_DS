package com.acm.leecode.DynamicProgramming;

/**
 * 70 ��¥��
 * ������������¥�ݡ���Ҫ n ������ܵ���¥����
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 */
public class Main70 {
    // �ݹ� �ᳬʱ
    public int climbStairs2(int n) {
        if (n <= 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else if (n == 2) {
            return 2;
        }else {
            return climbStairs2(n-2) + climbStairs2(n-1);
        }
    }

    /** �ݹ��Ϊ��̬�滮
     <table border="1">
     <th>�Ƿ��� </th><th> 1 </th> <th> 2 </th><th> 3 </th>
     <tr><td> 0 </td><td> 1 </td><td> 1 </td><td> 2 </td>
     <tr><td> 1 </td><td> 1 </td><td> 2 </td><td> 3 </td>
     </table>
     <table border="1">
     <th>b | 1 | 2 | 3</th>
     <tr><td>0 | 1 | 2 | 3</td>
     <tr><td>1 | 1 | 2 | 3</td>
     </table>
     */
    public int climbStairs(int n) {
        int[] choice = {1, 1}; // ��ʼ�� 0 �����ߣ�1������
        for (int i = 2; i <= n; i++) {
            int temp0 =  choice[0]; // ��¼����ǰ����
            choice[0] = choice[1];
            choice[1] = temp0 + choice[1];
        }
        return choice[1];
    }

    public static void main(String[] args) {

        System.out.println(new Main70().climbStairs(5));
    }
}
