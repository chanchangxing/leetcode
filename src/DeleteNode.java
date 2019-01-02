import java.util.List;

/**
 * Created by chenchangxing on 2018/12/19.
 */
public class DeleteNode {
    public static void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }

        node.val = node.next.val;
        node.next = null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);

        deleteNode(node.next);

        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}