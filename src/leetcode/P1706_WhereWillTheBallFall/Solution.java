package leetcode.P1706_WhereWillTheBallFall;

public class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int c = i;
            for (int r = 0; r < m; r++) {
                if (grid[r][c] == 1) {
                    // Moving right
                    if (c + 1 >= n || grid[r][c + 1] == -1) {
                        c = -1;
                        break;
                    }
                    c++;
                } else {
                    // Moving left
                    if (c - 1 < 0 || grid[r][c - 1] == 1) {
                        c = -1;
                        break;
                    }
                    c--;
                }
            }
            result[i] = c;
        }

        return result;
    }
}
