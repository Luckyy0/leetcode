package leetcode.P430_FlattenAMultilevelDoublyLinkedList;

import java.util.Stack;

public class Solution {

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Problem 430: Flatten a Multilevel Doubly Linked List
     * Approach: Stack-based Iterative DFS
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(D) stack space
     */
    public Node flatten(Node head) {
        if (head == null)
            return null;

        Stack<Node> stack = new Stack<>();
        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                // If there's a next node, push it to stack to process later
                if (curr.next != null) {
                    stack.push(curr.next);
                }

                // Link current to child
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            } else if (curr.next == null && !stack.isEmpty()) {
                // End of current sublist, pick up from stack
                Node next = stack.pop();
                curr.next = next;
                next.prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 1 - 2 - 3 - 4
        // |
        // 7 - 8
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n3.child = n7;
        n7.next = n8;
        n8.prev = n7;

        Node resultHead = sol.flatten(n1);

        // Print 1-2-3-7-8-4
        Node temp = resultHead;
        System.out.print("Flattened: ");
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
