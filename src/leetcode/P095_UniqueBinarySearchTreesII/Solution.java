package leetcode.P095_UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

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

        // Helper for print
        public String toString() {
            return String.valueOf(val);
        }
    }

    /**
     * Problem 95: Unique Binary Search Trees II
     * Approach: Recursion
     * Time Complexity: Catalan Number
     * Space Complexity: O(N) recursion depth + Result Size
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();

        // Base case: empty tree
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // Recursive step
        for (int i = start; i <= end; i++) {
            // Generate all left subtrees
            List<TreeNode> leftTrees = generate(start, i - 1);

            // Generate all right subtrees
            List<TreeNode> rightTrees = generate(i + 1, end);

            // Combine
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }

        return allTrees;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 3, 5);
        runTest(solution, 1, 1);
    }

    private static void runTest(Solution s, int n, int expectedCount) {
        System.out.println("Input: n=" + n);
        List<TreeNode> result = s.generateTrees(n);
        System.out.println("Output count: " + result.size() + " (Expected: " + expectedCount + ")");

        if (result.size() == expectedCount) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
