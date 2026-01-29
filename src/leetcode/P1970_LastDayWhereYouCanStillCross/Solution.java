package leetcode.P1970_LastDayWhereYouCanStillCross;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 0, high = cells.length; // careful, day is 1-based index or count
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canCross(row, col, cells, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    // Check if possible AFTER mid days (0 to mid-1 are water)
    private boolean canCross(int row, int col, int[][] cells, int days) {
        boolean[][] grid = new boolean[row][col]; // false = land, true = water
        for (int i = 0; i < days; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = true;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for (int j = 0; j < col; j++) {
            if (!grid[0][j]) {
                q.offer(new int[] { 0, j });
                visited[0][j] = true;
            }
        }

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if (r == row - 1)
                return true;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col && !grid[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[] { nr, nc });
                }
            }
        }

        return false;
    }
}
