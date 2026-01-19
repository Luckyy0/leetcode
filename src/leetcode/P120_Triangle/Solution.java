package leetcode.P120_Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 120: Triangle
     * Approach: Bottom-Up DP with O(n) Space
     * 
     * Theoretical Basis:
     * - Classic DP on DAG: each cell can reach two cells below
     * - Bottom-up approach: start from second-to-last row, work up
     * - dp[i] = min path sum from position i to any bottom cell
     * - Formula: dp[i] = triangle[row][i] + min(dp[i], dp[i+1])
     * - Final answer naturally accumulates at dp[0]
     * 
     * Time Complexity: O(n²) where n = number of rows
     * Space Complexity: O(n) for dp array
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Start with copy of bottom row
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Process from second-to-last row upward
        for (int row = n - 2; row >= 0; row--) {
            for (int i = 0; i <= row; i++) {
                // Current cell value + min of two choices below
                dp[i] = triangle.get(row).get(i) + Math.min(dp[i], dp[i + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [[2],[3,4],[6,5,7],[4,1,8,3]] -> 11
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3, 4));
        triangle1.add(Arrays.asList(6, 5, 7));
        triangle1.add(Arrays.asList(4, 1, 8, 3));
        runTest(solution, triangle1, 11);

        // Test 2: [[-10]] -> -10
        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(Arrays.asList(-10));
        runTest(solution, triangle2, -10);

        // Test 3: [[1],[2,3]] -> 3
        List<List<Integer>> triangle3 = new ArrayList<>();
        triangle3.add(Arrays.asList(1));
        triangle3.add(Arrays.asList(2, 3));
        runTest(solution, triangle3, 3);
    }

    private static void runTest(Solution s, List<List<Integer>> triangle, int expected) {
        int result = s.minimumTotal(triangle);
        System.out.println("Triangle size: " + triangle.size());
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
