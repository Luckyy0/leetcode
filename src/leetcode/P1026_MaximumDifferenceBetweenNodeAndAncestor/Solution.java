package leetcode.P1026_MaximumDifferenceBetweenNodeAndAncestor;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    // Returns max diff in the subtree
    private int dfs(TreeNode node, int min, int max) {
        if (node == null)
            return max - min;

        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        int left = dfs(node.left, min, max);
        int right = dfs(node.right, min, max);

        return Math.max(left, right);
    }
}
