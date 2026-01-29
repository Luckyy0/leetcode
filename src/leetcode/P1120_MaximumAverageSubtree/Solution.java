package leetcode.P1120_MaximumAverageSubtree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    double maxAvg = 0.0;

    public double maximumAverageSubtree(TreeNode root) {
        process(root);
        return maxAvg;
    }

    private int[] process(TreeNode node) {
        if (node == null)
            return new int[] { 0, 0 };

        int[] left = process(node.left);
        int[] right = process(node.right);

        int sum = node.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];

        double avg = (double) sum / count;
        maxAvg = Math.max(maxAvg, avg);

        return new int[] { sum, count };
    }
}
