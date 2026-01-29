package leetcode.P1448_CountGoodNodesInBinaryTree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null)
            return 0;

        int count = 0;
        int newMax = maxSoFar;

        if (node.val >= maxSoFar) {
            count = 1;
            newMax = node.val;
        }

        count += dfs(node.left, newMax);
        count += dfs(node.right, newMax);

        return count;
    }
}
