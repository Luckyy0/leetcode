package leetcode.P148_SortList;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Problem 148: Sort List
     * Approach: Recursive Merge Sort
     * 
     * Theoretical Basis:
     * - Divide the list into two halves.
     * - Recursively sort.
     * - Merge two sorted lists.
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(log N) for recursion stack
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 1. Split list into two halves
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // Sever the list

        // 2. Sort halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // 3. Merge
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null)
            current.next = l1;
        if (l2 != null)
            current.next = l2;

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [4, 2, 1, 3]
        ListNode n4 = new ListNode(3);
        ListNode n3 = new ListNode(1, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(4, n2);

        ListNode sorted = solution.sortList(n1);
        printList(sorted); // 1 -> 2 -> 3 -> 4
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }
}
