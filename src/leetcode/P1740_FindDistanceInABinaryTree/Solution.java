package leetcode.P1740_FindDistanceInABinaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLCA(root, p, q);
        return getDist(lca, p) + getDist(lca, q);
    }

    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q)
            return root;
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }

    // BFS or DFS to find distance
    private int getDist(TreeNode root, int target) {
        if (root == null)
            return -1;
        if (root.val == target)
            return 0;

        int left = getDist(root.left, target);
        if (left != -1)
            return left + 1;

        int right = getDist(root.right, target);
        if (right != -1)
            return right + 1;

        return -1;
    }
}
