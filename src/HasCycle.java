import java.util.List;

/**
 * Created by chenchangxing on 2018/12/26.
 */
public class HasCycle {
    static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast.next == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = listNode;
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = listNode.next;

        System.out.println(hasCycle(listNode));
    }
}
