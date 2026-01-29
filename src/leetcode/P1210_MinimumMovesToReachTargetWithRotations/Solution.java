package leetcode.P1210_MinimumMovesToReachTargetWithRotations;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        boolean[][][] visited = new boolean[n][n][2]; // 0: Horizontal, 1: Vertical
        Queue<int[]> q = new LinkedList<>();

        // Start: tail at (0,0), horizontal
        q.offer(new int[] { 0, 0, 0 });
        visited[0][0][0] = true;

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int orient = curr[2];

                // Target: tail at (n-1, n-2), horizontal
                if (r == n - 1 && c == n - 2 && orient == 0)
                    return steps;

                if (orient == 0) { // Horizontal
                    // Move right
                    if (c + 2 < n && grid[r][c + 2] == 0 && !visited[r][c + 1][0]) {
                        visited[r][c + 1][0] = true;
                        q.offer(new int[] { r, c + 1, 0 });
                    }
                    // Move down
                    if (r + 1 < n && grid[r + 1][c] == 0 && grid[r + 1][c + 1] == 0 && !visited[r + 1][c][0]) {
                        visited[r + 1][c][0] = true;
                        q.offer(new int[] { r + 1, c, 0 });
                    }
                    // Rotate CW
                    if (r + 1 < n && grid[r + 1][c] == 0 && grid[r + 1][c + 1] == 0 && !visited[r][c][1]) {
                        visited[r][c][1] = true;
                        q.offer(new int[] { r, c, 1 });
                    }
                } else { // Vertical
                    // Move right
                    if (c + 1 < n && grid[r][c + 1] == 0 && grid[r + 1][c + 1] == 0 && !visited[r][c + 1][1]) {
                        visited[r][c + 1][1] = true;
                        q.offer(new int[] { r, c + 1, 1 });
                    }
                    // Move down
                    if (r + 2 < n && grid[r + 2][c] == 0 && !visited[r + 1][c][1]) {
                        visited[r + 1][c][1] = true;
                        q.offer(new int[] { r + 1, c, 1 });
                    }
                    // Rotate CCW
                    if (c + 1 < n && grid[r][c + 1] == 0 && grid[r + 1][c + 1] == 0 && !visited[r][c][0]) {
                        visited[r][c][0] = true;
                        q.offer(new int[] { r, c, 0 });
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
