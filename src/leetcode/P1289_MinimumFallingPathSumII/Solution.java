package leetcode.P1289_MinimumFallingPathSumII;

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 1)
            return grid[0][0];

        // Prev row mins
        int min1 = 0, min2 = 0, idx1 = -1;

        // Initial "previous" state (row -1) essentially 0s
        // But for first row, just calculate directly or treat prev as 0.
        // Let's iterate from row 0 properly.
        // Actually, logic: prev row min1/min2/idx1 represents accumulated sums.
        // Before row 0, accumulated sums are 0 for all cols?
        // min1=0, min2=0, idx1=-1 works.

        for (int i = 0; i < n; i++) {
            int curMin1 = Integer.MAX_VALUE;
            int curMin2 = Integer.MAX_VALUE;
            int curIdx1 = -1;

            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                if (j != idx1) {
                    val += min1;
                } else {
                    val += min2;
                }

                if (val < curMin1) {
                    curMin2 = curMin1;
                    curMin1 = val;
                    curIdx1 = j;
                } else if (val < curMin2) {
                    curMin2 = val;
                }
            }

            min1 = curMin1;
            min2 = curMin2;
            idx1 = curIdx1;
        }

        return min1;
    }
}
