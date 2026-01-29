package leetcode.P407_TrappingRainWaterII;

import java.util.PriorityQueue;

public class Solution {

    private static class Cell {
        int r, c, h;

        Cell(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    /**
     * Problem 407: Trapping Rain Water II
     * Approach: Min-Priority Queue starting from Boundary
     * 
     * Time Complexity: O(M * N * log(MN))
     * Space Complexity: O(M * N)
     */
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.h - b.h);

        // Add boundary cells to PQ and mark as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int water = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();

            for (int[] dir : dirs) {
                int nr = curr.r + dir[0];
                int nc = curr.c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // If neighbor is lower than boundary, trap water
                    water += Math.max(0, curr.h - heightMap[nr][nc]);
                    // Push neighbor into PQ with updated height (max of self and boundary)
                    pq.offer(new Cell(nr, nc, Math.max(heightMap[nr][nc], curr.h)));
                }
            }
        }

        return water;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1 -> 4
        int[][] map1 = {
                { 1, 4, 3, 1, 3, 2 },
                { 3, 2, 1, 3, 2, 4 },
                { 2, 3, 3, 2, 3, 1 }
        };
        runTest(solution, map1, 4);

        // Example 2 -> 10
        int[][] map2 = {
                { 3, 3, 3, 3, 3 },
                { 3, 2, 2, 2, 3 },
                { 3, 2, 1, 2, 3 },
                { 3, 2, 2, 2, 3 },
                { 3, 3, 3, 3, 3 }
        };
        runTest(solution, map2, 10);
    }

    private static void runTest(Solution sol, int[][] map, int expected) {
        int result = sol.trapRainWater(map);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
