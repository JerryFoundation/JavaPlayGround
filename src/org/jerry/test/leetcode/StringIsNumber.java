package org.jerry.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuqianchao
 * @date 2020/9/12 21:15
 */
public class StringIsNumber {


    public static void main(String[] args) {
        System.out.println(new StringIsNumber().stringIsNumber("12.e3"));
    }
    static Map<Character, Integer>[] states;
    static {
        states = new Map[]{
                new HashMap() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }}, // 0.
                new HashMap() {{
                    put('d', 2);
                    put('.', 4);
                }},                           // 1.
                new HashMap() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }}, // 2.
                new HashMap() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},              // 3.
                new HashMap() {{
                    put('d', 3);
                }},                                        // 4.
                new HashMap() {{
                    put('s', 6);
                    put('d', 7);
                }},                           // 5.
                new HashMap() {{
                    put('d', 7);
                }},                                        // 6.
                new HashMap() {{
                    put('d', 7);
                    put(' ', 8);
                }},                           // 7.
                new HashMap() {{
                    put(' ', 8);
                }}                                         // 8.
        };
    }

    public boolean stringIsNumber(String s) {

        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == 'e' || c == 'E') t = 'e';
            else if (c == '.' || c == ' ') t = c;
            else t = '?';
            if (!states[p].containsKey(t)) return false;
            p = states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

}
