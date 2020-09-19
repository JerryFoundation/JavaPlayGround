package test.leetcode;

/**
 * @author zhuqianchao
 * @date 2020/8/30 09:56
 */
public class IntReverse {

    public static void main(String[] args) {

        System.out.println(new IntReverse().reverse(-2147483648));
    }

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            // 将上一次取出的个位数 扩充10倍 然后加上这次取出的个位数
            res = res * 10 + x % 10;
            // 砍掉这次给定值x 的个位数
            x /= 10;
        }
        // 将结果long型转回int型， 如果 转回int 不等于 long 那么说明已经溢出了，就返回0
        // 否则原值返回
        return (int) res == res ? (int) res : 0;
    }
}
