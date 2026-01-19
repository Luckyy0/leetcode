package leetcode.P206_ReverseLinkedList;

public class Solution {

    static class ListNode {
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
     * Problem 206: Reverse Linked List
     * Approach: Iterative
     * 
     * Theoretical Basis:
     * - We iterate through the list, keeping track of the previous node.
     * - For each node, we flip its 'next' pointer to point to 'prev'.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // Store next node
            curr.next = prev; // Reverse the link
            prev = curr; // Move prev forward
            curr = nextTemp; // Move curr forward
        }

        return prev; // prev is the new head
    }

    // Optional: Recursive approach for demonstration
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1->2->3->4->5 -> 5->4->3->2->1
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        System.out.println("Original:");
        printList(n1);

        ListNode reversed = solution.reverseList(n1);
        System.out.println("Reversed:");
        printList(reversed);

        // Test empty
        System.out.println("Empty:");
        printList(solution.reverseList(null));
    }

    private static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val + (head.next != null ? "," : ""));
            head = head.next;
        }
        System.out.println("]");
    }
}
