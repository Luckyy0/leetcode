package leetcode.P1197_MinimumKnightMoves;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int steps = 0;
        int[][] dirs = { { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 } };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int cx = curr[0];
                int cy = curr[1];

                if (cx == x && cy == y)
                    return steps;

                for (int[] d : dirs) {
                    int nx = cx + d[0];
                    int ny = cy + d[1];

                    // Pruning:
                    // 1. Symmetry allows focusing on positive quadrant principally, but nearby
                    // negatives needed.
                    // 2. Don't go too far beyond target.
                    if (!visited.contains(nx + "," + ny) && nx >= -2 && ny >= -2) {
                        // Very rough heuristic pruning: max(x, y) + 2?
                        // Let's settle for visited check + small negative buffer.
                        // Ideally we should limit upper bound too?
                        // If nx > x + 4 or ny > y + 4 maybe prune.
                        // Standard BFS passes without strict uper bound on LeetCode usually if visited
                        // check works.
                        // But let's add bound.

                        visited.add(nx + "," + ny);
                        q.offer(new int[] { nx, ny });
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
