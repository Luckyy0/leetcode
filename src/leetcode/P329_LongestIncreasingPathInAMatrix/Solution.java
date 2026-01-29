package leetcode.P329_LongestIncreasingPathInAMatrix;

public class Solution {

    /**
     * Problem 329: Longest Increasing Path in a Matrix
     * Approach: DFS + Memoization
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */

    private int[][] memo;
    private int[][] matrix;
    private int m;
    private int n;
    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        memo = new int[m][n];

        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(i, j));
            }
        }

        return maxLen;
    }

    private int dfs(int r, int c) {
        if (memo[r][c] != 0)
            return memo[r][c];

        int max = 1;
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[r][c]) {
                max = Math.max(max, 1 + dfs(nr, nc));
            }
        }

        memo[r][c] = max;
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[9,9,4],[6,6,8],[2,1,1]] -> 4 (1-2-6-9)
        int[][] m1 = {
                { 9, 9, 4 },
                { 6, 6, 8 },
                { 2, 1, 1 }
        };
        runTest(solution, m1, 4);

        // [[3,4,5],[3,2,6],[2,2,1]] -> 4 (3-4-5-6)
        int[][] m2 = {
                { 3, 4, 5 },
                { 3, 2, 6 },
                { 2, 2, 1 }
        };
        runTest(solution, m2, 4);
    }

    private static void runTest(Solution s, int[][] mat, int expected) {
        // Reset state by creating new instance for clean testing
        s = new Solution();
        int result = s.longestIncreasingPath(mat);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
