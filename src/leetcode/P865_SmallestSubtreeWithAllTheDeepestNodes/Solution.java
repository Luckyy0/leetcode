package leetcode.P865_SmallestSubtreeWithAllTheDeepestNodes;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Result {
    int depth;
    TreeNode node;

    Result(int d, TreeNode n) {
        depth = d;
        node = n;
    }
}

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return solve(root).node;
    }

    private Result solve(TreeNode node) {
        if (node == null)
            return new Result(0, null);

        Result left = solve(node.left);
        Result right = solve(node.right);

        if (left.depth == right.depth) {
            return new Result(left.depth + 1, node);
        } else if (left.depth > right.depth) {
            return new Result(left.depth + 1, left.node);
        } else {
            return new Result(right.depth + 1, right.node);
        }
    }
}
