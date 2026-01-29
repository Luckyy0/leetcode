package leetcode.P994_RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] { i, j });
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        if (fresh == 0)
            return 0;

        int minutes = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottedAtThisMin = false;
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dirs) {
                    int ni = curr[0] + d[0], nj = curr[1] + d[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        q.add(new int[] { ni, nj });
                        fresh--;
                        rottedAtThisMin = true;
                    }
                }
            }
            if (rottedAtThisMin)
                minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
