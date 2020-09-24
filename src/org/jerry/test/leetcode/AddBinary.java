package org.jerry.test.leetcode;

/**
 * @author zhuqianchao
 * @date 2020/9/10 21:37
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println((int) '1');
        System.out.println((int) '0');
        System.out.println(new AddBinary().addBinary("1000101", "10101111"));
    }


    public String addBinary(String a, String b) {

        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            // - '0' 是为了让ASCII码等于 1 或者 0 不然 '1'的ASCII码 并不是 1 而是49
            // 相应的 '0' 的ASCII 是 48  所以需要 49 - 48 等于 1   48 -48 等于0 这样取得
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = (sum >> 1);
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}