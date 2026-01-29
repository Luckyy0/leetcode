package leetcode.P864_ShortestPathToGetAllKeys;

import java.util.*;

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int startR = -1, startC = -1, keysCount = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = grid[r].charAt(c);
                if (ch == '@') {
                    startR = r;
                    startC = c;
                } else if (ch >= 'a' && ch <= 'f')
                    keysCount++;
            }
        }

        int targetMask = (1 << keysCount) - 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startR, startC, 0 });
        boolean[][][] visited = new boolean[m][n][targetMask + 1];
        visited[startR][startC][0] = true;

        int steps = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1], mask = curr[2];

                if (mask == targetMask)
                    return steps;

                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;

                    char ch = grid[nr].charAt(nc);
                    if (ch == '#')
                        continue;

                    int nextMask = mask;
                    if (ch >= 'a' && ch <= 'f') {
                        nextMask |= (1 << (ch - 'a'));
                    } else if (ch >= 'A' && ch <= 'F') {
                        if (((mask >> (ch - 'A')) & 1) == 0)
                            continue;
                    }

                    if (!visited[nr][nc][nextMask]) {
                        visited[nr][nc][nextMask] = true;
                        queue.add(new int[] { nr, nc, nextMask });
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
