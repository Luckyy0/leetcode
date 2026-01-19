package leetcode.P112_PathSum;

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
     * Problem 112: Path Sum
     * Approach: DFS with Remaining Sum
     * 
     * Theoretical Basis:
     * - Root-to-leaf path must start at root and end at a leaf (no children)
     * - Subproblem: subtract node value from target, check subtrees
     * - Base case at leaf: check if remaining sum equals node value
     * 
     * Time Complexity: O(N) - visit each node at most once
     * Space Complexity: O(H) - recursion stack depth equals tree height
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // Subtract current node's value
        targetSum -= root.val;

        // Check if we're at a leaf
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        // Recursively check left and right subtrees
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22 -> true
        // Path: 5 -> 4 -> 11 -> 2 = 22
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4, null, new TreeNode(1));
        runTest(solution, root1, 22, true);

        // Test 2: [1,2,3], targetSum = 5 -> false
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        runTest(solution, root2, 5, false);

        // Test 3: Empty tree, targetSum = 0 -> false
        runTest(solution, null, 0, false);

        // Test 4: Single node [5], targetSum = 5 -> true
        runTest(solution, new TreeNode(5), 5, true);

        // Test 5: Single node [5], targetSum = 1 -> false
        runTest(solution, new TreeNode(5), 1, false);
    }

    private static void runTest(Solution s, TreeNode root, int targetSum, boolean expected) {
        boolean result = s.hasPathSum(root, targetSum);
        System.out.println("TargetSum: " + targetSum + " -> Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
