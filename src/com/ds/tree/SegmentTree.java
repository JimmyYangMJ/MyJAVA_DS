package com.ds.tree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * �߶����Ļ�������
 * �ο���https://www.cnblogs.com/xenny/p/9801703.html
 * �ο���https://blog.csdn.net/huangzihaoal/article/details/81813454
 * ��Ŀ�� A Simple Problem with Integers  ��POJ 3468
 */
public class SegmentTree {

    public static Scanner cin = new Scanner(System.in);
    /** �߶�������*/
    public static long[] t;
    /** ԭ����*/
    public static long[] a;
    /** ����ǣ� ����Ա�ǣ�*/
    public static long[] lazy_Add;


    public static long res = 0;
    public static void pushUp(int k){        //���º�����������ʵ������� ��ͬ����Ա�ɣ���Сֵ�����ֵ��
        t[k] = t[k<<1] + t[k<<1|1] ;
    }

    /**
     * �ݹ鷽ʽ���� build(1,1,n)
     * @param k  ���
     * @param L  ��˵��±�
     * @param r  �Ҷ˵��±�
     */
    public static void build(int k,int L,int r){    /* kΪ��ǰ��Ҫ�����Ľ�㣬lΪ��ǰ��Ҫ�����������˵㣬r��Ϊ�Ҷ˵�*/
        if(L == r) {   /* ��˵�����Ҷ˵㣬��ΪҶ�ӽڵ㣬ֱ�Ӹ�ֵ����*/
            t[k] = a[L];
        }else {
            int m = L + ((r-L)/2);    // m��Ϊ�м�㣬����ӵĽ������Ϊ[l,m],�Ҷ��ӵĽ������Ϊ[m+1,r]
            build(k*2, L, m);    // �ݹ鹹������ӽ��   k<<1 == k*2
            build(k*2 + 1,m+1, r);    // �ݹ鹹���Ҷ��ӽ��  k<<1|1 == k*2+1
            pushUp(k);    //���¸��ڵ�
        }
    }

    /**
     * (���ڵ����)ĳһ���±�p ��ֵ�� v��
     * updateOnce(5, 3, 1, length,1)
     * @param p Ҫ���µĽڵ㣨�±꣩
     * @param v Ҫ���ϵ�ֵ
     * @param L ������˵�
     * @param r �����Ҷ˵�
     * @param k �ڵ��±�
     */
    public static void updateOnce(int p, int v, int L, int r, int k){    //pΪ�±꣬vΪҪ���ϵ�ֵ��l��rΪ������䣬kΪ����±�
        if(L == r) {    //��˵�����Ҷ˵㣬��ΪҶ�ӽ�㣬ֱ�Ӽ���v����
            a[L] += v;
            t[k] += v;    //ԭ������߶������鶼�õ�����
        }else {
            int m = L + ((r-L)>>1);    //m��Ϊ�м�㣬����ӵĽ������Ϊ[l,m],�Ҷ��ӵĽ������Ϊ[m+1,r]
            if(p <= m)    //�����Ҫ���µĽ��������������
                updateOnce(p,v,L,m,k<<1);
            else    //�����Ҫ���µĽ��������������
                updateOnce(p,v,m+1,r,k<<1|1);
            pushUp(k);    //���¸��ڵ��ֵ
        }
    }

