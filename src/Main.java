
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Main {
    static Scanner cin = new Scanner(System.in);

    static Set<Integer>[] set = null;
    static Set<Integer> sum = new HashSet<>();
    public static void main(String[] args) {
        int n = cin.nextInt();
        set =  new HashSet[n];
        for (int i = 0; i < n; i++) {
            int k = cin.nextInt();
            set[i] = new HashSet<>();
            int tip = 0;
            for (int j = 0; j < k; j++) {
                int a = cin.nextInt();
                if (tip < 0) {
                    set[tip*-1].add(a);
                    sum.add(a);
                }else {
                    for (int m = 0; m < i ; m++){
                        if (set[m].contains(a)) {
                            tip = -1*m;
                            break;
                        }
                    }
                    if (tip < 0) {
                        set[tip*-1].add(a);
                        sum.add(a);
                    }else {
                        set[i].add(a);
                        sum.add(a);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (set[i].size() > 0) {
                count++;
            }
        }

        System.out.println(sum.size() + " " + count);
        int x = cin.nextInt();
        for (int i = 0; i < x; i++) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            int k = 0;
            for ( k = 0; k < n; k++) {
                if (set[k].contains(a) && set[k].contains(b)) {
                    System.out.println("Y");
                    break;
                }
            }
            if (k >= n) {
                System.out.println("N");
            }

        }
    }

}

