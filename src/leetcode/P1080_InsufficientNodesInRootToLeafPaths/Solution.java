package leetcode.P1080_InsufficientNodesInRootToLeafPaths;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return prune(root, limit, 0);
    }

    // Returns the node if sufficient, null otherwise.
    // passing sumSoFar: easier logic.
    private TreeNode prune(TreeNode node, int limit, int sumSoFar) {
        if (node == null)
            return null;

        int currentSum = sumSoFar + node.val;

        if (node.left == null && node.right == null) {
            // Leaf node check
            return currentSum < limit ? null : node;
        }

        node.left = prune(node.left, limit, currentSum);
        node.right = prune(node.right, limit, currentSum);

        // If both children are null (insufficient paths), then this node is
        // insufficient
        if (node.left == null && node.right == null) {
            return null;
        }

        return node;
    }
}
