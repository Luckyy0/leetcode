package leet_code.Problem_783_Easy_Minimum_Distance_Between_BST_Nodes;

// Definition for a binary tree node.
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

    // Track the previously visited node value in in-order traversal
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    /**
     * Finds min diff between any two nodes in BST.
     * Strategy: In-order traversal gives sorted values. Check differences between
     * adjacent values.
     * Time: O(N), Space: O(H).
     */
    public int minDiffInBST(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Traverse Left
        inOrder(node.left);

        // Process Current
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        // Traverse Right
        inOrder(node.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println("Result 1: " + sol.minDiffInBST(root)); // 1
    }
}
