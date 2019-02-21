/**
 * Created by chenchangxing on 2019/2/21.
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        ListNode header = null;
        boolean isAddOne = false;

        while (l1 != null && l2 != null) {
            int value;
            value = l1.val + l2.val;
            value = value + (isAddOne ? 1 : 0);
            int value1 = value >= 10 ? value - 10 : value;

            if (listNode == null) {
                listNode = new ListNode(value1);
                header = listNode;
            } else {
                listNode.next = new ListNode(value1);
            }

            isAddOne = value >= 10;


            l1 = l1.next;
            l2 = l2.next;

            if (listNode.next != null) {
                listNode = listNode.next;
            }
        }

        while (l1 != null) {
            int value = l1.val + (isAddOne ? 1 : 0);
            int value1 = value >= 10 ? value - 10 : value;
            listNode.next = new ListNode(value1);
            isAddOne = value >= 10;
            l1 = l1.next;
            listNode = listNode.next;
        }

        while (l2 != null) {
            int value = l2.val + (isAddOne ? 1 : 0);
            int value1 = value >= 10 ? value - 10 : value;
            listNode.next = new ListNode(value1);
            isAddOne = value >= 10;
            l2 = l2.next;
            listNode = listNode.next;
        }

        if (isAddOne) {
            listNode.next = new ListNode(1);
        }

        return header;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
