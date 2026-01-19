package leetcode.P221_MaximalSquare;

public class Solution {

    /**
     * Problem 221: Maximal Square
     * Approach: Dynamic Programming
     * 
     * Theoretical Basis:
     * - dp[i][j] = len of square ending at i,j.
     * - dp[i][j] = min(top, left, top-left) + 1 if matrix[i][j] == '1'.
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = 0;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        char[][] m1 = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        System.out.println("Test 1: " + solution.maximalSquare(m1)); // 4

        // Example 2
        char[][] m2 = { { '0', '1' }, { '1', '0' } };
        System.out.println("Test 2: " + solution.maximalSquare(m2)); // 1

        // Example 3
        char[][] m3 = { { '0' } };
        System.out.println("Test 3: " + solution.maximalSquare(m3)); // 0
    }
}
