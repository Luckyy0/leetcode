package leetcode.P1036_EscapeALargeMaze;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    private static final int LIMIT = 20000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(hash(b[0], b[1]));
        }

        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    private boolean bfs(int[] start, int[] end, Set<Long> blockedSet) {
        Set<Long> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited.add(hash(start[0], start[1]));

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == end[0] && curr[1] == end[1])
                return true;

            if (visited.size() > LIMIT)
                return true;

            for (int[] d : dirs) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];
                long key = hash(r, c);

                if (r >= 0 && r < 1000000 && c >= 0 && c < 1000000 &&
                        !blockedSet.contains(key) && !visited.contains(key)) {
                    visited.add(key);
                    queue.add(new int[] { r, c });
                }
            }
        }

        return false;
    }

    // Simple hash for r, c < 10^6
    private long hash(int r, int c) {
        return ((long) r << 32) | c;
    }
}
