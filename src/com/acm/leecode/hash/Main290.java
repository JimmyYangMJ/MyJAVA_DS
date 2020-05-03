package com.acm.leecode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. ���ʹ���
 * ����һ�ֹ��� pattern ��һ���ַ��� str ���ж� str �Ƿ���ѭ��ͬ�Ĺ��ɡ�
 */
public class Main290 {
    public boolean wordPattern(String pattern, String str) {

        Map<Character, String> map = new HashMap<>();
        String[] strArr = str.trim().split(" ");
        if (strArr.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++){
            char p = pattern.charAt(i);
            if (map.containsKey(p)){
                if (map.get(p).equals(strArr[i])) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (map.containsValue(strArr[i])) {
                    return false;
                }
                map.put(p, strArr[i]);
            }
        }
        return true;

    }

    public static void main(String[] args) {

        String pattern = "abba";
        String str = "dog dog dog dog";

        System.out.println(new Main290().wordPattern(pattern, str));
    }
}
