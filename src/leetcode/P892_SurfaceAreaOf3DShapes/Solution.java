package leetcode.P892_SurfaceAreaOf3DShapes;

class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int h = grid[r][c];
                if (h > 0) {
                    area += 2 + 4 * h;
                    if (r > 0)
                        area -= 2 * Math.min(h, grid[r - 1][c]);
                    if (c > 0)
                        area -= 2 * Math.min(h, grid[r][c - 1]);
                }
            }
        }

        return area;
    }
}
