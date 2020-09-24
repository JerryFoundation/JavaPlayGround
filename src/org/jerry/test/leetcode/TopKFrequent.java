package org.jerry.test.leetcode;

import java.util.*;

/**
 * @author zhuqianchao
 * @date 2020/9/7 20:24
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3, 3, 3, 4, 5};

        int k = 2;

        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent(a, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

//        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(m -> m[1]));
//        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
//            int num = entry.getKey(), count = entry.getValue();
//            if (queue.size() == k) {
//                if (Objects.requireNonNull(queue.peek())[1] < count) {
//                    queue.poll();
//                    queue.offer(new int[]{num, count});
//                }
//            } else {
//                queue.offer(new int[]{num, count});
//            }
//        }
        int[] ret = new int[k];

//        for (int i = 0; i < k; ++i) {
//            ret[i] = Objects.requireNonNull(queue.poll())[0];
//        }


        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(occurrences.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (Map.Entry<Integer, Integer> entry : list) {
            if (k <= 0) {
                break;
            }
            k--;
            ret[k] = entry.getKey();
        }

        return ret;
    }
}
