package leet_code.Problem_934_Medium_Shortest_Bridge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 934: Shortest Bridge
 * https://leetcode.com/problems/shortest-bridge/
 */
public class Solution {

    // Directions for moving in the grid (up, down, left, right)
    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    /**
     * Finds the smallest number of 0s to flip to connect the two islands.
     * Strategy: DFS to find the first island, then BFS to find the shortest path to
     * the second.
     * 
     * @param grid n x n binary matrix.
     * @return Minimum flips.
     * 
     *         Tóm tắt chiến lược:
     *         1. Tìm hòn đảo đầu tiên bằng cách quét qua lưới cho đến khi gặp số 1
     *         đầu tiên.
     *         2. Sử dụng DFS để đánh dấu tất cả các ô của hòn đảo này (ví dụ: đổi
     *         thành 2)
     *         và thêm chúng vào hàng đợi (Queue) khởi tạo cho BFS.
     *         3. Bắt đầu BFS đa nguồn từ tất cả các ô của hòn đảo đầu tiên, mở rộng
     *         ra các ô nước (0) xung quanh.
     *         4. Trong quá trình BFS, mỗi lớp mở rộng tương ứng với 1 bước di
     *         chuyển (1 lần lật số 0).
     *         5. Khi gặp một ô có giá trị 1 (chưa được đánh dấu), đó chính là hòn
     *         đảo thứ hai.
     *         Số bước đã thực hiện chính là kết quả cần tìm.
     */
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean foundFirstIsland = false;

        // 1. Find and mark the first island using DFS
        for (int i = 0; i < n; i++) {
            if (foundFirstIsland)
                break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfsAndMark(grid, i, j, n, queue);
                    foundFirstIsland = true;
                    break;
                }
            }
        }

        // 2. Expand from the first island using BFS to reach the second island
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process layer by layer
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] d : DIRS) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            // Found the second island!
                            return steps;
                        } else if (grid[nr][nc] == 0) {
                            // Expand into water, mark as visited (2)
                            grid[nr][nc] = 2;
                            queue.offer(new int[] { nr, nc });
                        }
                    }
                }
            }
            // Increment steps after finishing a layer of 0s
            steps++;
        }

        return -1; // Should not reach here given problem constraints
    }

    // Helper DFS to find all connected components of the first island
    private void dfsAndMark(int[][] grid, int r, int c, int n, Queue<int[]> queue) {
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) {
            return;
        }

        // Mark as visited part of first island (2)
        grid[r][c] = 2;
        // Add to queue for BFS starting points
        queue.offer(new int[] { r, c });

        // Continue DFS in 4 directions
        for (int[] d : DIRS) {
            dfsAndMark(grid, r + d[0], c + d[1], n, queue);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] g1 = { { 0, 1 }, { 1, 0 } };
        System.out.println("Result: " + sol.shortestBridge(g1)); // 1

        int[][] g2 = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
        System.out.println("Result: " + sol.shortestBridge(g2)); // 2

        int[][] g3 = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
        System.out.println("Result: " + sol.shortestBridge(g3)); // 1
    }
}
