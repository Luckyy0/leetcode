package leet_code.Problem_317_Hard_Shortest_Distance_From_All_Buildings;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_BFS {

    /**
     * Finds shortest total distance to all buildings.
     * Uses BFS from each building with reachability pruning.
     * Time: O(K * M * N), Space: O(M * N).
     * 
     * Tìm tổng khoảng cách ngắn nhất đến tất cả các tòa nhà.
     * Sử dụng BFS từ mỗi tòa nhà với việc cắt tỉa khả năng tiếp cận.
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;

        int m = grid.length;
        int n = grid[0].length;

        int[][] totalDist = new int[m][n];
        int[][] reachCount = new int[m][n];
        int buildingCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!bfs(grid, i, j, m, n, totalDist, reachCount, buildingCount)) {
                        return -1; // Cannot reach all previous reachable nodes?
                    }
                    buildingCount++;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Must be empty land (0) and reachable by ALL buildings
                // Phải là đất trống (0) và có thể truy cập bởi TẤT CẢ các tòa nhà
                if (grid[i][j] == 0 && reachCount[i][j] == buildingCount) {
                    minDistance = Math.min(minDistance, totalDist[i][j]);
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    // Returns true if BFS completed successfully (potentially reachable).
    // Actually we don't need boolean return if we trust the logic.
    // Pruning: We only visit cells that have 'reachCount' equal to current
    // 'buildingIdx'.
    // If a cell was not reached by block 0, block 1 shouldn't visit it either.
    private boolean bfs(int[][] grid, int startRow, int startCol, int m, int n,
            int[][] totalDist, int[][] reachCount, int buildingIdx) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startRow, startCol });

        boolean[][] visited = new boolean[m][n];
        visited[startRow][startCol] = true;

        int steps = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();

                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if (r >= 0 && r < m && c >= 0 && c < n &&
                            !visited[r][c] && grid[r][c] == 0) {

                        // Pruning check: If this cell wasn't reached by previous buildings, skip
                        // Kiểm tra cắt tỉa: Nếu ô này không được các tòa nhà trước đó tiếp cận, bỏ qua
                        if (reachCount[r][c] == buildingIdx) {
                            visited[r][c] = true;
                            totalDist[r][c] += steps;
                            reachCount[r][c]++;
                            queue.offer(new int[] { r, c });
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();

        // Test Case 1: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]] -> 7
        int[][] grid1 = {
                { 1, 0, 2, 0, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0 }
        };
        System.out.println("Min Dist 1: " + solution.shortestDistance(grid1));

        // Test Case 2: [[1]] -> -1
        int[][] grid2 = { { 1 } };
        System.out.println("Min Dist 2: " + solution.shortestDistance(grid2));
    }
}
