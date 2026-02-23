package leet_code.Problem_160_Easy_Intersection_Of_Two_Linked_Lists;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution_TwoPointers {

    /**
     * Finds the intersection node of two singly linked lists.
     * Uses the two-pointer technique to balance lengths.
     * O(M+N) time and O(1) space.
     * 
     * Tìm nút giao điểm của hai danh sách liên kết đơn.
     * Sử dụng kỹ thuật hai con trỏ để cân bằng độ dài.
     * Thời gian O(M+N) và không gian O(1).
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        // Traverse both lists. When reaching end, switch to the other head.
        // Once both have completed the switch, they will be equidistant to the
        // intersection.
        // Duyệt cả hai danh sách. Khi đến cuối, chuyển sang đầu của danh sách kia.
        while (pA != pB) {
            // If pA is null, redirect to headB. Otherwise, move to next.
            pA = (pA == null) ? headB : pA.next;
            // If pB is null, redirect to headA. Otherwise, move to next.
            pB = (pB == null) ? headA : pB.next;
        }

        // They either meet at the intersection node or at null (no intersection)
        return pA;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Creating an intersection
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // List A: 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // List B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        ListNode intersection = solution.getIntersectionNode(headA, headB);
        if (intersection != null) {
            System.out.println("Intersected at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection.");
        }
    }
}
