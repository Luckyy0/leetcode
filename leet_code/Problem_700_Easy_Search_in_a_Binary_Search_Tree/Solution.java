package leet_code.Problem_700_Easy_Search_in_a_Binary_Search_Tree;

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
     * Searches for a value in a Binary Search Tree (BST).
     * Strategy: Iterative search using the BST property (Left < Node < Right).
     * Time: O(H), Space: O(1).
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;

        while (current != null) {
            if (current.val == val) {
                // Target found
                return current;
            } else if (current.val > val) {
                // Search in the left subtree
                current = current.left;
            } else {
                // Search in the right subtree
                current = current.right;
            }
        }

        // Target not found
        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: [4,2,7,1,3], val = 2
        TreeNode root1 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7));
        TreeNode res1 = sol.searchBST(root1, 2);
        System.out.println("Found node val: " + (res1 != null ? res1.val : "null")); // 2

        // Example 2: val = 5
        TreeNode res2 = sol.searchBST(root1, 5);
        System.out.println("Found node val: " + (res2 != null ? res2.val : "null")); // null
    }
}
