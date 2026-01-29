package leetcode.P1368_MinimumCostToMakeAtLeastOneValidPathInAGrid;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { 0, 0 });
        dist[0][0] = 0;

        // 1: R, 2: L, 3: D, 4: U
        int[][] dirs = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int r = curr[0];
            int c = curr[1];

            if (r == m - 1 && c == n - 1)
                return dist[r][c];

            for (int k = 1; k <= 4; k++) {
                int nr = r + dirs[k][0];
                int nc = c + dirs[k][1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int weight = (grid[r][c] == k) ? 0 : 1;
                    if (dist[r][c] + weight < dist[nr][nc]) {
                        dist[nr][nc] = dist[r][c] + weight;
                        if (weight == 0) {
                            dq.offerFirst(new int[] { nr, nc });
                        } else {
                            dq.offerLast(new int[] { nr, nc });
                        }
                    }
                }
            }
        }

        return -1;
    }
}
