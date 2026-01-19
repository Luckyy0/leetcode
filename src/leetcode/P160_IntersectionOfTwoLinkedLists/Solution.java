package leetcode.P160_IntersectionOfTwoLinkedLists;

public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Problem 160: Intersection of Two Linked Lists
     * Approach: Two Pointers (Distance Alignment)
     * 
     * Theoretical Basis:
     * - Pointer A travels List A + List B
     * - Pointer B travels List B + List A
     * - Total distance is length(A) + length(B) for both.
     * - They will meet at the intersection point or at null (end).
     * 
     * Time Complexity: O(M + N)
     * Space Complexity: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;

        // Loop runs max M+N times.
        // If no intersection, both will be null at the same time.
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Setup Intersection part: 8 -> 4 -> 5
        ListNode inter1 = new ListNode(8);
        ListNode inter2 = new ListNode(4);
        ListNode inter3 = new ListNode(5);
        inter1.next = inter2;
        inter2.next = inter3;

        // List A: 4 -> 1 -> (Intersection)
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        a1.next = a2;
        a2.next = inter1;

        // List B: 5 -> 6 -> 1 -> (Intersection)
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(1);
        b1.next = b2;
        b2.next = b3;
        b3.next = inter1;

        ListNode result = solution.getIntersectionNode(a1, b1);
        System.out.println("Intersection val: " + (result != null ? result.val : "null")); // 8
    }
}
