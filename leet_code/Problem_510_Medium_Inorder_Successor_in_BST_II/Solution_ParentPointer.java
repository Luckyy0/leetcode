package leet_code.Problem_510_Medium_Inorder_Successor_in_BST_II;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int val) {
        this.val = val;
    }
};

public class Solution_ParentPointer {

    /**
     * Finds inorder successor.
     * Strategy: Use parent pointer. If right child exists, go right then left. Else
     * go up.
     * Time: O(H), Space: O(1).
     */
    public Node inorderSuccessor(Node node) {
        // Case 1: Node has right subtree
        // Successor is the minimum value in the right subtree
        if (node.right != null) {
            Node curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        // Case 2: No right subtree
        // Go up until we come from a left child
        Node curr = node;
        Node parent = curr.parent;

        while (parent != null && curr == parent.right) {
            curr = parent;
            parent = parent.parent;
        }

        return parent;
    }

    public static void main(String[] args) {
        Solution_ParentPointer solution = new Solution_ParentPointer();
        // Construct simple tree: 1 <- 2 -> 3
        Node root = new Node(2);
        Node left = new Node(1);
        Node right = new Node(3);

        root.left = left;
        left.parent = root;

        root.right = right;
        right.parent = root;

        // Successor of 1 should be 2
        Node res = solution.inorderSuccessor(left);
        System.out.println("Successor of 1: " + (res != null ? res.val : "null")); // 2

        // Successor of 2 should be 3
        res = solution.inorderSuccessor(root);
        System.out.println("Successor of 2: " + (res != null ? res.val : "null")); // 3

        // Successor of 3 should be null
        res = solution.inorderSuccessor(right);
        System.out.println("Successor of 3: " + (res != null ? res.val : "null")); // null
    }
}
