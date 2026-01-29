package leetcode.P1102_PathWithMaximumMinimumValue;

import java.util.PriorityQueue;

class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Max heap: [val, r, c]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[] { grid[0][0], 0, 0 });

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // This bottleneck tracking is implicit. The value in PQ is the bottleneck to
        // reach (r,c).
        // Since we also limit by grid[r][c].
        // Actually, we need to track "min so far".
        // The heap should store the bottleneck of the path to (r,c).
        // When pushing neighbor (nr, nc), the bottleneck becomes
        // min(current_bottleneck, grid[nr][nc]).

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int val = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == m - 1 && c == n - 1)
                return val;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    int nextVal = Math.min(val, grid[nr][nc]);
                    pq.add(new int[] { nextVal, nr, nc });
                }
            }
        }
        return -1;
    }
}
