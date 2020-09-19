package test.leetcode;

/**
 * @author zhuqianchao
 * @date 2020/8/30 13:24
 */
public class Palindrome {
    public static void main(String[] args) {

        System.out.println(new Palindrome().isPalindrome(1234554321));
    }


    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int ori = x;
        int temp = 0;
        while (x > 0) {
            temp = temp * 10 + x % 10;
            x = x / 10;
        }

        return temp == ori;
    }
}
