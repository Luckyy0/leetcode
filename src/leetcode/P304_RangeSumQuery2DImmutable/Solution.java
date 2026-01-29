package leetcode.P304_RangeSumQuery2DImmutable;

public class Solution {

    /**
     * Problem 304: Range Sum Query 2D - Immutable
     * Approach: 2D Prefix Sum
     * 
     * Time Complexity: O(1) query, O(MN) init
     * Space Complexity: O(MN)
     */
    public static class NumMatrix {

        private int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return;

            int m = matrix.length;
            int n = matrix[0].length;
            dp = new int[m + 1][n + 1];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i + 1][j + 1] = matrix[i][j]
                            + dp[i][j + 1]
                            + dp[i + 1][j]
                            - dp[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1]
                    - dp[row1][col2 + 1]
                    - dp[row2 + 1][col1]
                    + dp[row1][col1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 0, 1, 4, 2 },
                { 5, 6, 3, 2, 1 },
                { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 }
        };
        NumMatrix numMatrix = new NumMatrix(matrix);

        // sumRegion(2, 1, 4, 3) -> 8
        runTest(numMatrix, 2, 1, 4, 3, 8);

        // sumRegion(1, 1, 2, 2) -> 11
        runTest(numMatrix, 1, 1, 2, 2, 11);

        // sumRegion(1, 2, 2, 4) -> 12
        runTest(numMatrix, 1, 2, 2, 4, 12);
    }

    private static void runTest(NumMatrix nm, int r1, int c1, int r2, int c2, int expected) {
        int result = nm.sumRegion(r1, c1, r2, c2);
        System.out.println("Region [" + r1 + "," + c1 + "] to [" + r2 + "," + c2 + "] -> " + result + " (Expected: "
                + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
