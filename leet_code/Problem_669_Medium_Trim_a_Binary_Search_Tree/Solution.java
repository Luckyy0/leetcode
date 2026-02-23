package leet_code.Problem_669_Medium_Trim_a_Binary_Search_Tree;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    /**
     * Trims a Binary Search Tree to contain only values in [low, high].
     * Strategy: Recursive approach utilizing BST properties to skip branches.
     * Time: O(N), Space: O(H).
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        // If current node's value is too small, skip it and its left subtree
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        // If current node's value is too large, skip it and its right subtree
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // Value is in range, recursively trim children and link back
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        TreeNode result = sol.trimBST(root, 1, 2);
        System.out.println("Root: " + (result != null ? result.val : "null")); // 1
    }
}
