package leetcode.P437_PathSumIII;

import java.util.HashMap;
import java.util.Map;

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
     * Problem 437: Path Sum III
     * Approach: Prefix Sum with DFS Backtracking
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H) or O(N) in worst case
     */
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1); // Base case: one path with sum 0 (empty path)
        return dfs(root, 0L, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumMap) {
        if (node == null)
            return 0;

        currentSum += node.val;

        // Count paths ending at current node
        int paths = prefixSumMap.getOrDefault(currentSum - targetSum, 0);

        // Update prefix sum map for children
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        paths += dfs(node.left, currentSum, targetSum, prefixSumMap);
        paths += dfs(node.right, currentSum, targetSum, prefixSumMap);

        // Backtrack: remove current sum from map as we go up
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return paths;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8 -> 3
        TreeNode root1 = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
        runTest(sol, root1, 8, 3);

        // root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22 -> 3
        // Simplified structure for testing
        TreeNode root2 = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        runTest(sol, root2, 22, 3);
    }

    private static void runTest(Solution sol, TreeNode root, int target, int expected) {
        int result = sol.pathSum(root, target);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
