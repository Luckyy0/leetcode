package leetcode.P934_ShortestBridge;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;

        // 1. DFS to find and mark first island
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q);
                    found = true;
                }
            }
        }

        // 2. BFS to find second island
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dirs) {
                    int r = curr[0] + d[0], c = curr[1] + d[1];
                    if (r >= 0 && r < n && c >= 0 && c < n) {
                        if (grid[r][c] == 1)
                            return steps;
                        if (grid[r][c] == 0) {
                            grid[r][c] = -1; // Mark visited
                            q.add(new int[] { r, c });
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int[][] grid, int r, int c, Queue<int[]> q) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1)
            return;
        grid[r][c] = -1; // Mark visited
        q.add(new int[] { r, c });
        for (int[] d : dirs)
            dfs(grid, r + d[0], c + d[1], q);
    }
}
