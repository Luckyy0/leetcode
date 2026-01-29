package leetcode.P510_InorderSuccessorInBSTII;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}

public class Solution {

    /**
     * Problem 510: Inorder Successor in BST II
     * Approach: Leverage right subtree or parent pointers
     * 
     * Time Complexity: O(H) where H is tree height
     * Space Complexity: O(1)
     */
    public Node inorderSuccessor(Node node) {
        if (node == null)
            return null;

        // Case 1: Has right child
        if (node.right != null) {
            Node res = node.right;
            while (res.left != null) {
                res = res.left;
            }
            return res;
        }

        // Case 2: No right child, move up to find an ancestor where this node is in the
        // left branch
        Node curr = node;
        while (curr.parent != null && curr.parent.right == curr) {
            curr = curr.parent;
        }

        return curr.parent;
    }

    public static void main(String[] args) {
        // Mocking setup for testing
        Node n1 = new Node();
        n1.val = 1;
        Node n2 = new Node();
        n2.val = 2;
        Node n3 = new Node();
        n3.val = 3;

        n2.left = n1;
        n1.parent = n2;
        n2.right = n3;
        n3.parent = n2;

        Solution sol = new Solution();
        Node res = sol.inorderSuccessor(n1); // Successor of 1 is 2
        System.out.println("Successor of 1: " + (res != null ? res.val : "null") + " (Expected: 2)");

        res = sol.inorderSuccessor(n2); // Successor of 2 is 3
        System.out.println("Successor of 2: " + (res != null ? res.val : "null") + " (Expected: 3)");

        res = sol.inorderSuccessor(n3); // Successor of 3 is null
        System.out.println("Successor of 3: " + (res != null ? res.val : "null") + " (Expected: null)");
    }
}
