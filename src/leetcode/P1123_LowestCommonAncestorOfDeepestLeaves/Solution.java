package leetcode.P1123_LowestCommonAncestorOfDeepestLeaves;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    class Result {
        TreeNode node;
        int depth;

        Result(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode node) {
        if (node == null)
            return new Result(null, 0);

        Result l = dfs(node.left);
        Result r = dfs(node.right);

        if (l.depth == r.depth) {
            return new Result(node, l.depth + 1);
        } else if (l.depth > r.depth) {
            return new Result(l.node, l.depth + 1);
        } else {
            return new Result(r.node, r.depth + 1);
        }
    }
}
