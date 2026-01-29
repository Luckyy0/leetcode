package leetcode.P750_NumberOfCornerRectangles;

class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int common = 0;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        common++;
                    }
                }
                ans += common * (common - 1) / 2;
            }
        }

        return ans;
    }
}
