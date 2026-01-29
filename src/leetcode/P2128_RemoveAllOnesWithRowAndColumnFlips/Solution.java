package leetcode.P2128_RemoveAllOnesWithRowAndColumnFlips;

public class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] row0 = grid[0];

        for (int i = 1; i < m; i++) {
            boolean same = true;
            boolean inverse = true;

            for (int j = 0; j < n; j++) {
                if (grid[i][j] != row0[j])
                    same = false;
                if (grid[i][j] == row0[j])
                    inverse = false;
            }

            if (!same && !inverse)
                return false;
        }

        return true;
    }
}
