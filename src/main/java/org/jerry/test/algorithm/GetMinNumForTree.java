package org.jerry.test.algorithm;

/**
 * @author zhuqianchao
 * @date 31/12/2020 09:24
 */
public class GetMinNumForTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        System.out.println(new GetMinNumForTree().getMinNum(node1));
    }


    private int min = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinNum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        dfs(node);
        return min;
    }

    private void dfs (TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);

        if (preNode != null) {
            min = Math.min(min, Math.abs(node.val - preNode.val));
        }
        preNode = node;

        dfs(node.right);
    }

}
