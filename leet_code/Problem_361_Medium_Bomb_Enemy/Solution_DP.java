package leet_code.Problem_361_Medium_Bomb_Enemy;

public class Solution_DP {

    /**
     * Finds maximum enemies killed with one bomb.
     * Uses row and column segment caching.
     * Time: O(M*N), Space: O(N).
     * 
     * Tìm số kẻ địch tối đa bị tiêu diệt bằng một quả bom.
     * Sử dụng kỹ thuật lưu trữ phân đoạn hàng và cột.
     */
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int maxEnemies = 0;
        int rowCnt = 0;
        int[] colCnt = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 1. Calculate row enemies if at start of a row or after a wall
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCnt = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E')
                            rowCnt++;
                    }
                }

                // 2. Calculate column enemies if at top of a column or after a wall
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colCnt[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E')
                            colCnt[j]++;
                    }
                }

                // 3. If current spot is empty, update maxEnemies
                if (grid[i][j] == '0') {
                    maxEnemies = Math.max(maxEnemies, rowCnt + colCnt[j]);
                }
            }
        }

        return maxEnemies;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1
        char[][] grid1 = {
                { '0', 'E', '0', '0' },
                { 'E', '0', 'W', 'E' },
                { '0', 'E', '0', '0' }
        };
        System.out.println("Result 1: " + solution.maxKilledEnemies(grid1)); // 3
    }
}
