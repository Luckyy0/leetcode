package leetcode.P110_BalancedBinaryTree;

public class Solution {

    public static class TreeNode {
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

    /**
     * Problem 110: Balanced Binary Tree
     * Approach: Bottom-Up Height Check (Optimized)
     * 
     * Theoretical Basis:
     * - A tree is height-balanced if for every node: |leftHeight - rightHeight| <=
     * 1
     * - Naive approach: compute height separately for each node -> O(N²)
     * - Optimized: combine height calculation with balance check in single pass
     * - Use -1 as sentinel to indicate "unbalanced" -> early termination
     * 
     * Time Complexity: O(N) - each node visited exactly once
     * Space Complexity: O(H) - recursion stack depth equals tree height
     */
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    /**
     * Returns the height of the tree if balanced, -1 if unbalanced.
     * This allows early termination and single-pass solution.
     */
    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Check left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced, propagate failure
        }

        // Check right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is unbalanced, propagate failure
        }

        // Check balance at current node
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node violates balance property
        }

        // Return height for parent to use
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [3,9,20,null,null,15,7] -> true
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        runTest(solution, root1, true);

        // Test 2: [1,2,2,3,3,null,null,4,4] -> false
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3));
        root2.right = new TreeNode(2);
        runTest(solution, root2, false);

        // Test 3: null -> true
        runTest(solution, null, true);

        // Test 4: Single node -> true
        runTest(solution, new TreeNode(1), true);
    }

    private static void runTest(Solution s, TreeNode root, boolean expected) {
        boolean result = s.isBalanced(root);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
