package com.acm.leecode.String;

import javax.security.auth.callback.CallbackHandler;
import java.nio.channels.Channel;
import java.util.Stack;

/**
 * @author ymj
 * @Date： 2020/9/2 14:39
 * @description: 整理字符串
 */
public class Main1544 {

    public static void main(String[] args) {
        System.out.println(new Main1544().makeGood("leEeetcode"));
    }
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.size() > 0) {
                if (Math.abs(c - stack.peek()) == Math.abs('a' - 'A')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }else {
                stack.push(c);
            }
        }
        int length = stack.size();
        String s1 = "";
        for (int i = 0; i < length; i++) {
            s1 =  stack.pop() + s1;
        }
        return s1;
    }
}