    /**
     * �ݹ鷽ʽ�����ѯ queryOnce(L,R,1,n,1);
     * @param L Ҫ������� ��
     * @param R Ҫ������� ��
     * @param l ������� ��
     * @param r ������� ��
     * @param k ��������±�
     * @return ��ѯ ���
     */
    public static long queryOnce(int L, int R, int l, int r, int k){    //[L,R]��ΪҪ��ѯ�����䣬l��rΪ������䣬kΪ����±�
        if(L <= l  && r <= R) {   //�����ǰ���������������Ҫ��ѯ�������ڣ��򷵻ؽ����Ϣ�Ҳ���Ҫ���µݹ�
            return t[k];
        }else {
            res = 0;    //����ֵ���������ݾ����߶�����ѯ��ʲô���Զ���
            int mid = l + ((r-l)>>1);    //m��Ϊ�м�㣬����ӵĽ������Ϊ[l,m],�Ҷ��ӵĽ������Ϊ[m+1,r]
            if(L <= mid) {   //�������������Ҫ��ѯ�����佻���ǿ�
                res += queryOnce(L, R, l, mid, k * 2);
            }
            if(R > mid)    //�������������Ҫ��ѯ�����佻���ǿգ�ע�����ﲻ��else if����Ϊ��ѯ�������ͬʱ���������䶼�н���
                res += queryOnce(L,R,mid+1,r,k*2+1);

            return res;    //���ص�ǰ���õ�����Ϣ
        }
    }

    //�ݹ�������� update(L,R,v,1,n,1);
    public static void update(int L,int R,int v,int l,int r,int k){    //[L,R]��ΪҪ���µ����䣬l��rΪ������䣬kΪ����±�
        if(L <= l && r <= R){    //�����ǰ���������������Ҫ���µ�������
            lazy_Add[k] += v;    //������
            t[k] += v * (r - l + 1);    //���ֵ����v֮�󣬴���������ֵҲ�϶��Ǽ�v
        }else{
            int m = l + ((r-l)>>1);
            Pushdown(k, l, r, m);
            if(L <= m)    //�������������Ҫ���µ����佻���ǿ�
                update(L, R, v, l, m,k<<1);
            if(m < R)    //�������������Ҫ���µ����佻���ǿ�
                update(L, R, v,m+1,r,k<<1|1);
            pushUp(k);    //���¸��ڵ�
        }
    }


    public static void Pushdown(int k, int L, int r, int mid){    //����������lazyֵ��������RMQ�ĺ�����Ҫʵ������͵�����Ҫ�޸ĺ�������
        if(lazy_Add[k] != 0){    //�����lazy���
            lazy_Add[k<<1] += lazy_Add[k];    //������������lazyֵ
            lazy_Add[k<<1|1] += lazy_Add[k];    //������������lazyֵ
            t[k<<1] += lazy_Add[k] * (mid - L + 1);        //�������ĺͼ���lazyֵ
            t[k<<1|1] += lazy_Add[k] * (r - mid);    //�������ĺͼ���lazyֵ
            lazy_Add[k] = 0;    //lazyֵ��0
        }
    }

    /**
     * �ݹ鷽ʽ�����ѯ query(L,R,1,n,1);
     * @return
     */
    public static long query(int L,int R,int l,int r,int k){    //[L,R]��ΪҪ��ѯ�����䣬l��rΪ������䣬kΪ����±�
        if(L <= l && r <= R)    //�����ǰ���������������Ҫ��ѯ�������ڣ��򷵻ؽ����Ϣ�Ҳ���Ҫ���µݹ�
            return t[k];
        else{
            res = 0;    //����ֵ���������ݾ����߶�����ѯ��ʲô���Զ���
            int mid = l + ((r-l)>>1);    //m��Ϊ�м�㣬����ӵĽ������Ϊ[l,m],�Ҷ��ӵĽ������Ϊ[m+1,r]
            Pushdown(k, l, r, mid);
            if(L <= mid)    //�������������Ҫ��ѯ�����佻���ǿ�
                res += query(L,R,l,mid,k<<1);
            if(R > mid)    //�������������Ҫ��ѯ�����佻���ǿգ�ע�����ﲻ��else if����Ϊ��ѯ�������ͬʱ���������䶼�н���
                res += query(L,R,mid+1,r,k<<1|1);
            return res;    //���ص�ǰ���õ�����Ϣ
        }
    }

    public static void main(String[] args) {
        /** ��ʼ��ԭʼ����*/
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
        /*�±��1��ʼ*/
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
