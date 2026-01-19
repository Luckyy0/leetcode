package leetcode.P107_BinaryTreeLevelOrderTraversalII;

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
     * Problem 107: Binary Tree Level Order Traversal II
     * Approach: BFS with Insert at Front
     * 
     * Theoretical Basis:
     * - This is Problem 102 with reversed output (bottom-up instead of top-down)
     * - Standard BFS collects levels from root to leaves
     * - Using LinkedList.addFirst() inserts each level at the front
     * - Result: levels appear in reverse order (leaves to root)
     * 
     * Time Complexity: O(N) - each node visited once
     * Space Complexity: O(W) - queue holds at most max tree width nodes
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Insert at front for bottom-up order
            result.addFirst(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [3,9,20,null,null,15,7] -> [[15,7],[9,20],[3]]
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
        List<List<Integer>> result = s.levelOrderBottom(root);
        System.out.println("Output: " + result);
        System.out.println("-----------------");
    }
}
