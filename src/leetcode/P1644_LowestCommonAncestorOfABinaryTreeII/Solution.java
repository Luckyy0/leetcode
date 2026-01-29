package leetcode.P1644_LowestCommonAncestorOfABinaryTreeII;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    private TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
        dfs(root, p, q);
        return lca;
    }

    // Returns true if subtree contains p or q
    // Wait, simpler to return count or just track state
    // Let's rely on side effect: first time we see (foundP && foundQ) in a subtree
    // root where children alone didn't have both.

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return false;

        // We must visit children first to ensure we count all
        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);

        boolean mid = (node == p || node == q);

        // If current node completes the pair
        if (mid && (left || right)) {
            lca = node;
        } else if (left && right) {
            lca = node;
        }

        // Return true if any part of pair is found
        return mid || left || right;
    }
}
