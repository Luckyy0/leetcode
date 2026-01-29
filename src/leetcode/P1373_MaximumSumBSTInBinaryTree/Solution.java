package leetcode.P1373_MaximumSumBSTInBinaryTree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return maxSum;
    }

    // int[]: {isBST (1/0), min, max, sum}
    // Use Integer.MAX_VALUE and MIN_VALUE carefully
    private int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[] { 1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }

        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        if (left[0] == 1 && right[0] == 1 &&
                node.val > left[2] && node.val < right[1]) {

            int sum = node.val + left[3] + right[3];
            maxSum = Math.max(maxSum, sum);

            int mn = Math.min(node.val, left[1]);
            int mx = Math.max(node.val, right[2]);

            return new int[] { 1, mn, mx, sum };
        } else {
            return new int[] { 0, 0, 0, 0 };
        }
    }
}
