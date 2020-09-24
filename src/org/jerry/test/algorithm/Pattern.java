package org.jerry.test.algorithm;

/**
 * 简易正则表达式
 * 用回溯实现一个简易正则表达式
 * * 匹配任意字符
 * ？匹配0个或1个字符
 *
 * @author zhuqianchao
 * @date 16/9/2020 20:25
 */

public class Pattern {
    private boolean matched = false;
    private char[] pattern; // 正则表达式
    private int plen; // 正则表达式长度

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    /**
     * @param text 文本串
     * @param tlen 文本串长度
     * @return boolean
     * @throws
     * @author zhuqianchao
     * @date 16/9/2020 20:32
     */
    public boolean match(char[] text, int tlen) {
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    /**
     * @param ti
     * @param pj
     * @param text
     * @param tlen
     * @return void
     * @throws
     * @author zhuqianchao
     * @date 16/9/2020 20:29
     */
    private void rmatch(int ti, int pj, char[] text, int tlen) {
        if (matched) return; // 如果已经匹配了，就不要继续递归了
        if (pj == plen) { // 正则表达式到结尾了
            if (ti == tlen) matched = true; // 文本串也到结尾了
            return;
        }
        if (pattern[pj] == '*') { // *匹配任意个字符
            for (int k = 0; k <= tlen - ti; ++k) {
                rmatch(ti + k, pj + 1, text, tlen);
            }
        } else if (pattern[pj] == '?') { // ?匹配0个或者1个字符
            rmatch(ti, pj + 1, text, tlen);
            rmatch(ti + 1, pj + 1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) { // 纯字符匹配才行
            rmatch(ti + 1, pj + 1, text, tlen);
        }
    }

    public static void main(String[] args) {
        Pattern p = new Pattern(new char[]{'?'}, 1);

        System.out.println(p.match(new char[]{'a', 'b', 'c', 'd'}, 4));
    }
}
