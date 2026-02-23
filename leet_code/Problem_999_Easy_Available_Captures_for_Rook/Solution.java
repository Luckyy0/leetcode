package leet_code.Problem_999_Easy_Available_Captures_for_Rook;

/**
 * Problem 999: Available Captures for Rook
 * https://leetcode.com/problems/available-captures-for-rook/
 */
public class Solution {

    /**
     * Identifies how many pawns a rook can capture.
     * Strategy: Ray-casting across the board.
     * 
     * @param board The 8x8 chessboard.
     * @return Number of available captures.
     * 
     *         Tóm tắt chiến lược:
     *         1. Bàn cờ luồn cố định có kích thước 8x8.
     *         2. Đầu tiên, ta cần tìm vị trí (r, c) của quân Xe trắng 'R'.
     *         Sử dụng hai vòng lặp lồng nhau qua 64 ô để xác định.
     *         3. Xe chỉ có thể di chuyển theo 4 hướng chính (Trên, Dưới, Trái,
     *         Phải).
     *         Ta định nghĩa 4 vector hướng: `[-1, 0]`, `[1, 0]`, `[0, -1]`, `[0,
     *         1]`.
     *         4. Bắt đầu phóng tia (ray-casting) từ vị trí của Xe theo từng hướng:
     *         - Di chuyển biến tọa độ `curR`, `curC` dọc theo vector hướng đó.
     *         - Nếu `[curR, curC]` chạy ra khỏi mép bàn cờ, ta dừng vòng lặp của
     *         hướng này lại.
     *         - Nếu đụng `B` (quân Tượng đồng minh), ta dừng ngay lập tức vì không
     *         thể nhảy qua nó.
     *         - Nếu đụng `p` (quân Tốt phe địch), ta TĂNG biến đếm `captures` (bắt
     *         được cờ), rồi CŨNG DỪNG ngay lập tức vì Xe không thể đâm xuyên qua để
     *         bắt thêm một quân Tốt khác đằng sau nó.
     *         - Nếu trên đường đi chỉ là khoảng trống `.`, tiếp tục tịnh tiến
     *         `curR` và `curC`.
     *         5. Trả về tổng lượng `captures`.
     */
    public int numRookCaptures(char[][] board) {
        int r = -1;
        int c = -1;

        // Step 1: Find the Rook's position (r, c)
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                    break;
                }
            }
        }

        int captures = 0;

        // Define the 4 cardinal directions: Up, Down, Left, Right
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        // Step 2: Cast a ray in each of the 4 directions
        for (int[] dir : directions) {
            int curR = r + dir[0];
            int curC = c + dir[1];

            // Step 3: Keep moving until we hit the edge of the board
            while (curR >= 0 && curR < 8 && curC >= 0 && curC < 8) {
                // If we hit a bishop, the rook's path is blocked
                if (board[curR][curC] == 'B') {
                    break;
                }
                // If we hit a pawn, capture it and stop moving in this direction
                else if (board[curR][curC] == 'p') {
                    captures++;
                    break;
                }

                // Continue moving in the same direction
                curR += dir[0];
                curC += dir[1];
            }
        }

        return captures;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] b1 = {
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', 'p', '.', '.', '.', '.' },
                { '.', '.', '.', 'R', '.', '.', '.', 'p' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', 'p', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' }
        };
        System.out.println("Result 1: " + sol.numRookCaptures(b1)); // 3
    }
}
