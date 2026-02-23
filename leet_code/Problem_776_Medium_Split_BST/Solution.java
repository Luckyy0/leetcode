package leet_code.Problem_776_Medium_Split_BST;

import java.util.Arrays;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    // Helpers for display
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

public class Solution {

    /**
     * Splits BST into two subtrees: <= target and > target.
     * Strategy: Recursive cut.
     * Time: O(H), Space: O(H).
     */
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode[] { null, null };
        }

        if (root.val <= target) {
            // Root belongs to the "Small" (<= target) tree.
            // But its right subtree might contain nodes > target.
            // Split the right subtree.
            TreeNode[] res = splitBST(root.right, target);

            // Connect the "small" part of the right split to root.right
            root.right = res[0];

            // Return {Small Root, Large Root}
            // Current root is the head of the Small tree.
            // res[1] is the head of the Large tree (which was cut off from the right).
            return new TreeNode[] { root, res[1] };
        } else {
            // Root belongs to the "Large" (> target) tree.
            // But its left subtree might contain nodes <= target.
            // Split the left subtree.
            TreeNode[] res = splitBST(root.left, target);

            // Connect the "large" part of the left split to root.left
            root.left = res[1];

            // Return {Small Root, Large Root}
            // res[0] is the head of the Small tree (which was cut off from the left).
            // Current root is the head of the Large tree.
            return new TreeNode[] { res[0], root };
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Construct example tree: [4,2,6,1,3,5,7]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        TreeNode[] res = sol.splitBST(root, 2);
        System.out.println("Result Small Root: " + (res[0] != null ? res[0].val : "null")); // Expected 2
        System.out.println("Result Large Root: " + (res[1] != null ? res[1].val : "null")); // Expected 4

        // Detailed check for child connections
        // Small (2) should have left 1, right null
        // Large (4) should have left 3, right 6
    }
}
