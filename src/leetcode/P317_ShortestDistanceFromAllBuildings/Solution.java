package leetcode.P317_ShortestDistanceFromAllBuildings;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * Problem 317: Shortest Distance from All Buildings
     * Approach: BFS from each building
     * 
     * Time Complexity: O(K * M * N)
     * Space Complexity: O(M * N)
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;

        int m = grid.length;
        int n = grid[0].length;

        int[][] totalDist = new int[m][n];
        int[][] reachCount = new int[m][n];
        int buildingCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildingCount++;
                    if (!bfs(grid, i, j, m, n, totalDist, reachCount)) {
                        return -1; // Cannot reach all free lands? Or cannot reach anything?
                    }
                }
            }
        }

        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reachCount[i][j] == buildingCount) {
                    minDist = Math.min(minDist, totalDist[i][j]);
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private boolean bfs(int[][] grid, int startR, int startC, int m, int n, int[][] totalDist, int[][] reachCount) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startR, startC });

        boolean[][] visited = new boolean[m][n];
        visited[startR][startC] = true;

        int dist = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] d : dirs) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        totalDist[nr][nc] += dist;
                        reachCount[nr][nc]++;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
        }

        // Check if this building can reach ANY empty spot?
        // Actually, if a building is isolated by '2's or boundaries from valid 0s that
        // OTHER buildings reached,
        // it means we can never find a common spot.
        // However, standard logic: just run BFS. Validation happens at end.
        // Optional optimization: If we visited fewer 0s than previous buildings, prune.
        // But for simplicity, just return true.
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]] -> 7
        int[][] grid = {
                { 1, 0, 2, 0, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0 }
        };
        runTest(solution, grid, 7);

        // Impossible case
        // [[1, 2, 1]] -> 0s cannot reach both.
        // wait, 0 is reachable? No 0s? -1.

    }

    private static void runTest(Solution s, int[][] grid, int expected) {
        int result = s.shortestDistance(grid);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
