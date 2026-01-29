package leetcode.P889_ConstructBinaryTreeFromPreorderAndPostorderTraversal;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if (n == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        if (n == 1)
            return root;

        // Find split point
        int L = 0;
        for (int i = 0; i < n; i++) {
            if (postorder[i] == preorder[1]) {
                L = i + 1;
                break;
            }
        }

        root.left = constructFromPrePost(
                Arrays.copyOfRange(preorder, 1, L + 1),
                Arrays.copyOfRange(postorder, 0, L));
        root.right = constructFromPrePost(
                Arrays.copyOfRange(preorder, L + 1, n),
                Arrays.copyOfRange(postorder, L, n - 1));

        return root;
    }
}
