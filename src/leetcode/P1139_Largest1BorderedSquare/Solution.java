package leetcode.P1139_Largest1BorderedSquare;

class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] hor = new int[m][n];
        int[][] ver = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    hor[i][j] = (j == 0) ? 1 : hor[i][j - 1] + 1;
                    ver[i][j] = (i == 0) ? 1 : ver[i - 1][j] + 1;
                }
            }
        }

        int maxSide = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int maxPotential = Math.min(hor[i][j], ver[i][j]);
                for (int s = maxPotential; s > maxSide; s--) {
                    // Check top edge and left edge
                    // Top edge of square size s ending at (i, j): hor[i - s + 1][j]
                    // Left edge of square size s ending at (i, j): ver[i][j - s + 1]
                    // We need these lengths to be >= s.
                    if (hor[i - s + 1][j] >= s && ver[i][j - s + 1] >= s) {
                        maxSide = s;
                        break; // Found largest for this corner
                    }
                }
            }
        }

        return maxSide * maxSide;
    }
}
