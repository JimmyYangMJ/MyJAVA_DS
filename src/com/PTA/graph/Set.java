package com.PTA.graph;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 并查集
 * 案例 - 朋友圈
 */
public class Set {

    static Scanner cin = new Scanner(System.in);
    /** 人数 */
    static int n;
    /** 朋友圈数*/
    static int m;
    /** 朋友集合 从1~N编号, 负数表示集合人数，-4表示集合4个人*/
    static int[] s;

    /** 找到一个结点所在的集合*/
    static int find(int x) {
        if (s[x] < 0) { /* 本身为一个集合*/
            return x;
        }else {
            return s[x] = find(s[x]);
        }
    }

    /** 合并集合*/
    static int union(int root1, int root2) {
        if(s[root1] > s[root2]) { /* 如果集合2比较大 */
            s[root2] += s[root1];
            s[root1] = root2;    /* 集合1并入集合2  */
            return  root2;
        }else{
            s[root1] += s[root2];
            s[root2] = root1;    /* 集合2并入集合1  */
            return  root1;
        }

    }

    /** 一个结点插入集合*/
    static void inputSet(){
        /** 一个朋友圈的人数*/
        int num;
        num = cin.nextInt();
        int p, root1, root2;
        p = cin.nextInt();
        root1 = find(p);
        for (int i = 1; i < num; i++) {
            p = cin.nextInt();
            root2 = find(p);
            if(root1 != root2) { /* 如果该学生与第1人不属于同一朋友圈 */
                root1 = union(root1, root2);
            }
        }
    }

    /** 找出最大朋友圈*/
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
        /** 初始化并查集*/
        Arrays.fill(s,-1);
        for (int i = 0; i < m; i++) {
            inputSet();
        }
        checkFriends();
    }
}
