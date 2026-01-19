package leetcode.P111_MinimumDepthOfBinaryTree;

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
     * Problem 111: Minimum Depth of Binary Tree
     * Approach 1: DFS (Recursion)
     * 
     * Theoretical Basis:
     * - Minimum depth = shortest path from root to LEAF
     * - Critical: must handle case where one child is null (that's not a leaf!)
     * - If left is null, must go right; if right is null, must go left
     * 
     * Time Complexity: O(N) - visit each node
     * Space Complexity: O(H) - recursion stack
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If left is null, only right path leads to a leaf
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // If right is null, only left path leads to a leaf
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // Both children exist, take minimum
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * Approach 2: BFS (often more efficient for this problem)
     * 
     * Key Insight: BFS finds first leaf encountered = minimum depth
     * Can terminate early when leaf is found
     */
    public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Found a leaf - this is the minimum depth!
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [3,9,20,null,null,15,7] -> 2
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        runTest(solution, root1, 2);

        // Test 2: [2,null,3,null,4,null,5,null,6] -> 5 (skewed)
        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(6);
        runTest(solution, root2, 5);

        // Test 3: null -> 0
        runTest(solution, null, 0);

        // Test 4: Single node -> 1
        runTest(solution, new TreeNode(1), 1);
    }

    private static void runTest(Solution s, TreeNode root, int expected) {
        int resultDFS = s.minDepth(root);
        int resultBFS = s.minDepthBFS(root);
        System.out.println("DFS: " + resultDFS + ", BFS: " + resultBFS + " (Expected: " + expected + ")");

        if (resultDFS == expected && resultBFS == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
