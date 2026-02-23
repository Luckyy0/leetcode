package leet_code.Problem_687_Medium_Longest_Univalue_Path;

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
    private int maxLen = 0;

    /**
     * Finds the length of the longest path where each node has the same value.
     * Strategy: Post-order DFS tracking single-branch univalue paths.
     * Time: O(N), Space: O(H).
     */
    public int longestUnivaluePath(TreeNode root) {
        maxLen = 0;
        dfs(root);
        return maxLen;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        // Post-order: compute results for children first
        int left = dfs(node.left);
        int right = dfs(node.right);

        int arrowLeft = 0, arrowRight = 0;

        // If left child exists and matches current node's value
        if (node.left != null && node.left.val == node.val) {
            arrowLeft = left + 1;
        }

        // If right child exists and matches current node's value
        if (node.right != null && node.right.val == node.val) {
            arrowRight = right + 1;
        }

        // Update the global maximum with the path passing through current node
        maxLen = Math.max(maxLen, arrowLeft + arrowRight);

        // Return the longest single branch starting from current node
        return Math.max(arrowLeft, arrowRight);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: [5,4,5,1,1,null,5]
        TreeNode root1 = new TreeNode(5,
                new TreeNode(4, new TreeNode(1), new TreeNode(1)),
                new TreeNode(5, null, new TreeNode(5)));
        System.out.println("Longest univalue path 1: " + sol.longestUnivaluePath(root1)); // 2

        // Example 2: [1,4,5,4,4,null,5]
        TreeNode root2 = new TreeNode(1,
                new TreeNode(4, new TreeNode(4), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(5)));
        System.out.println("Longest univalue path 2: " + sol.longestUnivaluePath(root2)); // 2
    }
}
