package leetcode.P101_SymmetricTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static class TreeNode {
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

    /**
     * Problem 101: Symmetric Tree
     * Approach: Recursion (Mirror Check)
     * 
     * Theoretical Basis:
     * - A tree is symmetric if left subtree mirrors right subtree
     * - Mirror property: t1.left mirrors t2.right AND t1.right mirrors t2.left
     * - This is cross-comparison unlike Same Tree which does parallel comparison
     * 
     * Time Complexity: O(N) - visit each node once
     * Space Complexity: O(H) - recursion stack depth equals tree height
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Both null -> symmetric
        if (t1 == null && t2 == null)
            return true;

        // One null, other not -> not symmetric
        if (t1 == null || t2 == null)
            return false;

        // Values must match, and cross-compare children
        return t1.val == t2.val
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    /**
     * Iterative approach using Queue
     */
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null)
                continue;
            if (t1 == null || t2 == null)
                return false;
            if (t1.val != t2.val)
                return false;

            // Cross-enqueue: left-left with right-right, left-right with right-left
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [1,2,2,3,4,4,3] -> true
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root1.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        runTest(solution, root1, true);

        // Test 2: [1,2,2,null,3,null,3] -> false
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2, null, new TreeNode(3));
        root2.right = new TreeNode(2, null, new TreeNode(3));
        runTest(solution, root2, false);

        // Test 3: Single node -> true
        runTest(solution, new TreeNode(1), true);

        // Test 4: null -> true
        runTest(solution, null, true);
    }

    private static void runTest(Solution s, TreeNode root, boolean expected) {
        boolean resultRec = s.isSymmetric(root);
        boolean resultIter = s.isSymmetricIterative(root);
        System.out.println("Recursive: " + resultRec + ", Iterative: " + resultIter + " (Expected: " + expected + ")");

        if (resultRec == expected && resultIter == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
