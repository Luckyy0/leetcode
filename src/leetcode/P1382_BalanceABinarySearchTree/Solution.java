package leetcode.P1382_BalanceABinarySearchTree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    List<Integer> sortedVals = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build(0, sortedVals.size() - 1);
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        sortedVals.add(node.val);
        inorder(node.right);
    }

    private TreeNode build(int l, int r) {
        if (l > r)
            return null;

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(sortedVals.get(mid));
        root.left = build(l, mid - 1);
        root.right = build(mid + 1, r);
        return root;
    }
}
