package leetcode.P143_ReorderList;

public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Problem 143: Reorder List
     * Approach: Find Middle, Reverse Second Half, Merge
     * 
     * Theoretical Basis:
     * 1. Split list into two halves.
     * 2. Reverse the second half.
     * 3. Merge alternating from both halves.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // 1. Find the middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        ListNode prev = null, curr = slow.next;
        slow.next = null; // termination of first half
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Merge
        ListNode first = head, second = prev;
        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;

            first = next1;
            second = next2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Testcase: 1 -> 2 -> 3 -> 4
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        solution.reorderList(n1);
        printList(n1); // Expected: 1 -> 4 -> 2 -> 3
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }
}
