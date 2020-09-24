package org.jerry.test.leetcode;

import java.util.*;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * @author zhuqianchao
 * @date 24/9/2020 22:01
 */
public class LeetCode501 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(2);
        t1.right = t2;
//        t2.left = t3;
        System.out.println(Arrays.toString(new LeetCode501().findMode(t1)));
    }

    List<Integer> mList = new ArrayList<>();
    int curent = 0;
    int count = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] res = new int[mList.size()];
        //把集合list转化为数组
        for (int i = 0; i < mList.size(); i++) {
            res[i] = mList.get(i);
        }
        return res;
    }

    //非递归方式
    public void inOrderTraversal(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                int nodeValue = tree.val;
                if (nodeValue == curent) {
                    //如果节点值等于curent，count就加1
                    count++;
                } else {
                    //否则，就表示遇到了一个新的值，curent和count都要
                    //重新赋值
                    curent = nodeValue;
                    count = 1;
                }
                if (count == maxCount) {
                    //如果count == maxCount，就把当前节点加入到集合中
                    mList.add(nodeValue);
                } else if (count > maxCount) {
                    //否则，当前节点的值重复量是最多的，直接把list清空，然后
                    //把当前节点的值加入到集合中
                    mList.clear();
                    mList.add(nodeValue);
                    maxCount = count;
                }
                tree = tree.right;
            }
        }
    }
}
