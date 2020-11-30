package org.jerry.test.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringJoiner;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * @author zhuqianchao
 * @date 27/11/2020 14:54
 */
public class LeetCode297 {

    private static class TreeNode {
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

    private static final String NULL = "#", SUB = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SUB);
            return;
        }
        sb.append(root.val).append(SUB);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] a = data.split(",");
        LinkedList<String> l = new LinkedList<>(Arrays.asList(a));
        return dfsDeserialize(l);
    }

    private TreeNode dfsDeserialize(LinkedList<String> l) {
        if (NULL.equals(l.get(0))) {
            l.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(l.get(0)));
        l.remove(0);
        node.left = dfsDeserialize(l);
        node.right = dfsDeserialize(l);

        return node;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(13);
        t1.left = t2;
        t1.right = t3;

        System.out.println(new LeetCode297().serialize(t1));
        System.out.println(new LeetCode297().deserialize("5,2,#,#,13,#,#,"));
    }
}
