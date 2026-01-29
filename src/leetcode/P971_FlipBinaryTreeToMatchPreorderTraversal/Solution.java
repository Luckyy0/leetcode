package leetcode.P971_FlipBinaryTreeToMatchPreorderTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int pos = 0;
    List<Integer> flipped = new ArrayList<>();
    int[] voyage;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        if (dfs(root)) {
            return flipped;
        } else {
            return Arrays.asList(-1);
        }
    }

    private boolean dfs(TreeNode node) {
        if (node == null)
            return true;
        if (node.val != voyage[pos++])
            return false;

        if (node.left != null && node.left.val != voyage[pos]) {
            flipped.add(node.val);
            return dfs(node.right) && dfs(node.left);
        } else {
            return dfs(node.left) && dfs(node.right);
        }
    }
}
