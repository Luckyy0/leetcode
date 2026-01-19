package leetcode.P129_SumRootToLeafNumbers;

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
     * Problem 129: Sum Root to Leaf Numbers
     * Approach: DFS with number accumulation
     * 
     * Theoretical Basis:
     * - As we go down the tree, current number = current * 10 + node.val
     * - When reaching a leaf, return the accumulated number
     * - Total sum is the sum of results from all root-to-leaf paths
     * 
     * Time Complexity: O(N) - visit each node once
     * Space Complexity: O(H) - recursion stack depth
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        // Build the number digit by digit
        currentSum = currentSum * 10 + node.val;

        // If it's a leaf, return the built number
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Sum from left and right children
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [1,2,3] -> 12 + 13 = 25
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        runTest(solution, root1, 25);

        // Test 2: [4,9,0,5,1] -> 495 + 491 + 40 = 1026
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(9, new TreeNode(5), new TreeNode(1));
        root2.right = new TreeNode(0);
        runTest(solution, root2, 1026);

        // Test 3: [1] -> 1
        runTest(solution, new TreeNode(1), 1);
    }

    private static void runTest(Solution s, TreeNode root, int expected) {
        int result = s.sumNumbers(root);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
