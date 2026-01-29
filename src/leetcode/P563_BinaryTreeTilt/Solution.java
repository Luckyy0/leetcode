package leetcode.P563_BinaryTreeTilt;

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
    int totalTilt = 0;

    public int findTilt(TreeNode root) {
        totalTilt = 0;
        sum(root);
        return totalTilt;
    }

    private int sum(TreeNode node) {
        if (node == null)
            return 0;

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        // Add tilt of current node to total
        // Thêm độ nghiêng của nút hiện tại vào tổng
        totalTilt += Math.abs(leftSum - rightSum);

        // Return sum of subtree
        // Trả về tổng của cây con
        return leftSum + rightSum + node.val;
    }
}
