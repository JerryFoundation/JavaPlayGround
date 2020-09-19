package test.algorithm;

import java.util.StringJoiner;

/**
 * @author zhuqianchao
 * @date 2020/8/30 17:22
 */
public class BinarySearchTree {
    private Node tree;

    public Node getTree() {
        return tree;
    }

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        t.insert(33);
        t.insert(16);
        t.insert(50);
        t.insert(13);
        t.insert(18);
        t.insert(34);
        t.insert(58);
        t.insert(15);
        t.insert(17);
        t.insert(25);
        t.insert(51);
        t.insert(66);
        t.insert(19);
        t.insert(27);
        t.insert(55);


//        t.delete(33);


        System.out.println(t.successor(t.getTree()));
    }


    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }


    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }


    public void delete(int data) {
        Node p = tree; // p指向要删除的节点，初始化指向根节点
        Node pp = null; // pp记录的是p的父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }
        if (p == null) return; // 没有找到

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) { // 查找右子树中最小节点
            Node minP = p.right;
            Node minPP = p; // minPP表示minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 将minP的数据替换到p中
            p.data = minP.data;
            // 下面就变成了删除minP了
            p = minP;
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        // 删除的是根节点
        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }


    /**
     * 后继节点 ， 当前节点右子树中最小的那个节点值， 实际上就是右子树
     * 最左子树叶子节点值
     *
     * @author zhuqianchao
     * @date 2020/8/30 20:48
     */
    public int successor(Node root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }


    /**
     * 前驱节点， 当前节点左子树 最大小于当前节点的值
     * 也就是说是当前节点 左子树的最右叶子节点值
     *
     * @author zhuqianchao
     * @date 2020/8/30 20:51
     */
    public int predecessor(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            char a = 'a' , b = 'a';
            System.out.println(a == b);
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("data=" + data)
                    .add("left=" + left)
                    .add("right=" + right)
                    .toString();
        }
    }
}
