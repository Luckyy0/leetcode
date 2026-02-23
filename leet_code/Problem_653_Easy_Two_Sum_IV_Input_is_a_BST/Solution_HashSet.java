package leet_code.Problem_653_Easy_Two_Sum_IV_Input_is_a_BST;

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

public class Solution_HashSet {

    /**
     * Finds if two nodes in a BST sum up to k.
     * Strategy: DFS with a HashSet to store visited values.
     * Time: O(N), Space: O(N).
     */
    public boolean findTarget(TreeNode root, int k) {
        return solve(root, k, new HashSet<>());
    }

    private boolean solve(TreeNode node, int k, Set<Integer> seen) {
        if (node == null)
            return false;

        // Check if the complement exists in the set
        if (seen.contains(k - node.val)) {
            return true;
        }

        // Add current value to set and recurse
        seen.add(node.val);

        return solve(node.left, k, seen) || solve(node.right, k, seen);
    }

    public static void main(String[] args) {
        Solution_HashSet sol = new Solution_HashSet();
        TreeNode root = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7)));
        System.out.println("Result (k=9): " + sol.findTarget(root, 9)); // true
        System.out.println("Result (k=28): " + sol.findTarget(root, 28)); // false
    }
}
