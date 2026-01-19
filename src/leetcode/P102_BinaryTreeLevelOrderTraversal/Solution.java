package leetcode.P102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
     * Problem 102: Binary Tree Level Order Traversal
     * Approach: BFS with Queue
     * 
     * Theoretical Basis:
     * - BFS explores nodes level by level using a Queue (FIFO)
     * - By capturing queue.size() at start of each iteration, we process exactly
     * one level at a time
     * - Children of current level become the next level
     * 
     * Time Complexity: O(N) - visit each node exactly once
     * Space Complexity: O(W) - queue holds at most W nodes (max tree width)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                // Enqueue children for next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [3,9,20,null,null,15,7] -> [[3],[9,20],[15,7]]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        runTest(solution, root1, 3);

        // Test 2: [1] -> [[1]]
        runTest(solution, new TreeNode(1), 1);

        // Test 3: null -> []
        runTest(solution, null, 0);
    }

    private static void runTest(Solution s, TreeNode root, int expectedLevels) {
        List<List<Integer>> result = s.levelOrder(root);
        System.out.println("Output: " + result);
        System.out.println("Levels: " + result.size() + " (Expected: " + expectedLevels + ")");

        if (result.size() == expectedLevels) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
