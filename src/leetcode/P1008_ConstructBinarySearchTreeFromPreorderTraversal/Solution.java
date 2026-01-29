package leetcode.P1008_ConstructBinarySearchTreeFromPreorderTraversal;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int bound) {
        if (idx == preorder.length || preorder[idx] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = helper(preorder, root.val);
        root.right = helper(preorder, bound);
        return root;
    }
}
