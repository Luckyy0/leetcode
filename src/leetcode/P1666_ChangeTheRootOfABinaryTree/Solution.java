package leetcode.P1666_ChangeTheRootOfABinaryTree;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

public class Solution {
    public Node flipBinaryTree(Node root, Node leaf) {
        // We start from leaf and move upwards
        Node curr = leaf;
        Node parent = curr.parent;
        Node newParent = null; // leaf will be new root

        while (curr != root) {
            // Save next step up
            Node gParent = parent.parent;

            // Unlink curr from parent
            if (parent.left == curr)
                parent.left = null;
            else
                parent.right = null;

            // Link curr to parent (parent becomes child)
            if (curr.left != null)
                curr.right = parent;
            else
                curr.left = parent;

            // Update parent pointers
            curr.parent = newParent;
            newParent = curr;

            // Move up
            curr = parent;
            parent = gParent;
        }

        // Handle original root
        // Curr is now original root. Parent is null.
        curr.parent = newParent;
        if (curr.left != null)
            curr.right = null;
        else
            curr.left = null;
        // Note: one child of original root is now its parent (newParent). But we
        // disconnected it above.
        // Wait, looping logic needs to be careful about child slot reuse for root.
        // Re-do logic simply:

        return flip(leaf, null);
    }

    // Recursive approach works naturally to "backtrack" changes
    private Node flip(Node node, Node newParent) {
        Node oldParent = node.parent;
        node.parent = newParent;

        if (node.left == newParent)
            node.left = null;
        if (node.right == newParent)
            node.right = null;

        if (node == newParent)
            return node; // Shouldn't happen standard traversal

        if (oldParent != null) {
            flip(oldParent, node);
            // After returning, oldParent has been processed and points to 'node' as its
            // parent.
            // We now make oldParent a child of node.

            // We already cleared the child slot of oldParent that pointed to node? No.
            // Actually, recursion sets structure.
            if (node.left != null)
                node.right = oldParent;
            else
                node.left = oldParent;
        }

        return node;
    }
}
