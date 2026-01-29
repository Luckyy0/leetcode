package leetcode.P663_EqualTreePartition;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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
    Set<Integer> sums = new HashSet<>();

    public boolean checkEqualTree(TreeNode root) {
        if (root == null)
            return false;

        // Calculate total sum of the tree
        // Tính tổng cây của cây nhị phân
        int totalSum = getSubtreeSum(root.left) + getSubtreeSum(root.right) + root.val;

        // Check if half of totalSum exists in the recorded subtree sums
        // Kiểm tra xem một nửa totalSum có tồn tại trong các tổng cây con đã ghi lại
        // không
        if (totalSum % 2 != 0)
            return false;
        return sums.contains(totalSum / 2);
    }

    private int getSubtreeSum(TreeNode node) {
        if (node == null)
            return 0;
        int sum = node.val + getSubtreeSum(node.left) + getSubtreeSum(node.right);
        sums.add(sum);
        return sum;
    }
}
