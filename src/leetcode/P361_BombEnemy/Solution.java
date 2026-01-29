package leetcode.P361_BombEnemy;

public class Solution {

    /**
     * Problem 361: Bomb Enemy
     * Approach: Caching Hits (DP)
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(N)
     */
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int maxKilled = 0;
        int rowHits = 0;
        int[] colHits = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Calculate row hits if we are at start or after a wall
                // Only count for current segment
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowHits = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            rowHits++;
                        }
                    }
                }

                // Calculate col hits if we are at top or after a wall
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colHits[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            colHits[j]++;
                        }
                    }
                }

                // If cell is empty, we can place bomb
                if (grid[i][j] == '0') {
                    maxKilled = Math.max(maxKilled, rowHits + colHits[j]);
                }
            }
        }

        return maxKilled;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // ["0","E","0","0"],["E","0","W","E"],["0","E","0","0"] -> 3 (at 1,1)
        char[][] g1 = {
                { '0', 'E', '0', '0' },
                { 'E', '0', 'W', 'E' },
                { '0', 'E', '0', '0' }
        };
        runTest(solution, g1, 3);

        // ["W","W","W"],["0","0","0"],["E","E","E"] -> 1
        char[][] g2 = {
                { 'W', 'W', 'W' },
                { '0', '0', '0' },
                { 'E', 'E', 'E' }
        };
        runTest(solution, g2, 1);
    }

    private static void runTest(Solution s, char[][] grid, int expected) {
        int result = s.maxKilledEnemies(grid);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
