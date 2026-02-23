package leet_code.Problem_663_Medium_Equal_Tree_Partition;

import java.util.*;

/**
 * Definition for a binary tree node.
 */
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

public class Solution {

    /**
     * Determines if a tree can be partitioned into two equal sum trees by removing
     * one edge.
     * Strategy: Calculate all subtree sums and check if TotalSum/2 exists
     * (excluding total root).
     * Time: O(N), Space: O(N).
     */
    public boolean checkEqualTree(TreeNode root) {
        Stack<Integer> subtreeSums = new Stack<>();
        int totalSum = computeSubtreeSum(root, subtreeSums);

        // After calculation, the top of the stack is the totalSum of the root.
        // We must remove it to ensure we don't partition the whole tree from nothing.
        subtreeSums.pop();

        if (totalSum % 2 != 0)
            return false;

        int target = totalSum / 2;
        for (int sum : subtreeSums) {
            if (sum == target)
                return true;
        }

        return false;
    }

    /**
     * Post-order traversal to compute sums of all subtrees.
     */
    private int computeSubtreeSum(TreeNode node, Stack<Integer> sums) {
        if (node == null)
            return 0;

        int total = node.val + computeSubtreeSum(node.left, sums) + computeSubtreeSum(node.right, sums);
        sums.push(total);
        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(5,
                new TreeNode(10),
                new TreeNode(10, new TreeNode(2), new TreeNode(3)));
        System.out.println("Can partition: " + sol.checkEqualTree(root)); // true
    }
}
