import java.util.List;

/**
 * Created by chenchangxing on 2018/12/25.
 */
public class IsPalindromeNode {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reverse = reverse(slow.next);

        while (head != null && reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }

            head = head.next;
            reverse = reverse.next;
        }

        return true;
    }

    static ListNode reverse(ListNode head) {
        ListNode tmp;
        ListNode result = null;

        while (head != null) {
            tmp = head.next;
            head.next = result;

            result = head;
            head = tmp;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(node));
    }
}
