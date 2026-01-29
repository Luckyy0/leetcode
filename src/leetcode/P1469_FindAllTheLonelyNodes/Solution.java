package leetcode.P1469_FindAllTheLonelyNodes;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

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
    List<Integer> res = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;

        if (node.left != null && node.right == null)
            res.add(node.left.val);
        if (node.left == null && node.right != null)
            res.add(node.right.val);

        dfs(node.left);
        dfs(node.right);
    }
}
