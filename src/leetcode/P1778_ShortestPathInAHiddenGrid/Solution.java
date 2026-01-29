package leetcode.P1778_ShortestPathInAHiddenGrid;

import java.util.LinkedList;
import java.util.Queue;

// Mock interface
interface GridMaster {
    boolean canMove(char direction);

    void move(char direction);

    boolean isTarget();
}

public class Solution {
    private static final int SIZE = 1001;
    private static final int OFFSET = 500;
    // 0: unvisited/unknown, 1: accessible, 2: blocked (actually can use visited
    // array), 3: target
    // Let's use:
    // grid[x][y]:
    // 0: unvisited
    // 1: empty
    // 2: target
    // -1: blocked
    private int[][] grid = new int[SIZE][SIZE];
    private boolean[][] visitedDFS = new boolean[SIZE][SIZE];

    // U, D, L, R
    private char[] forward = { 'U', 'D', 'L', 'R' };
    private char[] backward = { 'D', 'U', 'R', 'L' };
    private int[] dr = { -1, 1, 0, 0 };
    private int[] dc = { 0, 0, -1, 1 };

    public int findShortestPath(GridMaster master) {
        // Step 1: DFS to map grid
        if (master.isTarget()) {
            grid[OFFSET][OFFSET] = 2; // Start is target
            return 0;
        } else {
            grid[OFFSET][OFFSET] = 1;
        }

        dfs(master, OFFSET, OFFSET);

        // Step 2: BFS for distance
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { OFFSET, OFFSET, 0 });
        boolean[][] visitedBFS = new boolean[SIZE][SIZE];
        visitedBFS[OFFSET][OFFSET] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if (grid[r][c] == 2)
                return dist;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < SIZE && nc >= 0 && nc < SIZE && !visitedBFS[nr][nc] && grid[nr][nc] != 0
                        && grid[nr][nc] != -1) {
                    visitedBFS[nr][nc] = true;
                    q.offer(new int[] { nr, nc, dist + 1 });
                }
            }
        }

        return -1;
    }

    private void dfs(GridMaster master, int r, int c) {
        visitedDFS[r][c] = true;
        if (master.isTarget()) {
            grid[r][c] = 2;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (visitedDFS[nr][nc])
                continue;

            if (master.canMove(forward[i])) {
                master.move(forward[i]);
                grid[nr][nc] = master.isTarget() ? 2 : 1;
                dfs(master, nr, nc);
                master.move(backward[i]); // Backtrack
            } else {
                grid[nr][nc] = -1; // Blocked
            }
        }
    }
}
