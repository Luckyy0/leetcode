package leetcode.P872_LeafSimilarTrees;

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void getLeaves(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        getLeaves(node.left, list);
        getLeaves(node.right, list);
    }
}
