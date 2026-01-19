package leetcode.P141_LinkedListCycle;

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
     * Problem 141: Linked List Cycle
     * Approach: Floyd's Cycle-Finding Algorithm (Tortoise and Hare)
     * 
     * Theoretical Basis:
     * - Use two pointers, slow moving 1 step and fast moving 2 steps.
     * - If they meet, a cycle exists.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: 3 -> 2 -> 0 -> -4 -> 2 (cycle)
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2; // cycle
        System.out.println("Test 1: " + solution.hasCycle(n1)); // Expected: true

        // Test Case 2: 1 -> 2 (no cycle)
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        m1.next = m2;
        System.out.println("Test 2: " + solution.hasCycle(m1)); // Expected: false
    }
}
