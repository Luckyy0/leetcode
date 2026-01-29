package leetcode.P968_BinaryTreeCameras;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int ans = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0)
            ans++;
        return ans;
    }

    // returns: 0: not covered, 1: camera, 2: covered
    private int dfs(TreeNode node) {
        if (node == null)
            return 2;

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == 0 || right == 0) {
            ans++;
            return 1;
        }

        if (left == 1 || right == 1) {
            return 2;
        }

        return 0;
    }
}
