package leetcode.P1284_MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int start = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    start |= (1 << (i * n + j));
                }
            }
        }

        if (start == 0)
            return 0;

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        int steps = 0;
        while (!q.isEmpty()) {
            steps++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int curr = q.poll();

                // Try flipping each cell
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int next = flip(curr, i, j, m, n);
                        if (next == 0)
                            return steps;
                        if (visited.add(next)) {
                            q.offer(next);
                        }
                    }
                }
            }
        }

        return -1;
    }

    private int flip(int state, int r, int c, int m, int n) {
        // Flip (r, c)
        state ^= (1 << (r * n + c));
        // Neighbors
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                state ^= (1 << (nr * n + nc));
            }
        }
        return state;
    }
}
