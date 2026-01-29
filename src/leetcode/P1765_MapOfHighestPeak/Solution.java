package leetcode.P1765_MapOfHighestPeak;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        for (int[] row : height)
            Arrays.fill(row, -1);

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.offer(new int[] { i, j });
                }
            }
        }

        int[] dirs = { 0, 1, 0, -1, 0 };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dirs[k];
                int nc = c + dirs[k + 1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && height[nr][nc] == -1) {
                    height[nr][nc] = height[r][c] + 1;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }

        return height;
    }
}
