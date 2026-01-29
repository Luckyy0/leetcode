package leetcode.P2132_StampingTheGrid;

public class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length;
        int n = grid[0].length;

        // 1. Prefix Sum of Grid to check occupied cells
        int[][] pref = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pref[i + 1][j + 1] = pref[i][j + 1] + pref[i + 1][j] - pref[i][j] + grid[i][j];
            }
        }

        // 2. Identify valid stamp positions and mark them using Difference Array
        int[][] diff = new int[m + 2][n + 2];

        for (int i = 0; i <= m - stampHeight; i++) {
            for (int j = 0; j <= n - stampWidth; j++) {
                // Check region [i, i+h-1] x [j, j+w-1]
                int r2 = i + stampHeight;
                int c2 = j + stampWidth;
                int r1 = i;
                int c1 = j;
                // Sum query
                int sum = pref[r2][c2] - pref[r1][c2] - pref[r2][c1] + pref[r1][c1];

                if (sum == 0) {
                    // Valid stamp position. Mark region covered.
                    diff[r1 + 1][c1 + 1]++;
                    diff[r2 + 1][c1 + 1]--;
                    diff[r1 + 1][c2 + 1]--;
                    diff[r2 + 1][c2 + 1]++;
                }
            }
        }

        // 3. Compute coverage
        int[][] coverage = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                coverage[i + 1][j + 1] = coverage[i][j + 1] + coverage[i + 1][j] - coverage[i][j] + diff[i + 1][j + 1];
            }
        }

        // 4. Verify
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (coverage[i + 1][j + 1] == 0)
                        return false;
                }
            }
        }

        return true;
    }
}
