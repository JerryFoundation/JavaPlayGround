package org.jerry.test.leetcode;

import java.util.StringJoiner;

/**
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 *
 * @author zhuqianchao
 * @date 25/11/2020 15:33
 */
public class LeetCode654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .add("left=" + left)
                    .add("right=" + right)
                    .toString();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 6, 2, 4};
        System.out.println(new LeetCode654().constructMaximumBinaryTree(nums));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    /**
     *
     * @param nums
     * @param lo
     * @param hi
     * @author zhuqianchao
     * @date 25/11/2020 15:41
     * @return org.jerry.test.leetcode.LeetCode654.TreeNode
     * @throws
     */
    private TreeNode buildTree(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        // 最大值的下标
        int index = -1;
        for (int i = lo; i <= hi; i++) {
            if (max < nums[i]) {
                max = nums[i];
                // 更新下标
                index = i;
            }
        }
        // 前序遍历，根节点最大
        TreeNode root = new TreeNode(max);

        // 组装左子树
        root.left = buildTree(nums, lo, index - 1);
        // 组装右子树
        root.right = buildTree(nums, index + 1, hi);

        return root;
    }
}
