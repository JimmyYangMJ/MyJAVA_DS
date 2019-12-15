package com.acm.leecode.String;

/**
 * 14. 最长公共前缀
 * @author ymj
 * @Date： 2019/12/14 20:55
 */
public class Main14 {

    // 暴力解法
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }else {
            String prefix = strs[0];
            int index = 0;
            try {
                for (index = 0; ; index++){
                    char temp = prefix.charAt(index);
                    int i;
                    for (i = 1; i < strs.length; i++) {
                        if(temp == strs[i].charAt(index)){
                            continue;
                        }else {
                            break;
                        }
                    }
                    if(i < strs.length){
                        break;
                    }
                }
            }catch (Exception e){

            }finally {
                return prefix.substring(0,index);
            }
        }
    }
    public static void main(String[] args) {
        Main14 main14 = new Main14();
        System.out.println(main14.longestCommonPrefix(new String[]{""}));
    }
}
