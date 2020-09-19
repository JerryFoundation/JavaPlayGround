package test.algorithm;

/**
 * 查找最后一个小于等于给定值的元素
 *
 * @author zhuqianchao
 * @date 2020/8/27 21:09
 */
public class BinarySearch4 {

    public static void main(String[] args) {

        int[] a = {3, 4, 6, 7, 7, 8, 9};

        System.out.println(binarySearch(a, a.length, 5));

    }


    public static int binarySearch(int[] a, int n, int value) {
        return binaryIn(a, 0, n - 1, value);
    }


    private static int binaryIn(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        // 当mid值大于给定值， 直接继续查找 范围 low 到 mid -1 区间
        if (a[mid] > value) {
            return binaryIn(a, low, mid - 1, value);
        }
        // 当mid 如果是最后一个了 则返回mid
        // 否则判断一下 mid + 1 的值 如果大于给定值
        // 那么 mid 就是最后一个 小于等于 给定值的下标了，返回
        if (mid == high || (a[mid + 1] > value)) {
            return mid;
        }

        // 如果mid + 1 仍然小于或者等于给定值， 那么需要继续递归查找
        // 区间问 mid + 1 到high 直到找到最后一个小于等于给定值的下标
        return binaryIn(a, mid + 1, high, value);

    }
}
