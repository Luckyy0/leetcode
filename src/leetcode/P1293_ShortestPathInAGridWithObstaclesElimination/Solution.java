package leetcode.P1293_ShortestPathInAGridWithObstaclesElimination;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if (k >= m + n - 2)
            return m + n - 2; // Manhattan dist optimization

        int[][] visited = new int[m][n]; // Stores max k remaining
        for (int[] row : visited)
            Arrays.fill(row, -1);

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0, k, 0 }); // r, c, k, dist
        visited[0][0] = k;

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], rem = curr[2], dist = curr[3];

            if (r == m - 1 && c == n - 1)
                return dist;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newRem = rem - grid[nr][nc];

                    if (newRem >= 0 && newRem > visited[nr][nc]) {
                        visited[nr][nc] = newRem;
                        q.offer(new int[] { nr, nc, newRem, dist + 1 });
                    }
                }
            }
        }

        return -1;
    }
}
