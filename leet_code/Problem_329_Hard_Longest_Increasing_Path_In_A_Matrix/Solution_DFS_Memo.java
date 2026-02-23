package leet_code.Problem_329_Hard_Longest_Increasing_Path_In_A_Matrix;

public class Solution_DFS_Memo {

    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private int m, n;

    /**
     * Finds longest increasing path.
     * Uses DFS with Memoization.
     * Time: O(M*N), Space: O(M*N).
     * 
     * Tìm đường đi tăng dài nhất.
     * Sử dụng DFS với Ghi nhớ.
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int maxLen = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, cache));
            }
        }

        return maxLen;
    }

    // Returns length of longest increasing path starting at (i, j)
    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int max = 1;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                int len = 1 + dfs(matrix, x, y, cache);
                max = Math.max(max, len);
            }
        }

        cache[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        Solution_DFS_Memo solution = new Solution_DFS_Memo();

        // Test Case 1: [[9,9,4],[6,6,8],[2,1,1]] -> 4
        int[][] m1 = {
                { 9, 9, 4 },
                { 6, 6, 8 },
                { 2, 1, 1 }
        };
        System.out.println("Max Path 1: " + solution.longestIncreasingPath(m1));

        // Test Case 2: [[3,4,5],[3,2,6],[2,2,1]] -> 4
        int[][] m2 = {
                { 3, 4, 5 },
                { 3, 2, 6 },
                { 2, 2, 1 }
        };
        System.out.println("Max Path 2: " + solution.longestIncreasingPath(m2));
    }
}
