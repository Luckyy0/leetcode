package leetcode.P1676_LowestCommonAncestorOfABinaryTreeIV;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> targetNodes = new HashSet<>();
        for (TreeNode node : nodes) {
            targetNodes.add(node);
        }
        return dfs(root, targetNodes);
    }

    private TreeNode dfs(TreeNode root, Set<TreeNode> targets) {
        if (root == null)
            return null;
        if (targets.contains(root))
            return root;

        TreeNode left = dfs(root.left, targets);
        TreeNode right = dfs(root.right, targets);

        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        return right;
    }
}
