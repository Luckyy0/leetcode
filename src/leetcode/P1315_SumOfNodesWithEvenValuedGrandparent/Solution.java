package leetcode.P1315_SumOfNodesWithEvenValuedGrandparent;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return sum;
    }

    private void dfs(TreeNode node, TreeNode parent, TreeNode grandparent) {
        if (node == null)
            return;

        if (grandparent != null && grandparent.val % 2 == 0) {
            sum += node.val;
        }

        dfs(node.left, node, parent);
        dfs(node.right, node, parent);
    }
}
