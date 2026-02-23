package leet_code.Problem_666_Medium_Path_Sum_IV;

import java.util.*;

public class Solution {

    private int totalSum = 0;
    private int[][] tree = new int[5][9];

    /**
     * Calculates the sum of all root-to-leaf paths from the packed integer
     * representation.
     * Strategy: Store in 2D array and perform DFS starting from 11.
     * Time: O(N), Space: O(1) (fixed size tree structure).
     */
    public int pathSum(int[] nums) {
        totalSum = 0;
        // Reset tree
        for (int i = 0; i < 5; i++)
            Arrays.fill(tree[i], -1);

        // Parse input
        for (int num : nums) {
            int d = num / 100;
            int p = (num % 100) / 10;
            int v = num % 10;
            tree[d][p] = v;
        }

        // Start DFS from root
        if (tree[1][1] != -1) {
            dfs(1, 1, 0);
        }

        return totalSum;
    }

    private void dfs(int d, int p, int currentSum) {
        currentSum += tree[d][p];

        int nextD = d + 1;
        int leftP = 2 * p - 1;
        int rightP = 2 * p;

        boolean isLeaf = true;

        // Check left child
        if (nextD < 5 && tree[nextD][leftP] != -1) {
            isLeaf = false;
            dfs(nextD, leftP, currentSum);
        }

        // Check right child
        if (nextD < 5 && tree[nextD][rightP] != -1) {
            isLeaf = false;
            dfs(nextD, rightP, currentSum);
        }

        // If it's a leaf, add path sum to result
        if (isLeaf) {
            totalSum += currentSum;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 113, 215, 221 };
        System.out.println("Path sum: " + sol.pathSum(nums)); // 12
    }
}
