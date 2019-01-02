/**
 * Created by chenchangxing on 2018/12/24.
 */
public class MergeTwoLists {
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode tmp = head;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    head.next = l1;
                    l1 = l1.next;
                    head = head.next;
                    continue;
                }

                if (l1.val > l2.val) {
                    head.next = l2;
                    l2 = l2.next;
                    head = head.next;
                    continue;
                }
            }

            if (l2 != null) {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }

            if (l1 != null) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }
        }


        return tmp.next;
    }

    static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode cur = dummy;
        while(l1!=null && l2 != null){
            if(l1.val<=l2.val){
                l1 = l1.next;
            }else{
                ListNode next = l2.next;

                l2.next = cur.next;
                cur.next = l2;

                l2 = next;
            }
            cur = cur.next;
        }
        if(l2!=null){
            cur.next = l2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists1(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
