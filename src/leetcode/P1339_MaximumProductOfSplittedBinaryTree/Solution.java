package leetcode.P1339_MaximumProductOfSplittedBinaryTree;

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
    long totalSum = 0;
    long maxProd = 0;
    List<Long> sums = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        // First pass: just sums, or do it in one logic if we store sums
        getTotalSum(root);
        totalSum = sums.get(sums.size() - 1); // Last element added is sum of root

        for (long s : sums) {
            maxProd = Math.max(maxProd, s * (totalSum - s));
        }

        return (int) (maxProd % 1_000_000_007);
    }

    private long getTotalSum(TreeNode node) {
        if (node == null)
            return 0;
        long s = node.val + getTotalSum(node.left) + getTotalSum(node.right);
        sums.add(s);
        return s;
    }
}
