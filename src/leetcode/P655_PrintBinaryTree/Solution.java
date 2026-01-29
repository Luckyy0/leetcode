package leetcode.P655_PrintBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int rows = height + 1;
        int cols = (1 << (height + 1)) - 1;

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            String[] row = new String[cols];
            Arrays.fill(row, "");
            res.add(Arrays.asList(row));
        }

        fill(res, root, 0, 0, cols - 1);
        return res;
    }

    private void fill(List<List<String>> res, TreeNode node, int row, int left, int right) {
        if (node == null)
            return;
        int mid = (left + right) / 2;
        res.get(row).set(mid, String.valueOf(node.val));
        fill(res, node.left, row + 1, left, mid - 1);
        fill(res, node.right, row + 1, mid + 1, right);
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return -1;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
