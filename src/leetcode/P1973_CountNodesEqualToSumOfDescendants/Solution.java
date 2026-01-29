package leetcode.P1973_CountNodesEqualToSumOfDescendants;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
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
    int count = 0;

    public int equalToDescendants(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }

    private long dfs(TreeNode node) {
        if (node == null)
            return 0;

        long leftSum = dfs(node.left);
        long rightSum = dfs(node.right);

        if (leftSum + rightSum == node.val) {
            count++;
        }

        return leftSum + rightSum + node.val;
    }
}
