package leetcode.P2146_KHighestRankedItemsWithinAPriceRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int low = pricing[0];
        int high = pricing[1];

        List<int[]> candidates = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        q.offer(new int[] { start[0], start[1], 0 }); // r, c, dist
        visited[start[0]][start[1]] = true;

        // Items are added in order of distance implicitly by BFS.
        // But price order requires sorting/PQ for items at same distance?
        // Wait, standard BFS guarantees distance order.
        // We can just add all reachable valid items and then sort globally.
        // Or if we want K, maybe PQ is better.
        // Sorting all is simple if distinct items are <= 10^5.

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if (grid[r][c] >= low && grid[r][c] <= high) {
                candidates.add(new int[] { dist, grid[r][c], r, c });
            }

            if (grid[r][c] == 0)
                continue; // Actually wait, 0 is wall.
            // Problem: "0 represents a wall... cannot pass through".
            // So if start is 0? "start ... is not a wall".
            // My check 'if grid ... <= high' handles validity.
            // But if it was a wall, how did I reach it?
            // Ah, I should not queue walls.
            // Check neighbors.

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] != 0) {
                    visited[nr][nc] = true;
                    q.offer(new int[] { nr, nc, dist + 1 });
                }
            }
        }

        // Check start position explicitly if it wasn't added due to wall logic? Start
        // is valid.
        // My Logic adds neighbors. Start is polled and checked. Correct.
        // But wait. "0 is wall". Start not wall.
        // Start is pushed inside Q. Condition `grid[start] >= low && ...` checked
        // immediately.
        // Neighbors pushed if `grid != 0`.
        // Correct.

        Collections.sort(candidates, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            if (a[2] != b[2])
                return Integer.compare(a[2], b[2]);
            return Integer.compare(a[3], b[3]);
        });

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.min(k, candidates.size()); i++) {
            result.add(Arrays.asList(candidates.get(i)[2], candidates.get(i)[3]));
        }
        return result;
    }
}
