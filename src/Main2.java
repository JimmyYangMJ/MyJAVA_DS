import java.io.*;
import java.util.*;

public class Main2 {

    public static Scanner cin = new Scanner(System.in);
    /** 鳄鱼数量 N（≤100）*/
    public static int n;
    //public static Main.com.java.base.C[] c;
    /** 007一次能跳跃的最大距离 */
    public static int d;

    /** 鳄鱼的坐标*/
    public static class C{
        int x;
        int y;
        public C(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

//    public static double distence(Main.com.java.base.C a, Main.com.java.base.C b) {
////        double dis = Math.pow(Math.abs(a.x-b.x), 2) + Math.pow(Math.abs(a.y-b.y), 2);
////        return Math.sqrt(dis);
////    }

    public static void main(String[] args) {

        n = cin.nextInt();
        d = cin.nextInt();
        //c = new Main.com.java.base.C[n+1];

    }
}