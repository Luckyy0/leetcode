package leetcode.P1214_TwoSumBSTs;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        dfs(root1, set);
        return check(root2, set, target);
    }

    private void dfs(TreeNode node, Set<Integer> set) {
        if (node == null)
            return;
        set.add(node.val);
        dfs(node.left, set);
        dfs(node.right, set);
    }

    private boolean check(TreeNode node, Set<Integer> set, int target) {
        if (node == null)
            return false;
        if (set.contains(target - node.val))
            return true;
        return check(node.left, set, target) || check(node.right, set, target);
    }
}
