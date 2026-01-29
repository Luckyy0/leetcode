package leetcode.P1038_BinarySearchTreeToGreaterSumTree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;

        dfs(node.right);
        sum += node.val;
        node.val = sum;
        dfs(node.left);
    }
}
