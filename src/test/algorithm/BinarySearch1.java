package test.algorithm;

/**
 * 查找最前面一个值是给定值的
 * @author zhuqianchao
 * @date 2020/8/27 21:09
 */
public class BinarySearch1 {

    public static void main(String[] args) {

        int[] a = {1, 2, 2, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 7};

        System.out.println(binarySearch(a, a.length, 7));

    }


    public static int binarySearch(int[] a, int n, int value) {
        return binaryIn(a, 0, n - 1, value);
    }


    private static int binaryIn(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);

        if (a[mid] < value) {
            return binaryIn(a, mid + 1, high, value);
        } else if (a[mid] > value) {
            return binaryIn(a, low, mid - 1, value);
        }
        // 如果mid已经是第一个元素， 或者找到 mid前一个元素 已经不是给定的value值了，那么就返回mid
        if ((mid == 0) || (a[mid - 1] != value)) {
            return mid;
        } else {
            // mid -1 仍然是给定值 ，那么继续把mid -1带入递归继续查找， 看看下个区间中是否还有给定值， 直到没有就返回
            return binaryIn(a, low, mid - 1, value);
        }
    }
}
