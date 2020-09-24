package org.jerry.test.algorithm;

import java.util.Stack;

/**
 * @author zhuqianchao
 * @date 2020/9/2 22:13
 */
public class BraceValid {


    public static void main(String[] args) {
        String s = "[{}]";

        System.out.println(new BraceValid().isValid(s));
    }


    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }
}
