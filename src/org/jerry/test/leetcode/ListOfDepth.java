package org.jerry.test.leetcode;

import java.util.*;

/**
 *
 * 广度优先遍历树
 * @author zhuqianchao
 * @date 18/9/2020 15:39
 */
public class ListOfDepth {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t.left = t2;
        t.right = t3;
        t2.left = t4;
        t3.right = t5;

        System.out.println(Arrays.toString(new ListOfDepth().listOfDepth(t)));
    }

    public ListNode[] listOfDepth(TreeNode tree) {

        // 用队列存储要搜索的树
        LinkedList<TreeNode> queue = new LinkedList<>();

        // 开始存根节点
        queue.offer(tree);

        // 这里是要返回结果
        List<ListNode> res = new ArrayList<>();

        // 定义一个 虚拟节点为头结点
        ListNode dummy = new ListNode(-1);

        // 队列不为空就继续

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 将虚拟节点设置为当前节点
            ListNode curr = dummy;
            for (int i = 0; i < size; i++) {
                // 取出队头元素
                TreeNode treeNode = queue.poll();
                // 将当前节点的下一个节点 指向这个取出的值构成的节点
                curr.next = new ListNode(treeNode.val);
                // 有左子树, 加入队列
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                // 有右子树， 加入队列
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                // 指针指向下一个节点
                curr = curr.next;
            }
            res.add(dummy.next);
        }
        return res.toArray(new ListNode[] {});

    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .add("next=" + next)
                    .toString();
        }
    }

}
