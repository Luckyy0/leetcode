package leet_code.Problem_437_Medium_Path_Sum_III;

import java.util.*;

class TreeNode {
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

public class Solution_PrefixSum {

    /**
     * Counts the number of downward paths with sum equal to target.
     * Strategy: Use Prefix Sum Map during DFS.
     * Time: O(N), Space: O(H).
     */
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        // Base case: a prefix sum of 0 exists by default (representing an empty path)
        prefixSumMap.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> map) {
        if (node == null)
            return 0;

        currSum += node.val;

        // Number of paths ending here that sum to target
        int res = map.getOrDefault(currSum - target, 0);

        // Update map for children
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // recurse
        res += dfs(node.left, currSum, target, map);
        res += dfs(node.right, currSum, target, map);

        // backtrack: remove current sum from map
        map.put(currSum, map.get(currSum) - 1);

        return res;
    }

    public static void main(String[] args) {
        Solution_PrefixSum solution = new Solution_PrefixSum();

        // root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
                new TreeNode(2, null, new TreeNode(1)));
        root.right = new TreeNode(-3, null, new TreeNode(11));

        System.out.println("Result: " + solution.pathSum(root, 8)); // 3
    }
}
