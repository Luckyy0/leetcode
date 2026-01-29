package leetcode.P1457_PseudoPalindromicPathsInABinaryTree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int count = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, 0);
        return count;
    }

    private void dfs(TreeNode node, int mask) {
        if (node == null)
            return;

        mask ^= (1 << node.val);

        if (node.left == null && node.right == null) {
            // Check if mask has at most 1 bit set
            if ((mask & (mask - 1)) == 0) {
                count++;
            }
            return;
        }

        dfs(node.left, mask);
        dfs(node.right, mask);
    }
}
