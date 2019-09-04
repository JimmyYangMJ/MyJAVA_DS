package com.PTA.graph;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ���鼯
 * ���� - ����Ȧ
 */
public class Set {

    static Scanner cin = new Scanner(System.in);
    /** ���� */
    static int n;
    /** ����Ȧ��*/
    static int m;
    /** ���Ѽ��� ��1~N���, ������ʾ����������-4��ʾ����4����*/
    static int[] s;

    /** �ҵ�һ��������ڵļ���*/
    static int find(int x) {
        if (s[x] < 0) { /* ����Ϊһ������*/
            return x;
        }else {
            return s[x] = find(s[x]);
        }
    }

    /** �ϲ�����*/
    static int union(int root1, int root2) {
        if(s[root1] > s[root2]) { /* �������2�Ƚϴ� */
            s[root2] += s[root1];
            s[root1] = root2;    /* ����1���뼯��2  */
            return  root2;
        }else{
            s[root1] += s[root2];
            s[root2] = root1;    /* ����2���뼯��1  */
            return  root1;
        }

    }

    /** һ�������뼯��*/
    static void inputSet(){
        /** һ������Ȧ������*/
        int num;
        num = cin.nextInt();
        int p, root1, root2;
        p = cin.nextInt();
        root1 = find(p);
        for (int i = 1; i < num; i++) {
            p = cin.nextInt();
            root2 = find(p);
            if(root1 != root2) { /* �����ѧ�����1�˲�����ͬһ����Ȧ */
                root1 = union(root1, root2);
            }
        }
    }

    /** �ҳ��������Ȧ*/
    static void checkFriends() {
        int max = 1;
        for (int i = 1; i <= n; i++) {
            if ((s[i] < 0) && (max < -s[i])) {
                max = -s[i];
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        n = cin.nextInt();
        m = cin.nextInt();
        s = new int[n+1];
        /** ��ʼ�����鼯*/
        Arrays.fill(s,-1);
        for (int i = 0; i < m; i++) {
            inputSet();
        }
        checkFriends();
    }
}
