package com.compile;

import java.util.*;

/**
 * LR(0) 分析
 * G(E):
 * E->aA|bB
 * A->cA|d
 * B-->cB|d
 * @author ymj
 * @Date： 2020/6/7 11:01
 */
public class LRAnalysis {

    public static Scanner cin = new Scanner(System.in);

    /** LR(0)分析表 */
    private static  Map<Character, String>[] LRTable;

    /** G(E) */
    private static  String[][] G;

    /** 状态栈*/
    private static Stack<Integer> statusStack ;

    /** 符号栈*/
    private static Stack<Character> symbolStack;

    /** 构造 LR（0） 表 */
    public static void initLRTable() {
        LRTable = new HashMap[12];
        for (int i= 0; i < LRTable.length; i++) {
            LRTable[i] = new HashMap<>(6);
        }
        LRTable[0].put('a', "s2"); LRTable[0].put('b', "s3"); LRTable[0].put('E', "1");
        LRTable[1].put('$', "acc");
        LRTable[2].put('c', "s5");LRTable[2].put('d', "s6");LRTable[2].put('A', "4");
        LRTable[3].put('c', "s8");LRTable[3].put('d', "s9");LRTable[3].put('B', "7");
        LRTable[4].put('a', "r1");LRTable[4].put('b', "r1");LRTable[4].put('c', "r1");LRTable[4].put('d', "r1");LRTable[4].put('$', "r1");
        LRTable[5].put('c', "s5");LRTable[5].put('d', "s6");LRTable[5].put('A', "10");
        LRTable[6].put('a', "r4");LRTable[6].put('b', "r4");LRTable[6].put('c', "r4");LRTable[6].put('d', "r4");LRTable[6].put('$', "r4");
        LRTable[7].put('a', "r2");LRTable[7].put('b', "r2");LRTable[7].put('c', "r2");LRTable[7].put('d', "r2");LRTable[7].put('$', "r2");
        LRTable[8].put('c', "s8");LRTable[8].put('d', "s9");LRTable[8].put('B', "11");
        LRTable[9].put('a', "r6");LRTable[9].put('b', "r6");LRTable[9].put('c', "r6");LRTable[9].put('d', "r6");LRTable[9].put('$', "r6");
        LRTable[10].put('a', "r3");LRTable[10].put('b', "r3");LRTable[10].put('c', "r3");LRTable[10].put('d', "r3");LRTable[10].put('$', "r3");
        LRTable[11].put('a', "r5");LRTable[11].put('b', "r5");LRTable[11].put('c', "r5");LRTable[11].put('d', "r5");LRTable[11].put('$', "r5");

        G = new String[][]{
                {"S", "E"},
                {"E", "aA"},
                {"E", "bB"},
                {"A", "cA"},
                {"A", "d"},
                {"B", "cB"},
                {"B", "d"}
        };

        int[][] arr1 = {{1,2}, {2, 3}, {4, 5}};


    }

    public static void printTable(int p, String input, String action) {
        String status = "";
        for (int temp: statusStack) {
            status += temp + "";
        }
        String symbol = "";
        for (char temp: symbolStack) {
            symbol += temp + "";
        }

        String in = "";
        for (int i = p; i < input.length(); i++){
            in += input.charAt(i) + "";
        }
        System.out.printf("%8s\t %8s\t %8s\t %s\n",status, symbol, in, action);

    }

    public static boolean LR0Analysis(String input) {
        System.out.println(input);
        System.out.printf("%8s\t %8s\t %8s\t\n","状态栈", "符号栈", "输入串");
        statusStack.push(0);
        symbolStack.push('$');
        int p = 0;

        while(true) {

            int status = statusStack.peek(); // 状态
            char nextChar = input.charAt(p); // 输入字符
            int nextStatus = -1;
            if (LRTable[status].containsKey(nextChar)) {
                String info = LRTable[status].get(nextChar);
                printTable(p, input, info);
                if (info.equals("acc")) {
                    break;
                }
                if (info.charAt(0) == 's') { // 移进状态
                    nextStatus = Integer.parseInt(info.substring(1));
                    statusStack.push(nextStatus);
                    symbolStack.push(nextChar);
                    p++;
                } else if (info.charAt(0) == 'r') { // 规约状态
                    nextStatus = Integer.parseInt(info.substring(1));
                    for (int i = 0; i < G[nextStatus][1].length(); i++) {
                        symbolStack.pop();
                        statusStack.pop();
                    }
                    char temp = G[nextStatus][0].charAt(0);
                    symbolStack.push(temp);
                    int s = statusStack.peek();
                    statusStack.push(Integer.parseInt(LRTable[s].get(temp)));
                } else { // GOTO 转移
                    break;
                }

            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        initLRTable();

        while (true) {
            String string = cin.nextLine();
            statusStack = new Stack<>();
            symbolStack = new Stack<>();
            if (string.equalsIgnoreCase("#")) {
                System.out.println("====结束====");
                break;
            } else {
                if (LR0Analysis(string.trim()+ "$" )) {
                    System.out.println("成功" + string + "是该文法的句子");
                } else {
                    System.out.println("失败" + string + "不是该文法的句子");
                }
            }
        }

    }
}
