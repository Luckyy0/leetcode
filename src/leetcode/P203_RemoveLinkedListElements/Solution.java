package leetcode.P203_RemoveLinkedListElements;

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
     * Problem 203: Remove Linked List Elements
     * Approach: Dummy Head Iteration
     * 
     * Theoretical Basis:
     * - Use a dummy head to simplify removal of head nodes.
     * - Look ahead to check current.next.val.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the node
                current.next = current.next.next;
            } else {
                // Move forward
                current = current.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,6,3,4,5,6], val=6 -> [1,2,3,4,5]
        ListNode n6_2 = new ListNode(6);
        ListNode n5 = new ListNode(5, n6_2);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n6_1 = new ListNode(6, n3);
        ListNode n2 = new ListNode(2, n6_1);
        ListNode n1 = new ListNode(1, n2);

        ListNode res = solution.removeElements(n1, 6);
        printList(res);

        // [7,7,7,7], val=7 -> []
        ListNode m4 = new ListNode(7);
        ListNode m3 = new ListNode(7, m4);
        ListNode m2 = new ListNode(7, m3);
        ListNode m1 = new ListNode(7, m2);

        ListNode res2 = solution.removeElements(m1, 7);
        printList(res2);
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
