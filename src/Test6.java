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
    }

}