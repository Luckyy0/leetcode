package leetcode.P103_BinaryTreeZigzagLevelOrderTraversal;

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
     * Problem 103: Binary Tree Zigzag Level Order Traversal
     * Approach: BFS with Direction Toggle
     * 
     * Theoretical Basis:
     * - Standard BFS collects nodes level by level
     * - For zigzag, we alternate direction: left-to-right on even levels,
     * right-to-left on odd
     * - Using LinkedList.addFirst() for odd levels builds the list in reverse order
     * efficiently
     * 
     * Time Complexity: O(N) - visit each node once
     * Space Complexity: O(W) - queue holds at most max tree width nodes
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Add based on direction
                if (leftToRight) {
                    currentLevel.add(node.val);
                } else {
                    currentLevel.addFirst(node.val);
                }

                // Always enqueue children left to right
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(currentLevel);
            leftToRight = !leftToRight; // Toggle direction
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [3,9,20,null,null,15,7] -> [[3],[20,9],[15,7]]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        runTest(solution, root1);

        // Test 2: [1] -> [[1]]
        runTest(solution, new TreeNode(1));

        // Test 3: null -> []
        runTest(solution, null);
    }

    private static void runTest(Solution s, TreeNode root) {
        List<List<Integer>> result = s.zigzagLevelOrder(root);
        System.out.println("Output: " + result);
        System.out.println("-----------------");
    }
}
