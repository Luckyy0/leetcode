package leetcode.P142_LinkedListCycleII;

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
     * Problem 142: Linked List Cycle II
     * Approach: Two-Phase Floyd's Algorithm
     * 
     * Theoretical Basis:
     * - Phase 1: Slow and fast pointers meet inside the cycle.
     * - Phase 2: One pointer starts from head, the other from meeting point.
     * They will meet at the cycle entry.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Meeting point
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle)
            return null;

        // Phase 2: Find entry
        ListNode p1 = head;
        ListNode p2 = slow;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: 3 -> 2 -> 0 -> -4 -> 2 (cycle start at 2)
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        ListNode entry = solution.detectCycle(n1);
        System.out.println("Test 1 start node val: " + (entry != null ? entry.val : "null")); // Expected: 2
    }
}
