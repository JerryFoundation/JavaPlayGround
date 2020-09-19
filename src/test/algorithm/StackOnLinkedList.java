package test.algorithm;

/**
 * @author zhuqianchao
 * @date 2020/8/23 22:15
 */
public class StackOnLinkedList {

    private Node top = null;

    public void push(Node node) {
        node.next = top;
        top = node;
    }

    public Node pop() {
        if (top != null) {
            Node re = top;
            top = top.next;
            return re;
        }
        return null;
    }

    public Node getTop() {
        return top;
    }

    public static void main(String[] args) {
        StackOnLinkedList stack = new StackOnLinkedList();
        for (int i = 0; i < 10; i++) {
            stack.push(new Node(i + ""));
        }

       while (stack.getTop() != null) {
           System.out.println(stack.pop().getValue());
       }
    }


    static class Node {
        private String value;


        private Node next;

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
