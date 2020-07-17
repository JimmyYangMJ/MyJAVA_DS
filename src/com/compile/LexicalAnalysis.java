package com.compile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 词法分析实验
 * @author 杨明杰
 * @Date： 2020/4/10 9:16
 */
public class LexicalAnalysis {

    /**标识符 ID >> 正则表达式*/
    final static String ID = "\\p{Alpha}(\\p{Alpha}|\\d)*";

    /** 整形常数 NUM >> 正则表达式*/
    final static String NUM = "\\d\\d*";

    /** token 词法单元
     * <词符号， 种别码> */
    /** 关键字 token*/
    static Map<String, Integer> TOKEN_KEYWORDS;
    /** 运算符/界符 token */
    static Map<String, Integer> TOKEN_OPERATOR_BOUNDARY;
    /** 其他单词 token*/
    static Map<String, Integer> TOKEN_ID_SUM;

    /** 文件根目录*/
    static final String ROOT_DIRECTORY = "D:/IDEA-workspace/MyJAVA_DS/src/com/compile/";

    /**
     * 初始化 token 单元
     */
    private static void initToken(){
        TOKEN_KEYWORDS = new HashMap<String, Integer>(){
            {
                put("begin", 1);
                put("if", 2);
                put("then", 3);
                put("while", 4);
                put("do", 5);
                put("end", 6);
            }
        };

        TOKEN_OPERATOR_BOUNDARY= new HashMap<String, Integer>(){
            {
                put("+", 13);
                put("-", 14);
                put("*", 15);
                put("/", 16);
                put(":", 17);
                put(":=", 18);
                put("<", 20);
                put("<>", 21);
                put("<=", 22);
                put(">", 23);
                put(">=", 24);
                put("=", 25);
                put(";", 26);
                put("(", 27);
                put(")", 28);
                put("#", 0);

            }
        };

        TOKEN_ID_SUM= new HashMap<String, Integer>(){
            {
                put(ID, 10);
                put(NUM, 11);
            }
        };
    }

    /**
     * 读 源程序 文件
     */
    public static void ReadFile1() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(ROOT_DIRECTORY + "program.txt");
            isr = new InputStreamReader(fis, "UTF-8"); // 转化类
            br = new BufferedReader(isr); // 装饰类
            String line;
            /** 记录 程序 行数 */
            int countLine = 1;
            while ((line = br.readLine()) != null) {  // 每次读取一行
                boolean answer = lexicalAnalysis(line);
                if(answer == false){
                    System.out.printf("ERROR 编译错误=== 第 %d 行出现 词法错误 ", countLine);
                    break;
                }
                countLine++;
            }
            System.out.printf("===编译完成===");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close(); // 关闭最后一个类，会将所有的底层流都关闭
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /** 判断key是否是其他单词*/
    private static boolean isIDOrSUM(String key){
        if (key.matches(ID) ) {
            System.out.printf("(%d, %s)\n", TOKEN_ID_SUM.get(ID), key);
        }else if (key.matches(NUM)) {
            System.out.printf("(%d, %s)\n", TOKEN_ID_SUM.get(NUM), key);
        }else {
            return false;
        }
        return true;
    }

    /**
     * 进行 词法分析
     * @param word 要分析的字符串
     * @return 结果
     */
    public static boolean  lexicalAnalysis(String word){

        word = word.trim(); // 去 首尾 空格
        String[] strings = word.split("\\p{Space}+"); // 保证处理的字符串没有空格
        for (String string : strings) {

            /** 3种情况：
             *      1. 关键字 == end （关键字的后面一定是空格 ）
             *      2. 运算符/ 分界符 == continue
             *      3. 其他单词 == continue
             */
            String key = "";
            for (int i = 0; i < string.length(); i++){
                String indexChar = String.valueOf(string.charAt(i)) ;

                /** 是 运算符 或者 关键字*/
                if (TOKEN_OPERATOR_BOUNDARY.containsKey(indexChar) ||
                        TOKEN_KEYWORDS.containsKey(string.substring(i, string.length()))){

                    if (key.length() > 0) {
                        if (isIDOrSUM(key) == false) {
                            /** 词法错误 */
                            return false;
                        }
                        key = "";
                    }
                    if(TOKEN_OPERATOR_BOUNDARY.containsKey(indexChar)) {
                        /**  1. 是 运算符/分界符 */
                        key += indexChar;
                        if(i + 1 < string.length() && TOKEN_OPERATOR_BOUNDARY.containsKey(indexChar + string.charAt(i+1))){ // 运算分界符
                            key += string.charAt(++i);
                        }
                        System.out.printf("(%d, %s)\n",TOKEN_OPERATOR_BOUNDARY.get(key),key);
                        key = "";
                    }else if(TOKEN_KEYWORDS.containsKey(key = string.substring(i, string.length()))) {
                        /** 2. 是关键字*/
                        System.out.printf("(%d, %s)\n",TOKEN_KEYWORDS.get(key),key);
                        key = "";
                        break;
                    }
                }else {
                    /** 是其他单词*/
                    key += indexChar;
                    /** 其他单词后面是 1. 换行，2. 运算符/界符 3. 其他单词
                     */
                    if(i+1 >= string.length()){
                        if (isIDOrSUM(key) == false) {
                            /** 词法错误 */
                            return false;
                        }
                    }
                }
            }


        }

        return true;
    }

    public static void main(String[] args) {

        initToken();
        System.out.println("==词法分析程序==");
        System.out.println("从文件中读取程序");
        System.out.println("==============");

        ReadFile1();

        System.out.println();
    }
}
