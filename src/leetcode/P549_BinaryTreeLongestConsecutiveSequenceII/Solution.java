package leetcode.P549_BinaryTreeLongestConsecutiveSequenceII;

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

class Solution {
    int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return maxLen;
    }

    // Returns int[]{increasingLen, decreasingLen} starting at node
    // Trả về int[]{increasingLen, decreasingLen} bắt đầu tại nút
    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[] { 0, 0 };

        int incr = 1, decr = 1;

        if (node.left != null) {
            int[] left = dfs(node.left);
            if (node.val == node.left.val + 1) {
                incr = Math.max(incr, left[0] + 1);
            }
            if (node.val == node.left.val - 1) {
                decr = Math.max(decr, left[1] + 1);
            }
        }

        if (node.right != null) {
            int[] right = dfs(node.right);
            if (node.val == node.right.val + 1) {
                incr = Math.max(incr, right[0] + 1);
            }
            if (node.val == node.right.val - 1) {
                decr = Math.max(decr, right[1] + 1);
            }
        }

        // Update global max length
        // Cập nhật độ dài tối đa toàn cục
        maxLen = Math.max(maxLen, incr + decr - 1);

        return new int[] { incr, decr };
    }
}
