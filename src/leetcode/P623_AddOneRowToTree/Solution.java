package leetcode.P623_AddOneRowToTree;

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        insert(root, val, depth, 1);
        return root;
    }

    private void insert(TreeNode node, int val, int targetDepth, int currentDepth) {
        if (node == null)
            return;

        if (currentDepth == targetDepth - 1) {
            // Found parent level, insert new nodes
            // Tìm thấy cấp cha, chèn các nút mới
            TreeNode tempLeft = node.left;
            TreeNode tempRight = node.right;

            node.left = new TreeNode(val);
            node.left.left = tempLeft;

            node.right = new TreeNode(val);
            node.right.right = tempRight;
        } else {
            insert(node.left, val, targetDepth, currentDepth + 1);
            insert(node.right, val, targetDepth, currentDepth + 1);
        }
    }
}
