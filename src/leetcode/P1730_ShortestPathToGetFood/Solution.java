package leetcode.P1730_ShortestPathToGetFood;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    queue.offer(new int[] { i, j, 0 });
                    visited[i][j] = true;
                    break;
                }
            }
        }

        int[] dirs = { 0, 1, 0, -1, 0 };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if (grid[r][c] == '#')
                return d;

            for (int k = 0; k < 4; k++) {
                int nr = r + dirs[k];
                int nc = c + dirs[k + 1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] != 'X') {
                    visited[nr][nc] = true;
                    queue.offer(new int[] { nr, nc, d + 1 });
                }
            }
        }

        return -1;
    }
}
