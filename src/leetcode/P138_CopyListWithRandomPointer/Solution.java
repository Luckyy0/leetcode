package leetcode.P138_CopyListWithRandomPointer;

public class Solution {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * Problem 138: Copy List with Random Pointer
     * Approach: O(1) Space Interweaving
     * 
     * Theoretical Basis:
     * - Create copies and insert them right after original nodes.
     * - A -> A' -> B -> B'
     * - Set copy.random = original.random.next
     * - Extract copy list.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Step 1: Clone nodes and insert after original
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }

        // Step 2: Set random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate lists
        curr = head;
        Node pseudoHead = new Node(0);
        Node copyCurr = pseudoHead;

        while (curr != null) {
            Node next = curr.next.next;

            // Extract the copy
            Node copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;

            // Restore original
            curr.next = next;
            curr = next;
        }

        return pseudoHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a simple list: 1 -> 2
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        n1.random = n2; // 1's random is 2
        n2.random = n2; // 2's random is 2 (itself)

        Node copiedHead = solution.copyRandomList(n1);
        System.out.println("Original 1 val: " + n1.val + ", Random: " + n1.random.val);
        System.out.println("Copied 1 val: " + copiedHead.val + ", Random: " + copiedHead.random.val);
        System.out.println("Are they same objects? " + (n1 == copiedHead));
        System.out.println("Are random pointers pointing to same objects? " + (n1.random == copiedHead.random));
    }
}
