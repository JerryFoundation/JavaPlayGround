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

//        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent(a, k)));
        System.out.println(new TopKFrequent.Solution().topKFrequent(a, k));
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


    /**
     * K个频率最高的数
     */
    static class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            // 遍历map，用最小堆保存频率最大的k个元素
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return map.get(a) - map.get(b);
                }
            });
            for (Integer key : map.keySet()) {
                if (pq.size() < k) {
                    pq.add(key);
                } else if (map.get(key) > map.get(pq.peek())) {
                    pq.remove();
                    pq.add(key);
                }
            }
            // 取出最小堆中的元素
            List<Integer> res = new ArrayList<>();
            while (!pq.isEmpty()) {
                // 节省空间， 把堆元素移除， 添加到结果中
                res.add(pq.remove());
            }
            return res;
        }
    }
}
