package leetcode.P1631_PathWithMinimumEffort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        int[][] minEffort = new int[m][n];
        for (int[] row : minEffort)
            Arrays.fill(row, Integer.MAX_VALUE);

        minEffort[0][0] = 0;

        // PQ stores {effort, r, c}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == m - 1 && c == n - 1)
                return effort;

            // If already found a better path, skip
            if (effort > minEffort[r][c])
                continue;

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                    int newEffort = Math.max(effort, diff);

                    if (newEffort < minEffort[nr][nc]) {
                        minEffort[nr][nc] = newEffort;
                        pq.offer(new int[] { newEffort, nr, nc });
                    }
                }
            }
        }

        return 0; // Should not reach
    }
}
