package leet_code.Problem_909_Medium_Snakes_and_Ladders;

import java.util.*;

/**
 * Problem 909: Snakes and Ladders
 * https://leetcode.com/problems/snakes-and-ladders/
 */
public class Solution {

    /**
     * Calculates the minimum number of moves to reach the final square.
     * Strategy: BFS since it's an unweighted shortest path problem.
     * 
     * @param board The Boustrophedon board.
     * @return Minimum moves.
     * 
     *         Tóm tắt chiến lược:
     *         1. Đây là bài toán tìm đường đi ngắn nhất trên đồ thị không trọng số
     *         -> Dùng BFS.
     *         2. Các đỉnh của đồ thị là các ô từ 1 đến N*N.
     *         3. Từ mỗi ô 'curr', ta có thể đi đến 'next' thuộc [curr+1, curr+6].
     *         4. Nếu ô 'next' có rắn hoặc thang (board[r][c] != -1), ta BẮT BUỘC
     *         phải nhảy đến đích của nó.
     *         - Lưu ý: Việc nhảy rắn/thang là tức thời và nằm trong cùng một nước
     *         đi.
     *         5. Cần hàm chuyển đổi từ số thứ tự ô 's' sang tọa độ (r, c) trên bảng
     *         vì bảng được đánh số theo kiểu Boustrophedon (ziczac từ dưới lên).
     *         6. Sử dụng mảng visited để tránh lặp lại trạng thái.
     */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n * n) {
                    return moves;
                }

                // Try all 6 possible dice rolls
                for (int k = 1; k <= 6; k++) {
                    int next = curr + k;
                    if (next > n * n)
                        break; // Cannot go beyond board

                    int[] pos = getCoordinates(next, n);
                    int r = pos[0];
                    int c = pos[1];

                    int dest = next;

                    // If there is a snake or ladder, go to its destination
                    if (board[r][c] != -1) {
                        dest = board[r][c];
                    }

                    // Only add to queue if not visited
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    /**
     * Converts square number 's' (1-indexed) to (row, col) coordinates.
     * Rows are indexed 0 to n-1 from top to bottom.
     * The board starts at bottom-left (n-1, 0).
     */
    private int[] getCoordinates(int s, int n) {
        int rFromBottom = (s - 1) / n;
        int r = n - 1 - rFromBottom; // Determine row index (0 is top)

        int c = (s - 1) % n;
        // If rFromBottom is odd (1, 3, 5...), traverse right-to-left
        // If rFromBottom is even (0, 2, 4...), traverse left-to-right
        if (rFromBottom % 2 == 1) {
            c = n - 1 - c;
        }

        return new int[] { r, c };
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] b1 = {
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 15, -1, -1, -1, -1 }
        };
        System.out.println("Result: " + sol.snakesAndLadders(b1)); // 4

        int[][] b2 = { { -1, -1 }, { -1, 3 } };
        System.out.println("Result: " + sol.snakesAndLadders(b2)); // 1
    }
}
