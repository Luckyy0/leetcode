package leetcode.P1810_MinimumPathCostInAHiddenGrid;

import java.util.PriorityQueue;
import java.util.Arrays;

// Mock interface
interface GridMaster {
    boolean canMove(char direction);

    int move(char direction); // Returns cost

    boolean isTarget();
}

public class Solution {
    private static final int SIZE = 201; // Assuming small grid as per usual constraints (100x100)
    private static final int OFFSET = 100;

    // gridCost[r][c][dirIndex]
    // 0: U, 1: D, 2: L, 3: R
    // However, cost is edge attribute.
    // Let's store edges in adj matrix or similar.
    // Or grid[r][c] stores type (empty/target), and we store costs in a map or 3D
    // array?
    // Cost to enter a cell? Or cost of edge? "Cost to move". Usually edge weight.

    private int[][] grid = new int[SIZE][SIZE]; // 0: unknown, 1: empty, 2: target, -1: blocked
    private int[][][] costs = new int[SIZE][SIZE][4]; // cost to move from [r][c] in direction i

    private char[] forward = { 'U', 'D', 'L', 'R' };
    private char[] backward = { 'D', 'U', 'R', 'L' };
    private int[] dr = { -1, 1, 0, 0 };
    private int[] dc = { 0, 0, -1, 1 };

    public int findShortestPath(GridMaster master) {
        // Init
        for (int[] row : grid)
            Arrays.fill(row, 0);

        // DFS Map
        if (master.isTarget()) {
            grid[OFFSET][OFFSET] = 2;
        } else {
            grid[OFFSET][OFFSET] = 1;
        }

        dfs(master, OFFSET, OFFSET);

        // Dijkstra
        int[][] dist = new int[SIZE][SIZE];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] { OFFSET, OFFSET, 0 });
        dist[OFFSET][OFFSET] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if (d > dist[r][c])
                continue;
            if (grid[r][c] == 2)
                return d;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < SIZE && nc >= 0 && nc < SIZE && grid[nr][nc] != 0 && grid[nr][nc] != -1) {
                    // Check if edge exists (explored)
                    // If we visited nr during DFS, we recorded cost.
                    // Note: DFS ensures reachability.
                    int weight = costs[r][c][i];
                    if (weight > 0) { // Valid edge
                        if (dist[r][c] + weight < dist[nr][nc]) {
                            dist[nr][nc] = dist[r][c] + weight;
                            pq.offer(new int[] { nr, nc, dist[nr][nc] });
                        }
                    }
                }
            }
        }

        return -1;
    }

    private void dfs(GridMaster master, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (grid[nr][nc] != 0)
                continue; // Already visited/blocked

            if (master.canMove(forward[i])) {
                int cost = master.move(forward[i]);
                costs[r][c][i] = cost;
                // Since undirected usually, assuming symmetric cost moving back?
                // The problem statement for P1810 says "cost to move... is separate for each
                // direction".
                // So we can't assume backward cost is same. We record what we see.
                // But wait, to come back we call move(backward[i]).
                // We should record THAT cost too.

                if (master.isTarget())
                    grid[nr][nc] = 2;
                else
                    grid[nr][nc] = 1;

                // Record reverse edge cost for Dijkstra later?
                // Actually we execute move(backward) when backtracking.
                // We will record it then? No, backtracking is just `move`, not `dfs`.
                // We need to capture the cost of moving back right now to fill
                // `costs[nr][nc][backward_idx]`.
                int backIdx = -1;
                if (i == 0)
                    backIdx = 1; // U -> D
                else if (i == 1)
                    backIdx = 0; // D -> U
                else if (i == 2)
                    backIdx = 3; // L -> R
                else if (i == 3)
                    backIdx = 2; // R -> L

                // We recurse
                dfs(master, nr, nc);

                // Backtrack
                int backCost = master.move(backward[i]);
                costs[nr][nc][backIdx] = backCost;

            } else {
                grid[nr][nc] = -1;
            }
        }
    }
}
