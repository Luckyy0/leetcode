package leetcode.P286_WallsAndGates;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * Problem 286: Walls and Gates
     * Approach: Multi-source BFS
     * 
     * Theoretical Basis:
     * - Start BFS from all gates to fill distances.
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */

    private static final int INF = 2147483647;
    private static final int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0)
            return;

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // 1. Enqueue all gates
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        // 2. BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check bounds and if it's an empty room
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && rooms[nr][nc] == INF) {
                    rooms[nr][nc] = rooms[r][c] + 1;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // INF -1 0 INF
        // INF INF INF -1
        // INF -1 INF -1
        // 0 -1 INF INF
        int[][] rooms = {
                { INF, -1, 0, INF },
                { INF, INF, INF, -1 },
                { INF, -1, INF, -1 },
                { 0, -1, INF, INF }
        };

        solution.wallsAndGates(rooms);

        System.out.println("Result Grid:");
        for (int[] row : rooms) {
            System.out.println(Arrays.toString(row));
        }

        // Expected:
        // [3, -1, 0, 1]
        // [2, 2, 1, -1]
        // [1, -1, 2, -1]
        // [0, -1, 3, 4]

        int[][] expected = {
                { 3, -1, 0, 1 },
                { 2, 2, 1, -1 },
                { 1, -1, 2, -1 },
                { 0, -1, 3, 4 }
        };

        if (Arrays.deepEquals(rooms, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
