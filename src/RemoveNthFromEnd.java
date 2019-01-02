/**
 * Created by chenchangxing on 2018/12/20.
 */
public class RemoveNthFromEnd {
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        ListNode end;
        while (start.next != null) {
            end = start;
            if (n == 1) {
                if (end.next.next == null) {
                    start.next = null;
                    return head;
                }
            } else {
                for (int i = 0; i < n - 1; i++) {
                    if (end.next.next == null) {
                        start.val = start.next.val;
                        start.next = start.next.next;
                        return head;
                    }
                    end = end.next;
                }
            }

            start = start.next;
        }

        return null;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode p, q;
        p = head;
        q = head;
        while (n > 0) {
            p = p.next;
            n--;
        }
        if (p == null) {
            head = head.next;
            return head;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);

        ListNode node = removeNthFromEnd1(listNode, 1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
