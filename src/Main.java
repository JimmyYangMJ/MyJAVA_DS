
import java.util.HashMap;
import java.util.Scanner;


/**
 * ����Ͱ����� 1 ɫ������
     ����
     1
     5
     S###.
     E..#.
     #.##.
     #.#..
     ###..
 */
public class Main {
    static Scanner cin = new Scanner(System.in);

    public static HashMap<Integer, HashMap<Integer, Integer>> map;
    public static void main(String[] args) {
        int t = cin.nextInt();
        while (t-- > 0){
            int n = cin.nextInt();
            cin.nextLine();
            char[][] m = new char[n][n];
            int h = 0,l = 0;
            for (int i = 0; i < n; i++) {
                String temp = cin.nextLine();
                if (temp.contains("S")){
                    h = i;
                }
                m[i] = temp.toCharArray();
            }
            for (int i = 0; i <n; i++) {
                if (m[h][i] == 'S'){
                    l = i;
                    break;
                }
            }
            // 1up 2down 3left 4right
            map = new HashMap<>();
            init();
            int next;
            int b = 6;
            while (true){
                m[h][l] = Integer.toString(b).charAt(0); // ���µ�ǰ
                next = find(m, h, l, n); // ��һ������
                // ��һ��λ��
                if (next < 0) {
                    next *= -1;
                    b = map.get(b).get(next); // ��һ���ײ�
                    if (next == 1) h--;
                    if (next == 2) h++;
                    if (next == 3) l--;
                    if (next == 4) l++;
                    m[h][l] = Integer.toString(b).charAt(0); // ���µ�ǰ
                    break;
                }
                // ��һ��λ��
                if (next == 1) h--;
                if (next == 2) h++;
                if (next == 3) l--;
                if (next == 4) l++;
                b = map.get(b).get(next); // ��һ���ײ�
            }
            print(m, n);
        }
    }

    /** ��ӡ��ǰ��ͼ*/
    private static void print(char[][] m,int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    /**  ��ʼ��ɸ�ӷ��� */
    private static void init() {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(1,3);map1.put(2, 4);
        map1.put(3, 5);map1.put(4, 4);map.put(1,map1);

        map1 = new HashMap<>();
        map1.put(1, 4);map1.put(2, 3);
        map1.put(3, 6);map1.put(4, 1);map.put(2,map1);

        map1 = new HashMap<>();
        map1.put(1,6);map1.put(2, 1);
        map1.put(3, 5);map1.put(4, 2);map.put(3,map1);

        map1 = new HashMap<>();
        map1.put(1,1);map1.put(2, 6);
        map1.put(3, 5);map1.put(4, 2);map.put(4,map1);

        map1 = new HashMap<>();
        map1.put(1,4);map1.put(2, 3);
        map1.put(3, 1);map1.put(4, 6);map.put(5,map1);

        map1 = new HashMap<>();
        map1.put(1, 4);map1.put(2, 3);
        map1.put(3, 5);map1.put(4, 2);map.put(6,map1);
    }

    /**  �ҵ� ���꣨h,l����һ�� �ķ���
     *  1-up 2-down 3-left 4-right
     */
    public static int find(char[][] m, int h, int l,int n) {
        n -= 1;
        if (h > 0 && ( m[h-1][l] == '#' ||  m[h-1][l] == 'E' )){
            if (m[h-1][l] == 'E') return -1;
            return 1;
        }
        if (l < n && ( m[h][l+1] == '#'||  m[h][l+1] == 'E' )){
            if (m[h][l+1] == 'E') return -4;
            return 4;
        }
        if (h < n && ( m[h+1][l] == '#'||  m[h+1][l] == 'E' )){
            if (m[h+1][l] == 'E') return -2;
            return 2;
        }
        if (l > 0 && ( m[h][l-1] == '#'||  m[h][l-1] == 'E' )){
            if ( m[h][l-1] == 'E') return -3;
            return 3;
        }
        return 0;

    }

}
