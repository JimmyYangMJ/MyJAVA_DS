package com.ds.tree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 线段树的基本操作
 * 参考：https://www.cnblogs.com/xenny/p/9801703.html
 * 参考：https://blog.csdn.net/huangzihaoal/article/details/81813454
 * 题目： A Simple Problem with Integers  ；POJ 3468
 */
public class SegmentTree {

    public static Scanner cin = new Scanner(System.in);
    /** 线段树数组*/
    public static long[] t;
    /** 原数组*/
    public static long[] a;
    /** 懒标记， （相对标记）*/
    public static long[] lazy_Add;


    public static long res = 0;
    public static void pushUp(int k){        //更新函数，这里是实现区间和 ，同理可以变成，最小值，最大值等
        t[k] = t[k<<1] + t[k<<1|1] ;
    }

    /**
     * 递归方式建树 build(1,1,n)
     * @param k  起点
     * @param L  左端点下标
     * @param r  右端点下标
     */
    public static void build(int k,int L,int r){    /* k为当前需要建立的结点，l为当前需要建立区间的左端点，r则为右端点*/
        if(L == r) {   /* 左端点等于右端点，即为叶子节点，直接赋值即可*/
            t[k] = a[L];
        }else {
            int m = L + ((r-L)/2);    // m则为中间点，左儿子的结点区间为[l,m],右儿子的结点区间为[m+1,r]
            build(k*2, L, m);    // 递归构造左儿子结点   k<<1 == k*2
            build(k*2 + 1,m+1, r);    // 递归构造右儿子结点  k<<1|1 == k*2+1
            pushUp(k);    //更新父节点
        }
    }

    /**
     * (单节点更新)某一个下标p 的值加 v，
     * updateOnce(5, 3, 1, length,1)
     * @param p 要更新的节点（下标）
     * @param v 要加上的值
     * @param L 区间左端点
     * @param r 区间右端点
     * @param k 节点下标
     */
    public static void updateOnce(int p, int v, int L, int r, int k){    //p为下标，v为要加上的值，l，r为结点区间，k为结点下标
        if(L == r) {    //左端点等于右端点，即为叶子结点，直接加上v即可
            a[L] += v;
            t[k] += v;    //原数组和线段树数组都得到更新
        }else {
            int m = L + ((r-L)>>1);    //m则为中间点，左儿子的结点区间为[l,m],右儿子的结点区间为[m+1,r]
            if(p <= m)    //如果需要更新的结点在左子树区间
                updateOnce(p,v,L,m,k<<1);
            else    //如果需要更新的结点在右子树区间
                updateOnce(p,v,m+1,r,k<<1|1);
            pushUp(k);    //更新父节点的值
        }
    }

    /**
     * 递归方式区间查询 queryOnce(L,R,1,n,1);
     * @param L 要查区间的 左
     * @param R 要查区间的 右
     * @param l 结点区间 右
     * @param r 结点区间 右
     * @param k 结点的起点下标
     * @return 查询 结果
     */
    public static long queryOnce(int L, int R, int l, int r, int k){    //[L,R]即为要查询的区间，l，r为结点区间，k为结点下标
        if(L <= l  && r <= R) {   //如果当前结点的区间真包含于要查询的区间内，则返回结点信息且不需要往下递归
            return t[k];
        }else {
            res = 0;    //返回值变量，根据具体线段树查询的什么而自定义
            int mid = l + ((r-l)>>1);    //m则为中间点，左儿子的结点区间为[l,m],右儿子的结点区间为[m+1,r]
            if(L <= mid) {   //如果左子树和需要查询的区间交集非空
                res += queryOnce(L, R, l, mid, k * 2);
            }
            if(R > mid)    //如果右子树和需要查询的区间交集非空，注意这里不是else if，因为查询区间可能同时和左右区间都有交集
                res += queryOnce(L,R,mid+1,r,k*2+1);

            return res;    //返回当前结点得到的信息
        }
    }

    //递归更新区间 update(L,R,v,1,n,1);
    public static void update(int L,int R,int v,int l,int r,int k){    //[L,R]即为要更新的区间，l，r为结点区间，k为结点下标
        if(L <= l && r <= R){    //如果当前结点的区间真包含于要更新的区间内
            lazy_Add[k] += v;    //懒惰标记
            t[k] += v * (r - l + 1);    //最大值加上v之后，此区间的最大值也肯定是加v
        }else{
            int m = l + ((r-l)>>1);
            Pushdown(k, l, r, m);
            if(L <= m)    //如果左子树和需要更新的区间交集非空
                update(L, R, v, l, m,k<<1);
            if(m < R)    //如果右子树和需要更新的区间交集非空
                update(L, R, v,m+1,r,k<<1|1);
            pushUp(k);    //更新父节点
        }
    }


    public static void Pushdown(int k, int L, int r, int mid){    //更新子树的lazy值，这里是RMQ的函数，要实现区间和等则需要修改函数内容
        if(lazy_Add[k] != 0){    //如果有lazy标记
            lazy_Add[k<<1] += lazy_Add[k];    //更新左子树的lazy值
            lazy_Add[k<<1|1] += lazy_Add[k];    //更新右子树的lazy值
            t[k<<1] += lazy_Add[k] * (mid - L + 1);        //左子树的和加上lazy值
            t[k<<1|1] += lazy_Add[k] * (r - mid);    //右子树的和加上lazy值
            lazy_Add[k] = 0;    //lazy值归0
        }
    }

    /**
     * 递归方式区间查询 query(L,R,1,n,1);
     * @return
     */
    public static long query(int L,int R,int l,int r,int k){    //[L,R]即为要查询的区间，l，r为结点区间，k为结点下标
        if(L <= l && r <= R)    //如果当前结点的区间真包含于要查询的区间内，则返回结点信息且不需要往下递归
            return t[k];
        else{
            res = 0;    //返回值变量，根据具体线段树查询的什么而自定义
            int mid = l + ((r-l)>>1);    //m则为中间点，左儿子的结点区间为[l,m],右儿子的结点区间为[m+1,r]
            Pushdown(k, l, r, mid);
            if(L <= mid)    //如果左子树和需要查询的区间交集非空
                res += query(L,R,l,mid,k<<1);
            if(R > mid)    //如果右子树和需要查询的区间交集非空，注意这里不是else if，因为查询区间可能同时和左右区间都有交集
                res += query(L,R,mid+1,r,k<<1|1);
            return res;    //返回当前结点得到的信息
        }
    }

    public static void main(String[] args) {
        /** 初始化原始数组*/
        int length, n;
        length = cin.nextInt();
        n = cin.nextInt();
        a = new long[length+1];
        t = new long[a.length*4];
        lazy_Add = new long[a.length*4];
        Arrays.fill(lazy_Add, 0);
        for (int i = 1; i <= length; i++){
            a[i] = cin.nextInt();
        }
        /*下标从1开始*/
        build(1,1, length);

        String s ;
        for(int i = 0; i < n; i++) {
            s = cin.next();
            int x, y;
            x = cin.nextInt();
            y = cin.nextInt();
            if(s.charAt(0) == 'Q') {
                System.out.println(query(x, y, 1, length,1));
            }else if(s.charAt(0) == 'C'){
                int z = cin.nextInt();
//                for(int j = x; j <= y; j++)
//                    updateOnce(j, z,1, length, 1);
                update(x, y, z,1, length,1);
            }
        }


    }
}
