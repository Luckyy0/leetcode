package leetcode.P1372_LongestZigZagPathInABinaryTree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int maxPath = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return maxPath;
    }

    // Returns [leftPathLen, rightPathLen]
    // leftPathLen: max length path going left from this node
    // rightPathLen: max length path going right from this node
    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[] { -1, -1 };

        int[] leftRes = dfs(node.left);
        int[] rightRes = dfs(node.right);

        // If we go left from here, we continue the path that went RIGHT from left child
        int leftLen = 1 + leftRes[1];

        // If we go right from here, we continue the path that went LEFT from right
        // child
        int rightLen = 1 + rightRes[0];

        maxPath = Math.max(maxPath, Math.max(leftLen, rightLen));

        return new int[] { leftLen, rightLen };
    }
}
