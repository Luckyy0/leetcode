package leetcode.P1530_NumberOfGoodLeafNodesPairs;

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
    int count = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return count;
    }

    private List<Integer> dfs(TreeNode node, int distLimit) {
        List<Integer> dists = new ArrayList<>();
        if (node == null)
            return dists;

        if (node.left == null && node.right == null) {
            dists.add(1);
            return dists;
        }

        List<Integer> left = dfs(node.left, distLimit);
        List<Integer> right = dfs(node.right, distLimit);

        for (int l : left) {
            for (int r : right) {
                if (l + r <= distLimit) {
                    count++;
                }
            }
        }

        for (int l : left) {
            if (l + 1 < distLimit)
                dists.add(l + 1);
        }
        for (int r : right) {
            if (r + 1 < distLimit)
                dists.add(r + 1);
        }

        return dists;
    }
}
