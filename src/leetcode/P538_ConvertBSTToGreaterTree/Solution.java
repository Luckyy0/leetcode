package leetcode.P538_ConvertBSTToGreaterTree;

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
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        traverse(root);
        return root;
    }

    // Reverse In-order Traversal: Right -> Root -> Left
    // Duyệt Trung Thứ Tự Ngược: Phải -> Gốc -> Trái
    private void traverse(TreeNode node) {
        if (node == null)
            return;

        traverse(node.right);

        sum += node.val;
        node.val = sum;

        traverse(node.left);
    }
}
