package com.acm.algrithm;

import java.util.Scanner;

/**
 * ǰ׺������
 * ������洢Ϊǰk��ĺ�
 */
public class PrefixSum {

    public static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        int L, W;
        L = cin.nextInt();
        W = cin.nextInt();
        int[][] c = new int[L+1][W+1];

        for(int i = 1; i <= L; i++){
            for(int j = 1; j <= W; j++) {
                c[i][j] = cin.nextInt();
                /** ��ǰ׺��*/
                c[i][j] = c[i][j] + c[i][j-1] + c[i-1][j] - c[i-1][j-1];
            }
        }
        /**
         * ��ά��ǰ׺�� ������Ϊĳһ�㵽���Ͻǵ������
         * Ӧ�ã� ͨ��ǰ׺�ͣ�����ͨ������ļӼ�������ĳһ��������
         */
        for(int i = 1; i <= L; i++){
            for(int j = 1; j <= W; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        /**
         * ���⣺ �Ͻ���OJ 1002�������ֻ���
         * RMQ (Range Minimum/Maximum Query) ����
         */
    }
}
