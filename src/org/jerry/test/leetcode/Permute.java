package org.jerry.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 全排列
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];

        Stack<Integer> path = new Stack<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Stack<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.push(nums[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.pop();
                System.out.println("递归之后 => " + path);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute solution = new Permute();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}