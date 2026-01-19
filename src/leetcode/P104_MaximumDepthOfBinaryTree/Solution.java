package leetcode.P104_MaximumDepthOfBinaryTree;

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
     * Problem 104: Maximum Depth of Binary Tree
     * Approach: Recursion (DFS)
     * 
     * Theoretical Basis:
     * - Tree depth is defined recursively:
     * - Empty tree: depth = 0
     * - Non-empty tree: depth = 1 + max(left depth, right depth)
     * - This recursive definition translates directly to code
     * 
     * Time Complexity: O(N) - visit each node once
     * Space Complexity: O(H) - recursion stack depth equals tree height
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * Alternative: BFS approach (counts levels)
     */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
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

        // Test 1: [3,9,20,null,null,15,7] -> 3
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        runTest(solution, root1, 3);

        // Test 2: [1,null,2] -> 2
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        runTest(solution, root2, 2);

        // Test 3: null -> 0
        runTest(solution, null, 0);

        // Test 4: Single node -> 1
        runTest(solution, new TreeNode(1), 1);
    }

    private static void runTest(Solution s, TreeNode root, int expected) {
        int resultDFS = s.maxDepth(root);
        int resultBFS = s.maxDepthBFS(root);
        System.out.println("DFS: " + resultDFS + ", BFS: " + resultBFS + " (Expected: " + expected + ")");

        if (resultDFS == expected && resultBFS == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
