package leetcode.P1022_SumOfRootToLeafBinaryNumbers;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int val) {
        if (node == null)
            return 0;

        val = (val << 1) | node.val;

        if (node.left == null && node.right == null) {
            return val;
        }

        return dfs(node.left, val) + dfs(node.right, val);
    }
}
