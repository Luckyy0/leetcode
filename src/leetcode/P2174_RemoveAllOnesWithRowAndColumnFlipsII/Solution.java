package leetcode.P2174_RemoveAllOnesWithRowAndColumnFlipsII;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int initialState = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    initialState |= (1 << (i * n + j));
                }
            }
        }

        if (initialState == 0)
            return 0;

        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> vis = new HashSet<>();
        q.offer(initialState);
        vis.add(initialState);

        int steps = 0;

        while (!q.isEmpty()) {
            steps++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int curr = q.poll();

                // Try picking any 1 in curr
                // Optimization: Maybe we don't need to try ALL 1s.
                // But picking different 1s affects cost.
                // Scan for 1s.

                // For small constraints (m*n <= 15), iterating is fine.
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int bit = (1 << (i * n + j));
                        if ((curr & bit) != 0) {
                            // Pick (i, j)
                            // Remove row i, col j
                            int next = curr;

                            // Clear row i
                            for (int c = 0; c < n; c++) {
                                next &= ~(1 << (i * n + c));
                            }
                            // Clear col j
                            for (int r = 0; r < m; r++) {
                                next &= ~(1 << (r * n + j));
                            }

                            if (next == 0)
                                return steps;
                            if (vis.add(next)) {
                                q.offer(next);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
