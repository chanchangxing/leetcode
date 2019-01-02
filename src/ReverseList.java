import java.util.List;

/**
 * Created by chenchangxing on 2018/12/21.
 */
public class ReverseList {
    static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode tmp = new ListNode(head.val);

        while (head != null) {
            tmp.next = pre;
            pre = tmp;
            head = head.next;
            if (head != null) {
                tmp = new ListNode(head.val);
            }
        }
        return pre;
    }

    public static ListNode reverseList1(ListNode head) {
        //反转以前的链表
        if (head == null)
            return null;
        ListNode l1 = null, l2 = null;
        while (head != null) {
            l2 = head.next;
            head.next = l1;
            l1 = head;
            head = l2;
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode listNode = reverseList1(node);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
