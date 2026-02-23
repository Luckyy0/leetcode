package leet_code.Problem_289_Medium_Game_Of_Life;

public class Solution_InPlace {

    // Neighbors relative coordinates
    private final int[][] neighbors = {
            { -1, -1 }, { -1, 0 }, { -1, 1 },
            { 0, -1 }, { 0, 1 },
            { 1, -1 }, { 1, 0 }, { 1, 1 }
    };

    /**
     * Computes the next state of the Game of Life board.
     * Uses bit manipulation to store next state in the 2nd bit.
     * Time: O(M*N), Space: O(1).
     * 
     * Tính toán trạng thái tiếp theo của bàn cờ Game of Life.
     * Sử dụng thao tác bit để lưu trạng thái tiếp theo vào bit thứ 2.
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        // Pass 1: Calculate next state for each cell
        // Lượt 1: Tính trạng thái tiếp theo cho mỗi ô
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                // Đếm số hàng xóm sống
                for (int[] dir : neighbors) {
                    int r = i + dir[0];
                    int c = j + dir[1];

                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        // Check logic: current state is in the least significant bit
                        // Kiểm tra logic: trạng thái hiện tại nằm ở bit có trọng số thấp nhất
                        if ((board[r][c] & 1) == 1) {
                            liveNeighbors++;
                        }
                    }
                }

                // Apply rules
                // 1. Live (1) with 2 or 3 neighbors -> Live (11 -> 3)
                // 2. Dead (0) with 3 neighbors -> Live (10 -> 2)
                // We only need to check when next state is 1, and set bit 1 (val |= 2)

                if ((board[i][j] & 1) == 1) { // Currently Alive
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        board[i][j] |= 2; // Next state Alive
                    }
                    // Else dies (bit 1 remains 0)
                } else { // Currently Dead
                    if (liveNeighbors == 3) {
                        board[i][j] |= 2; // Next state Alive
                    }
                }
            }
        }

        // Pass 2: Update to next state
        // Lượt 2: Cập nhật sang trạng thái tiếp theo
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1; // Shift right to make bit 1 the new bit 0
            }
        }
    }

    public static void main(String[] args) {
        Solution_InPlace solution = new Solution_InPlace();

        // Test Case
        int[][] board = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };

        solution.gameOfLife(board);

        System.out.println("Next Gen:");
        for (int[] row : board) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
