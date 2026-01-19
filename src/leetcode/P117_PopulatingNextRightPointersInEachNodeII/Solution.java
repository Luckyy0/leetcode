package leetcode.P117_PopulatingNextRightPointersInEachNodeII;

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
     * Problem 117: Populating Next Right Pointers in Each Node II
     * Approach: Level-by-Level with Dummy Node (O(1) Space)
     * 
     * Theoretical Basis:
     * - Unlike Problem 116, tree is NOT perfect (nodes may have 0, 1, or 2
     * children)
     * - Use dummy node as head of next level to handle variable children
     * - Traverse current level using next pointers, build next level connections
     * - dummy.next gives actual first node of next level
     * 
     * Time Complexity: O(N) - visit each node once
     * Space Complexity: O(1) - only dummy node (constant)
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node curr = root;

        while (curr != null) {
            // Dummy node to track head of next level
            Node dummy = new Node(0);
            Node tail = dummy;

            // Traverse current level
            while (curr != null) {
                // Add left child if exists
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }

                // Add right child if exists
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }

                // Move to next node in current level
                curr = curr.next;
            }

            // Move to next level
            curr = dummy.next;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [1,2,3,4,5,null,7]
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
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
        Node curr = root;
        while (curr != null) {
            Node head = curr;
            StringBuilder sb = new StringBuilder();
            Node nextLevelHead = null;

            while (head != null) {
                sb.append(head.val);
                if (head.next != null) {
                    sb.append(" -> ");
                }
                if (nextLevelHead == null) {
                    if (head.left != null)
                        nextLevelHead = head.left;
                    else if (head.right != null)
                        nextLevelHead = head.right;
                }
                head = head.next;
            }
            sb.append(" -> #");
            System.out.println(sb.toString());
            curr = nextLevelHead;
        }
    }
}
