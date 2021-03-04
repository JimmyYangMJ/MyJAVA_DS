import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        // 1001110
        int a = 1 << 3 >> 2;
        System.out.println(Integer.toBinaryString(a));
        String keys = Integer.toBinaryString(a);
        int m = Integer.valueOf("1110101",2);
        int index = 3;
        System.out.println( m >> index & 1 );// 1000
        System.out.println(String.format("%c", 'a'+5));
        int x = 3,y = 5; //  11
        y ^= x  ^= y;
        x ^= y ;
        System.out.println(x + ", " + y);
        int A = 3, B = 2;
        A^=B^=A^=B;
        System.out.println(A + ", " + B);
        int z1 = 4, z2 = 1, z3 = 5;
        z1 += z2 += z1;
        System.out.printf("%d, %d,\n", z1 ,z2);
        int xx = 12 >> 1;  // 1100 -> 110
        System.out.println(Integer.toBinaryString(xx));
    }

}