package leetcode.P116_PopulatingNextRightPointersInEachNode;

public class Solution {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    /**
     * Problem 116: Populating Next Right Pointers in Each Node
     * Approach: Level-by-Level using Next Pointers (O(1) Space)
     * 
     * Theoretical Basis:
     * - Perfect binary tree: all leaves at same level, all internal nodes have 2
     * children
     * - For node n: n.left.next = n.right
     * - For node n with n.next: n.right.next = n.next.left
     * - Use established next pointers to traverse horizontally (no queue needed!)
     * 
     * Time Complexity: O(N) - visit each node once
     * Space Complexity: O(1) - only using existing pointers
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // Start with the leftmost node at each level
        Node leftmost = root;

        // Continue while there's a next level (leftmost has children)
        while (leftmost.left != null) {
            // Traverse current level using next pointers
            Node head = leftmost;

            while (head != null) {
                // Connection 1: left child -> right child (same parent)
                head.left.next = head.right;

                // Connection 2: right child -> next node's left child
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // Move to next node at current level
                head = head.next;
            }

            // Move to next level
            leftmost = leftmost.left;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [1,2,3,4,5,6,7]
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        solution.connect(root1);
        printLevels(root1);
        System.out.println("-----------------");

        // Test 2: Empty tree
        Node root2 = solution.connect(null);
        System.out.println("Empty tree: " + (root2 == null ? "null" : "not null"));
        System.out.println("-----------------");

        // Test 3: Single node
        Node root3 = new Node(1);
        solution.connect(root3);
        System.out.println("Single node next: " + (root3.next == null ? "null" : "not null"));
        System.out.println("-----------------");
    }

    private static void printLevels(Node root) {
        Node leftmost = root;
        while (leftmost != null) {
            Node curr = leftmost;
            StringBuilder sb = new StringBuilder();
            while (curr != null) {
                sb.append(curr.val);
                if (curr.next != null) {
                    sb.append(" -> ");
                }
                curr = curr.next;
            }
            sb.append(" -> #");
            System.out.println(sb.toString());
            leftmost = leftmost.left;
        }
    }
}
