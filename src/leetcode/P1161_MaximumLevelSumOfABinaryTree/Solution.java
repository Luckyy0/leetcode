package leetcode.P1161_MaximumLevelSumOfABinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            int currentSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                currentSum += node.val;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLevel = level;
            }
            level++;
        }

        return maxLevel;
    }
}
