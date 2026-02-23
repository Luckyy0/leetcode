package leet_code.Problem_286_Medium_Walls_And_Gates;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_BFS {

    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;
    private static final int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    /**
     * Fills each empty room with the distance to its nearest gate.
     * Uses Multi-Source BFS.
     * Time: O(M*N), Space: O(M*N).
     * 
     * Điền vào mỗi phòng trống khoảng cách đến cổng gần nhất.
     * Sử dụng BFS Đa nguồn.
     */
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Push all gates into queue
        // Đẩy tất cả các cổng vào hàng đợi
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Keep moving if valid and is an empty room
                // Valid empty room means it has not been visited yet (value is INF)
                // Tiếp tục di chuyển nếu hợp lệ và là phòng trống
                // Phòng trống hợp lệ nghĩa là chưa được thăm (giá trị là INF)
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && rooms[nr][nc] == EMPTY) {
                    // Update distance
                    // Cập nhật khoảng cách
                    rooms[nr][nc] = rooms[r][c] + 1;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();

        // Test Case
        int[][] rooms = {
                { EMPTY, -1, 0, EMPTY },
                { EMPTY, EMPTY, EMPTY, -1 },
                { EMPTY, -1, EMPTY, -1 },
                { 0, -1, EMPTY, EMPTY }
        };

        solution.wallsAndGates(rooms);

        System.out.println("Walls and Gates:");
        for (int[] row : rooms) {
            for (int val : row) {
                System.out.print((val == EMPTY ? "INF" : val) + "\t");
            }
            System.out.println();
        }
    }
}
