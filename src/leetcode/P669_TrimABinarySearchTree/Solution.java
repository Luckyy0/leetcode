package leetcode.P669_TrimABinarySearchTree;

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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        // If current value is too small, the trimmed version must be in the right
        // subtree
        // Nếu giá trị hiện tại quá nhỏ, phiên bản đã cắt tỉa phải nằm trong cây con bên
        // phải
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        // If current value is too large, the trimmed version must be in the left
        // subtree
        // Nếu giá trị hiện tại quá lớn, phiên bản đã cắt tỉa phải nằm trong cây con bên
        // trái
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // If value is within range, trim left and right subtrees
        // Nếu giá trị nằm trong phạm vi, hãy cắt tỉa cây con bên trái và bên phải
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
