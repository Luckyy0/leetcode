package leetcode.P671_SecondMinimumNodeInABinaryTree;

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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null)
            return -1;

        int left = root.left.val;
        int right = root.right.val;

        // If child equals root, search deeper for a different value
        // Nếu con bằng gốc, hãy tìm sâu hơn để có giá trị khác
        if (left == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (right == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        // If both subtrees have a candidate
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }

        // Return the one that is not -1
        return left != -1 ? left : right;
    }
}
