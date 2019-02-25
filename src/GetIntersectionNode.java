/**
 * Created by chenchangxing on 2019/2/25.
 */
public class GetIntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        int sizeA = 0;
        int sizeB = 0;

        while (nodeA != null) {
            sizeA++;
            nodeA = nodeA.next;
        }

        while (nodeB != null) {
            sizeB++;
            nodeB = nodeB.next;
        }

        int b = Math.abs(sizeA - sizeB);

        ListNode nodeLong = Math.max(sizeA, sizeB) == sizeA ? headA: headB;
        ListNode nodeShort = Math.max(sizeA, sizeB) == sizeA ? headB: headA;

        while (nodeLong != null && nodeShort != null) {
            if (b > 0) {
                nodeLong = nodeLong.next;
                b--;
                continue;
            }

            if (nodeShort.equals(nodeLong)) {
                return nodeShort;
            }

            nodeLong = nodeLong.next;
            nodeShort = nodeShort.next;
        }

        return null;
    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA: pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode nodeC = new ListNode(8);
        nodeC.next = new ListNode(4);
        nodeC.next.next = new ListNode(5);

        ListNode nodeA = new ListNode(4);
        nodeA.next = new ListNode(1);
        nodeA.next.next = nodeC;

        ListNode nodeB = new ListNode(5);
        nodeB.next = new ListNode(0);
        nodeB.next.next = new ListNode(1);
        nodeB.next.next.next = nodeC;

        System.out.println(getIntersectionNode1(nodeA, nodeB).val);
    }
}
