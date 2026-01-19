package leetcode.P124_BinaryTreeMaximumPathSum;

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

    private int maxSum;

    /**
     * Problem 124: Binary Tree Maximum Path Sum
     * Approach: DFS with Global Max Tracking
     * 
     * Theoretical Basis:
     * - Path can go through any nodes (not necessarily through root)
     * - For each node, compute two things:
     * 1. Max path THROUGH node (arch shape): node + leftGain + rightGain
     * 2. Max path ENDING at node (for parent): node + max(leftGain, rightGain)
     * - Use max(0, gain) to ignore negative contributions
     * - Track global maximum across all "arch" paths
     * 
     * Time Complexity: O(N) - visit each node once
     * Space Complexity: O(H) - recursion stack
     */
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Get max gain from left and right subtrees
        // If negative, we don't include that subtree (use 0 instead)
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));

        // Path through this node (potential global max)
        // This forms an "arch" shape: left -> node -> right
        int pathThroughNode = node.val + leftGain + rightGain;

        // Update global max
        maxSum = Math.max(maxSum, pathThroughNode);

        // Return max gain extendable to parent (can only go ONE direction)
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [1,2,3] -> 6
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        runTest(solution, root1, 6);

        // Test 2: [-10,9,20,null,null,15,7] -> 42
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        runTest(solution, root2, 42);

        // Test 3: Single node [-3] -> -3
        runTest(solution, new TreeNode(-3), -3);

        // Test 4: [2,-1] -> 2
        runTest(solution, new TreeNode(2, new TreeNode(-1), null), 2);
    }

    private static void runTest(Solution s, TreeNode root, int expected) {
        int result = s.maxPathSum(root);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
