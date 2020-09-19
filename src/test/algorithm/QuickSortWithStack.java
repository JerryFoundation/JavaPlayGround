package test.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 用栈实现快速排序
 *
 * @author zhuqianchao
 * @date 19/9/2020 13:10
 */
public class QuickSortWithStack {

    public static void main(String[] args) {
        int[] arr = {29, 23, 4, 3, 25, 189, 11};
        QuickSortWithStack.quickSortWithStack(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSortWithStack(int[] arr, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> quickStack = new Stack<>();
        // 用hash 存储开始位置和结束位置
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);

        quickStack.push(rootParam);

        while (!quickStack.isEmpty()) {
            Map<String, Integer> param = quickStack.pop();

            int pivot = partition(arr, param.get("startIndex"), param.get("endIndex"));

            if (param.get("startIndex") < pivot - 1) {
                Map<String, Integer> left = new HashMap<>();
                left.put("startIndex", param.get("startIndex"));
                left.put("endIndex", pivot - 1);
                quickStack.push(left);
            }

            if (param.get("endIndex") > pivot + 1) {
                Map<String, Integer> right = new HashMap<>();
                right.put("startIndex", pivot + 1);
                right.put("endIndex", param.get("endIndex"));
                quickStack.push(right);
            }
        }
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; ++i) {
            if (arr[i] <  pivot) {
                mark ++;
                int p = arr[i];
                arr[i] = arr[mark];
                arr[mark] = p;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

}
