package com.acm.leecode.BitManipulation;

/**
 * 476. ���ֵĲ���
 * @author ymj
 * @Date�� 2019/12/14 21:40
 */
public class Main476 {

    public int findComplement(int num) {
        int result = 0;
        int temp = 1;
        while (num > 0) {
            if((num & 1) == 0) { // ���һλ Ϊ 0
                result = result  | temp; // ���һλ ��Ϊ 1
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
