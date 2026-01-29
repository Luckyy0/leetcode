package leetcode.P1391_CheckIfThereIsAValidPathInAGrid;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if (r == m - 1 && c == n - 1)
                return true;

            int type = grid[r][c];

            // Check Right
            if (canGoRight(type)) {
                int nr = r, nc = c + 1;
                if (isValid(nr, nc, m, n) && !visited[nr][nc] && canReceiveLeft(grid[nr][nc])) {
                    visited[nr][nc] = true;
                    q.offer(new int[] { nr, nc });
                }
            }

            // Check Left
            if (canGoLeft(type)) {
                int nr = r, nc = c - 1;
                if (isValid(nr, nc, m, n) && !visited[nr][nc] && canReceiveRight(grid[nr][nc])) {
                    visited[nr][nc] = true;
                    q.offer(new int[] { nr, nc });
                }
            }

            // Check Down
            if (canGoDown(type)) {
                int nr = r + 1, nc = c;
                if (isValid(nr, nc, m, n) && !visited[nr][nc] && canReceiveUp(grid[nr][nc])) {
                    visited[nr][nc] = true;
                    q.offer(new int[] { nr, nc });
                }
            }

            // Check Up
            if (canGoUp(type)) {
                int nr = r - 1, nc = c;
                if (isValid(nr, nc, m, n) && !visited[nr][nc] && canReceiveDown(grid[nr][nc])) {
                    visited[nr][nc] = true;
                    q.offer(new int[] { nr, nc });
                }
            }
        }

        return false;
    }

    private boolean isValid(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    // Outgoing rules
    private boolean canGoRight(int type) {
        return type == 1 || type == 4 || type == 6;
    }

    private boolean canGoLeft(int type) {
        return type == 1 || type == 3 || type == 5;
    }

    private boolean canGoDown(int type) {
        return type == 2 || type == 3 || type == 4;
    }

    private boolean canGoUp(int type) {
        return type == 2 || type == 5 || type == 6;
    }

    // Incoming rules (Reverse logic)
    // If I move Right to neighbor, neighbor must accept connection from Left.
    private boolean canReceiveLeft(int type) {
        return canGoLeft(type);
    }

    private boolean canReceiveRight(int type) {
        return canGoRight(type);
    }

    private boolean canReceiveUp(int type) {
        return canGoUp(type);
    }

    private boolean canReceiveDown(int type) {
        return canGoDown(type);
    }
}
