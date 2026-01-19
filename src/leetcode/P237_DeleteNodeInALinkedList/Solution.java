package leetcode.P237_DeleteNodeInALinkedList;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        // Helper for testing
        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    /**
     * Problem 237: Delete Node in a Linked List
     * Approach: Copy value from next node, then delete next node.
     * 
     * Theoretical Basis:
     * - Access to head is missing, so we cannot update predecessor.
     * - We simulate deletion by overwriting current node with next node's data.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void deleteNode(ListNode node) {
        // Since we are guaranteed node is not tail:
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [4,5,1,9], delete 5
        ListNode n9 = new ListNode(9);
        ListNode n1 = new ListNode(1, n9);
        ListNode n5 = new ListNode(5, n1);
        ListNode head = new ListNode(4, n5);

        System.out.print("Original: ");
        printList(head);

        solution.deleteNode(n5);

        System.out.print("After deleting 5: ");
        printList(head);
        // Expected: 4 -> 1 -> 9

        // Test 2: [4,5,1,9], delete 1
        // Create fresh list to avoid object identity confusion from previous op
        n9 = new ListNode(9);
        n1 = new ListNode(1, n9);
        n5 = new ListNode(5, n1);
        head = new ListNode(4, n5);

        solution.deleteNode(n1);

        System.out.print("Original 2: 4->5->1->9. After deleting 1: ");
        printList(head);
        // Expected: 4 -> 5 -> 9
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }
}
