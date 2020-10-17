package org.jerry.test.leetcode;

/**
 * @author zhuqianchao
 * @date 2020/9/5 20:35
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(5));
    }

    public String countAndSay(int n) {
        // 递归终止条件
        if (n == 1) {
            return "1";
        }
        // 拿到上一层的字符串
        StringBuilder sb = new StringBuilder();
        String str = countAndSay(n - 1);
        int length = str.length();
        // 开始指针为0
        int start = 0;
        // 注意这从起始条件要和下面长度统一
        for (int i = 1; i < length + 1; i++) {
            // 字符串最后一位直接拼接
            if (i == length) {
                sb.append(i - start).append(str.charAt(start));
                // 直到start位的字符串和i位的字符串不同，拼接并更新start位
            } else if (str.charAt(i) != str.charAt(start) ) {
                sb.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return sb.toString();
    }
}
