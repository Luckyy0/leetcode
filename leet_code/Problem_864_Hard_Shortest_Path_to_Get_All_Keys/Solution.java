package leet_code.Problem_864_Hard_Shortest_Path_To_Get_All_Keys;

import java.util.*;

/**
 * Problem 864: Shortest Path to Get All Keys
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/
 */
public class Solution {

    /**
     * Finds the shortest path to collect all keys in a grid.
     * Strategy: BFS with a state consisting of (row, col, keyBitmask).
     * 
     * @param grid String array representing the grid.
     * @return Shortest number of moves or -1.
     * 
     *         Tóm tắt chiến lược:
     *         Chúng ta sử dụng trạng thái (hàng, cột, mặt nạ bit chìa khóa) để thực
     *         hiện BFS.
     *         Một ô có thể được ghé thăm nhiều lần nếu chúng ta có bộ chìa khóa
     *         khác nhau.
     *         Mặt nạ bit (mask) tối đa là 6 bit (2^6 = 64). Khi nMask đạt đến trạng
     *         thái
     *         có tất cả các bit của số chìa khóa, chúng ta trả về số bước.
     */
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int startR = -1, startC = -1, numKeys = 0;

        // Step 1: Locate starting point and total number of keys
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    startR = i;
                    startC = j;
                } else if (ch >= 'a' && ch <= 'f') {
                    numKeys++;
                }
            }
        }

        int allKeysMask = (1 << numKeys) - 1;

        // Queue stores [row, col, mask]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startR, startC, 0 });

        // visited[row][col][mask]
        boolean[][][] visited = new boolean[m][n][1 << numKeys];
        visited[startR][startC][0] = true;

        int steps = 0;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];

                // If we have all keys, return the steps
                if (mask == allKeysMask)
                    return steps;

                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    // Boundary check
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;

                    char cell = grid[nr].charAt(nc);

                    // Wall check
                    if (cell == '#')
                        continue;

                    // Lock check: if it's a lock and we don't have the key, skip
                    if (cell >= 'A' && cell <= 'F') {
                        if ((mask & (1 << (cell - 'A'))) == 0)
                            continue;
                    }

                    // Key collection
                    int nMask = mask;
                    if (cell >= 'a' && cell <= 'f') {
                        nMask |= (1 << (cell - 'a'));
                    }

                    // Visited check with current key set
                    if (!visited[nr][nc][nMask]) {
                        visited[nr][nc][nMask] = true;
                        queue.offer(new int[] { nr, nc, nMask });
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] g1 = { "@.a..", "###.#", "b.A.B" };
        System.out.println("Result: " + sol.shortestPathAllKeys(g1)); // 8

        String[] g2 = { "@..aA", "..B#.", "....b" };
        System.out.println("Result: " + sol.shortestPathAllKeys(g2)); // 6

        String[] g3 = { "@Aa" };
        System.out.println("Result: " + sol.shortestPathAllKeys(g3)); // -1
    }
}
