package leetcode.P1110_DeleteNodesAndReturnForest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    List<TreeNode> forest;
    Set<Integer> toDelete;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        forest = new ArrayList<>();
        toDelete = new HashSet<>();
        for (int x : to_delete)
            toDelete.add(x);

        root = process(root);

        // If root wasn't deleted, add it
        if (root != null) {
            forest.add(root);
        }

        return forest;
    }

    private TreeNode process(TreeNode node) {
        if (node == null)
            return null;

        node.left = process(node.left);
        node.right = process(node.right);

        if (toDelete.contains(node.val)) {
            if (node.left != null)
                forest.add(node.left);
            if (node.right != null)
                forest.add(node.right);
            return null; // Delete this node
        }

        return node;
    }
}
