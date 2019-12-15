package com.acm.leecode.BitManipulation;

/**
 * 461 ººÃ÷¾àÀë
 * @author ymj
 * @Date£º 2019/12/14 21:21
 */
public class Main461 {
    public int hammingDistance(int x, int y) {
        int dis = x^y;
        int cnt = 0;
        while(dis > 0)
        {
            if((dis&1) == 1)
                cnt++;
            dis >>= 1;
        }
        return cnt;
    }
    public static void main(String[] args) {

        System.out.println(new Main461().hammingDistance(1,4));
    }
}
