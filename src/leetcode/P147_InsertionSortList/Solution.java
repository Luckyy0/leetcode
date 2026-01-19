package leetcode.P147_InsertionSortList;

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
     * Problem 147: Insertion Sort List
     * Approach: Build sorted list from dummy head
     * 
     * Theoretical Basis:
     * - Create a dummy head for the sorted part.
     * - For each node in original list, find its place in the sorted part and link.
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            // Save next node to process
            ListNode next = curr.next;

            // Find position to insert in sorted list
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to next node
            curr = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [4, 2, 1, 3]
        ListNode n4 = new ListNode(3);
        ListNode n3 = new ListNode(1, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(4, n2);

        ListNode sorted = solution.insertionSortList(n1);
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
