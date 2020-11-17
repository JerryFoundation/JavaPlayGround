package org.jerry.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuqianchao
 * @date 16/11/2020 22:25
 */
public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(LeetCode998.TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        LinkedList<LeetCode998.TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> in = new LinkedList<>();
            for (int i = 0; i < size ; ++ i) {
                LeetCode998.TreeNode node = queue.pop();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if ((index & 1) == 1) {
                    in.add(node.val);
                }else {
                    in.push(node.val);
                }
            }
            index ++;
            res.add(in);
        }

        return res;

    }
}
