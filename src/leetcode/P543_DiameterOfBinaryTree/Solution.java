package leetcode.P543_DiameterOfBinaryTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
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

class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        depth(root);
        return maxDiameter;
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;

        int L = depth(node.left);
        int R = depth(node.right);

        // Update max diameter: path through current node
        // Cập nhật đường kính tối đa: đường đi qua nút hiện tại
        maxDiameter = Math.max(maxDiameter, L + R);

        // Return height of current node
        // Trả về chiều cao của nút hiện tại
        return Math.max(L, R) + 1;
    }
}
