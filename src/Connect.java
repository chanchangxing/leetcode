import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchangxing on 2019/3/1.
 */
public class Connect {
    public static Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }

        List<Node> list = new ArrayList<>();
        list.add(root.left);
        list.add(root.right);
        Node process = root.left;

        while (process != null) {
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }

            Node node = process;
            list.clear();
            while (node != null) {
                list.add(node.left);
                list.add(node.right);
                node = node.next;
            }
            process = process.left;
        }

        return root;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.right = new Node(3);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        connect(node);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};