package leet_code.Problem_407_Hard_Trapping_Rain_Water_II;

import java.util.*;

public class Solution_MinHeap {

    static class Cell {
        int r, c, h;

        Cell(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    /**
     * Trapping Rain Water II in 2D map.
     * Uses Min-Heap to process cells from boundary inward.
     * Time: O(MN log MN), Space: O(MN).
     * 
     * Hứng nước mưa II trong bản đồ 2D.
     * Sử dụng Min-Heap để xử lý các ô từ biên giới vào trong.
     */
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2)
            return 0;

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.h - b.h);

        // Add all boundary cells
        // Thêm tất cả các ô biên giới
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = visited[m - 1][j] = true;
        }

        int totalWater = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();

            for (int[] d : dirs) {
                int nr = curr.r + d[0];
                int nc = curr.c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // Trap water if neighbor is shorter than current boundary height
                    // Hứng nước nếu ô lân cận thấp hơn chiều cao biên giới hiện tại
                    totalWater += Math.max(0, curr.h - heightMap[nr][nc]);
                    // Push neighbor with the 'effective' boundary height
                    // Đẩy ô lân cận với chiều cao biên giới 'hiệu dụng'
                    pq.offer(new Cell(nr, nc, Math.max(heightMap[nr][nc], curr.h)));
                }
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Solution_MinHeap solution = new Solution_MinHeap();

        // Test Case 1: 4
        int[][] h1 = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
        System.out.println("Result 1: " + solution.trapRainWater(h1));

        // Test Case 2: 10
        int[][] h2 = { { 3, 3, 3, 3, 3 }, { 3, 2, 2, 2, 3 }, { 3, 2, 1, 2, 3 }, { 3, 2, 2, 2, 3 }, { 3, 3, 3, 3, 3 } };
        System.out.println("Result 2: " + solution.trapRainWater(h2));
    }
}
