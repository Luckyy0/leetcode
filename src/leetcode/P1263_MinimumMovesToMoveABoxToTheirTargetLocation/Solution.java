package leetcode.P1263_MinimumMovesToMoveABoxToTheirTargetLocation;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int startPr = 0, startPc = 0, startBr = 0, startBc = 0, targetR = 0, targetC = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    startPr = i;
                    startPc = j;
                } else if (grid[i][j] == 'B') {
                    startBr = i;
                    startBc = j;
                } else if (grid[i][j] == 'T') {
                    targetR = i;
                    targetC = j;
                }
            }
        }

        // State: br * n * m * n + bc * m * n + pr * n + pc (flattened for visited)
        // Or boolean[m][n][m][n]
        boolean[][][][] visited = new boolean[m][n][m][n];
        Deque<int[]> q = new ArrayDeque<>();

        // {boxR, boxC, playerR, playerC, pushes}
        q.offerLast(new int[] { startBr, startBc, startPr, startPc, 0 });
        visited[startBr][startBc][startPr][startPc] = true;

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int[] curr = q.pollFirst();
            int br = curr[0], bc = curr[1], pr = curr[2], pc = curr[3], pushes = curr[4];

            if (br == targetR && bc == targetC)
                return pushes;

            // 1. Move Player (Cost 0)
            for (int[] d : dirs) {
                int npr = pr + d[0];
                int npc = pc + d[1];

                if (npr >= 0 && npr < m && npc >= 0 && npc < n && grid[npr][npc] != '#' && (npr != br || npc != bc)) {
                    if (!visited[br][bc][npr][npc]) {
                        visited[br][bc][npr][npc] = true;
                        q.offerFirst(new int[] { br, bc, npr, npc, pushes });
                    }
                }
            }

            // 2. Push Box (Cost 1)
            // Player must be adjacent to box, and pushes it.
            // Check if player is adjacent to box (handled implicitly by being at pr, pc
            // next to box)
            // Wait, logic: if player moves INTO box position, it pushes box.
            // Check reachable neighbors for push
            for (int[] d : dirs) {
                int npr = pr + d[0];
                int npc = pc + d[1];

                // If player moves to box pos
                if (npr == br && npc == bc) {
                    // Box moves in same direction
                    int nbr = br + d[0];
                    int nbc = bc + d[1];

                    if (nbr >= 0 && nbr < m && nbc >= 0 && nbc < n && grid[nbr][nbc] != '#') {
                        if (!visited[nbr][nbc][npr][npc]) { // Player is now at old box pos
                            visited[nbr][nbc][npr][npc] = true;
                            q.offerLast(new int[] { nbr, nbc, npr, npc, pushes + 1 });
                        }
                    }
                }
            }
        }

        return -1;
    }
}
