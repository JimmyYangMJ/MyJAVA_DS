package com.acm.leecode.BitManipulation;

/**
 * 476. 数字的补数
 * @author ymj
 * @Date： 2019/12/14 21:40
 */
public class Main476 {

    public int findComplement(int num) {
        int result = 0;
        int temp = 1;
        while (num > 0) {
            if((num & 1) == 0) { // 最后一位 为 0
                result = result  | temp; // 最后一位 置为 1
            }
            temp <<= 1;
            num >>= 1;

        }
        return result;
    }
    public static void main(String[] args) {
        Main476 main476 = new Main476();
        System.out.println(main476.findComplement(5));
    }

}
