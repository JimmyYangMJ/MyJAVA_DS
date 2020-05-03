
/**
 * 118. 杨辉三角 Pascal's Triangle
 * @author ymj
 * @Date： 2020/1/19 18:22
 */
public class MainTest {

    /** 汉诺塔问题 */
    public static void process(int N, String from, String to, String help) {
        if (N == 1){
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            process(N-1, from, help, to);
            System.out.println("Move " + N + " from " + from + " to " + to);
            process(N-1, help, to, from);
        }

    }

    /** 打印字符串的全部子序列 */
    public static void printAllSub(char[] str, int index, String res){
        if(index == str.length) {
            System.out.println(res);
            return;
        }
        printAllSub(str, index + 1, res + String.valueOf(str[index]));
        printAllSub(str,index +1, res);
    }

    // todo 打印一个字符串的全部排列，要求不要出现重复的排列

    // todo 生兔子问题

    // todo 打印一个字符串的全部排列，要求不要出现重复的排列

    /** 给你一个二维数组，二维数组中的每个数都是正数，要求从左上 角走到右下角，
     * 每一步只能向右或者向下。沿途经过的数字要累 加起来。返回最小的路径和
     */
    public static int walk(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        if (i == matrix.length - 1) {
            return matrix[i][j] + walk(matrix, i, j + 1);
        }
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + walk(matrix, i + 1, j );
        }
        int right = walk(matrix, i, j + 1);
        int down = walk(matrix,i + 1, j);
        return matrix[i][j] + Math.min(right, down);
    }
    // todo 上述改为动态规划

    /**
     * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的 数字，能不能累加得到aim
     * 返回true或者false
     * 相关问题：背包··· ···
     */
    public static boolean isSum(int[] arr, int i,int sum, int aim) {
        if(i == arr.length) {
            System.out.println(sum);
            return sum == aim;
        }
        return isSum(arr, i + 1, sum, aim) || isSum(arr, i + 1, sum + arr[i], aim);
    }
    // todo 上述改为动态规划

    public static void main(String[] args) {
       // process(3,"左", "中", "右");
        // printAllSub("abc".toCharArray(), 0,"");

//        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
//        System.out.println(walk(m, 0, 0));

        int[] arr = {2, 4, 8};
        int aim = 12;
        System.out.println(isSum(arr, 0, 0, aim));

    }
}