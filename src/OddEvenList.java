/**
 * Created by chenchangxing on 2019/2/22.
 */
public class OddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode process = head;
        ListNode tmpHead = null;
        ListNode tmp = null;
        while (process != null) {
            ListNode tmpNode = process.next; //先拿到偶数
            process.next = process.next.next; //将下一个奇数前移

            //处理分支的偶数
            if (tmpHead == null) {
                tmpNode.next = null;
                tmpHead = tmpNode;
                tmp = tmpNode;
            } else {
                tmpNode.next = null;
                tmp.next = tmpNode;
                tmp = tmp.next;
            }

            //处理结尾
            if (process.next.next == null) {
                process.next.next = tmpHead;
                return head;
            }

            if (process.next.next.next == null) {
                ListNode last = new ListNode(process.next.next.val);
                process.next.next = tmpHead;
                tmp.next = last;
                return head;
            }

            process = process.next;
        }

        return head;
    }


    public static ListNode oddEvenList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);


        ListNode node1 = oddEvenList1(node);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }

    }
}
