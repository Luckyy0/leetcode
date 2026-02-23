package leet_code.Problem_778_Hard_Swim_in_Rising_Water;

import java.util.PriorityQueue;

public class Solution {

    /**
     * Finds min time to reach bottom-right.
     * Strategy: Dijkstra's algorithm. Minimize the maximum cell value on path.
     * Time: O(N^2 log N), Space: O(N^2).
     */
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        // Priority Queue stores {max_height_so_far, r, c}
        // Orders by smallest max_height
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Push start point
        pq.offer(new int[] { grid[0][0], 0, 0 });

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int height = curr[0];
            int r = curr[1];
            int c = curr[2];

            // If reached target
            if (r == n - 1 && c == n - 1) {
                return height;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // The cost to reach neighbor is max(current_path_max, neighbor_height)
                    int newHeight = Math.max(height, grid[nr][nc]);
                    pq.offer(new int[] { newHeight, nr, nc });
                }
            }
        }

        return -1; // Should not reach here
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid1 = { { 0, 2 }, { 1, 3 } };
        System.out.println("Result 1: " + sol.swimInWater(grid1)); // 3

        int[][] grid2 = {
                { 0, 1, 2, 3, 4 },
                { 24, 23, 22, 21, 5 },
                { 12, 13, 14, 15, 16 },
                { 11, 17, 18, 19, 20 },
                { 10, 9, 8, 7, 6 }
        };
        System.out.println("Result 2: " + sol.swimInWater(grid2)); // 16
    }
}
