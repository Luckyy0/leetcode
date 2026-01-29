package leetcode.P542_01Matrix;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize queue with all 0s and set 1s to infinity (or unvisited)
        // Khởi tạo hàng đợi với tất cả các số 0 và thiết lập các số 1 thành vô cùng
        // (hoặc chưa thăm)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[] { i, j });
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        // BFS traversal
        // Duyệt BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1];

            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (dist[nx][ny] > dist[cx][cy] + 1) {
                        dist[nx][ny] = dist[cx][cy] + 1;
                        queue.offer(new int[] { nx, ny });
                    }
                }
            }
        }

        return dist;
    }
}
