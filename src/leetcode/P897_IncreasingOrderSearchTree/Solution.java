package leetcode.P897_IncreasingOrderSearchTree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        curr = dummy;
        inorder(root);
        return dummy.right;
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);

        node.left = null;
        curr.right = node;
        curr = node;

        inorder(node.right);
    }
}
